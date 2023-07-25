package com.toby.spring.notSpringCode.user;

import com.toby.spring.notSpringCode.user.dao.CountingConnectionMaker;
import com.toby.spring.notSpringCode.user.dao.CountingDaoFactory;
import com.toby.spring.notSpringCode.user.dao.DaoFactory;
import com.toby.spring.notSpringCode.user.dao.UserDao;
import com.toby.spring.notSpringCode.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("laegel4");
        user.setName("백근호4");
        user.setPassword("1234");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId() + " 조회 성공");

        // -----
        CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
        System.out.println("Connection counter: " + ccm.getCounter());

    }
}
