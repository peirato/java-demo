package com.peirato.game;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;

public class ServerMain {

    public static void main(String[] args) {

        // 处理客户端连接的线程池
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        // 处理消息
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup,workerGroup);
        b.channel(NioServerSocketChannel.class);
        // 处理客户端的流程
        b.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(
                        // 解码
                        new HttpServerCodec(),
                        // 判断长度
                        new HttpObjectAggregator(65535),

                        new WebSocketServerProtocolHandler("/websocket"),

                        new GameMsgDecoder(), // 自定义消息解码器

                        new GameMsgEncoder(), // 自定义消息编码器

                        new GameMsgHandler() // 自定义消息处理器
                );
            }
        });

        try {
            ChannelFuture f= b.bind(12345).sync();

            if(f.isSuccess()){
                System.out.println("服务器启动成功");
            }

            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
