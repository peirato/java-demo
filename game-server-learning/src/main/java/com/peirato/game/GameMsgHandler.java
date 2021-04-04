package com.peirato.game;

import com.peirato.game.msg.GameMsgProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.BinaryWebSocketFrame;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户端消息处理器
 */
public class GameMsgHandler extends SimpleChannelInboundHandler<Object> {

    /**
     * 客户端信道数组
     */
    static private final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    /**
     * 用户字典
     */
    static private final Map<Integer, User> USER_MAP = new HashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("收到客户端消息 ,msg = " + msg);

/// 添加了解码器之后 这些就不能用了
//        // WebSocket 二进制消息会通过 HttpServerCodec 解码cheng BinaryWebSocketFrame 类对象
//        BinaryWebSocketFrame frame = (BinaryWebSocketFrame) msg;
//        ByteBuf byteBuf = frame.content();
//
//        // 拿到真实的字节数组 并打印
//        byte[] byteArray = new byte[byteBuf.readableBytes()];
//        byteBuf.readBytes(byteArray);
//
//        System.out.println("收到的字节 = ");
//
//        for (byte b : byteArray) {
//            System.out.println(b + ",");
//        }
///

        if (msg instanceof GameMsgProtocol.UserEntryCmd) {
            // 从指定对象中回去用户Id和英雄形象
            GameMsgProtocol.UserEntryCmd cmd = (GameMsgProtocol.UserEntryCmd) msg;
            int userId = cmd.getUserId();
            String heroAvatar = cmd.getHeroAvatar();

            GameMsgProtocol.UserEntryResult.Builder resultBuilder =
                    GameMsgProtocol.UserEntryResult.newBuilder();
            resultBuilder.setUserId(userId);
            resultBuilder.setHeroAvatar(heroAvatar);

            // 记录所有在线用户
            User newUser = new User();
            newUser.setUserId(userId);
            newUser.setHeroAvatar(heroAvatar);
            USER_MAP.put(userId, newUser);

            // 将用户 id 附着到 Channel
            ctx.channel().attr(AttributeKey.valueOf("userId")).set(userId);

            // 构建结果并发送
            GameMsgProtocol.UserEntryResult newResult = resultBuilder.build();
            CHANNEL_GROUP.writeAndFlush(newResult);
        } else if (msg instanceof GameMsgProtocol.WhoElseIsHereCmd) {
            // 同步在线用户数据

            // 将谁在场的消息返回
            GameMsgProtocol.WhoElseIsHereResult.Builder resultBuilder =
                    GameMsgProtocol.WhoElseIsHereResult.newBuilder();

            // 便利获取所有的在线用户
            for (User u : USER_MAP.values()) {
                if (null == u) {
                    continue;
                }

                GameMsgProtocol.WhoElseIsHereResult.UserInfo.Builder userInfoOrBuilder
                        = GameMsgProtocol.WhoElseIsHereResult.UserInfo.newBuilder();

                userInfoOrBuilder.setUserId(u.getUserId());
                userInfoOrBuilder.setHeroAvatar(u.getHeroAvatar());
                resultBuilder.addUserInfo(userInfoOrBuilder);
            }

            GameMsgProtocol.WhoElseIsHereResult newResult = resultBuilder.build();
            ctx.writeAndFlush(newResult);

        } else if (msg instanceof GameMsgProtocol.UserMoveToCmd) {
            // 用户移动逻辑

            // 取用户id
            Integer userId = (Integer) ctx.channel().attr(AttributeKey.valueOf("userId")).get();

            if (null == userId) {
                return;
            }

            GameMsgProtocol.UserMoveToCmd cmd = (GameMsgProtocol.UserMoveToCmd) msg;

            GameMsgProtocol.UserMoveToResult.Builder resultBuilder =
                    GameMsgProtocol.UserMoveToResult.newBuilder();
            resultBuilder.setMoveUserId(userId);
            resultBuilder.setMoveToPosX(cmd.getMoveToPosX());
            resultBuilder.setMoveToPosY(cmd.getMoveToPosY());

            GameMsgProtocol.UserMoveToResult newResult =
                    resultBuilder.build();
            // 群发
            CHANNEL_GROUP.writeAndFlush(newResult);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        super.handlerRemoved(ctx);

        // 处理掉线逻辑

        CHANNEL_GROUP.remove(ctx.channel());

        // 拿到用户id

        Integer userId = (Integer) ctx.channel().attr(AttributeKey.valueOf("userId")).get();

        if (null == userId) {
            return;
        }

        USER_MAP.remove(userId);

        GameMsgProtocol.UserQuitResult.Builder resultBuilder =
                GameMsgProtocol.UserQuitResult.newBuilder();
        resultBuilder.setQuitUserId(userId);

        GameMsgProtocol.UserQuitResult newResult = resultBuilder.build();
        CHANNEL_GROUP.writeAndFlush(newResult);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        CHANNEL_GROUP.add(ctx.channel());
    }
}
