package org.teamway.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.teamway.model.User;
import shenzhen.teamway.PropertiesUtils;

import java.io.IOException;
import java.io.Reader;
import java.util.Properties;

/**
 * <p>
 *
 * @author Wangc
 * @Date: 2019/1/3 0003 09:51
 * @Description:
 */
public class MyBatisUtils {
    private static Logger logger = LoggerFactory.getLogger(MyBatisUtils.class);

    private SqlSessionFactory sqlSessionFactory;
    private Reader reader;

   // @Before
    public void init(){
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
            Properties properties = new Properties();
            PropertiesUtils utils = new PropertiesUtils();
            utils.readConfigFile();
            properties.setProperty("driver" ,utils.getDbValue("driver"));
            properties.setProperty("url" ,utils.getDbValue("url"));
            properties.setProperty("username" ,utils.getDbValue("username"));
            properties.setProperty("password" ,utils.getDbValue("password"));
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //@Test
    public void testQueryUser(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = (User) session.selectOne("com.zf.mybatis.pojo.UserMapper.selectByID" ,1);
            System.out.println(user.getUserAddress());
            System.out.println(user.getUserName());
        } finally {
            session.close();
        }
    }

   // @Test
    public void testInsertUser(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User() ;
            user.setUserName("abcde");
            user.setUserAge(""+15) ;
            user.setUserAddress("hangzhou/zhejiang");
            user.setPassword("123456");
            //返回值是记录条数
            int resultCount = session.insert("com.zf.mybatis.pojo.UserMapper.add", user );
            session.commit() ;
            System.out.printf("userID:%d,总记录条数:%d" , user.getId() , resultCount); //获取插入对象的id
        } finally {
            session.close();
        }
    }

    //@Test
    public void testUpdateUser(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            User user = new User() ;
            user.setId(5) ;
            user.setUserName("updateName");
            user.setUserAge(""+101) ;
            user.setUserAddress("shenzhen/guangdong");
            user.setPassword("000000");
            //返回值是修改条数
            int updateCount = session.update("com.zf.mybatis.pojo.UserMapper.update", user );
            session.commit() ;
            System.out.printf("修改条数:%d" ,updateCount);
        } finally {
            session.close();
        }
    }

    //@Test
    public void testDelete(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            //返回值是删除条数
            int deleteCount = session.update("com.zf.mybatis.pojo.UserMapper.deleteById", 4 );
            session.commit() ;
            System.out.printf("删除条数:%d" ,deleteCount );
        } finally {
            session.close();
        }
    }
    //@Test
    public void test(){
        logger.debug("debug");
        logger.info("wangchao");
        logger.warn("warn");
        logger.error("error");
    }

}
