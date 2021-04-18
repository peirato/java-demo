package com.peirato.demo;

import com.peirato.demo.domain.User;
import com.peirato.demo.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisDemoTest {

    @Test
    public void testFindUserById1() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        // 直接读取xml文件的方式
        User o = (User)session.selectOne("com.peirato.demo.mapper.UserMapper.findUserById", 2);

        System.out.println(o);

    }

    @Test
    public void testFindUserById2() throws IOException {

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sqlSessionFactory.openSession();

        // 通过接口获取
        UserMapper mapper = session.getMapper(UserMapper.class);
        User userById = mapper.findUserById(1);

        System.out.println(userById);

    }


}
