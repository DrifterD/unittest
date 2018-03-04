package com.smart.dao;

import com.smart.domain.User;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.unitils.UnitilsTestNG;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import java.util.Date;

import static org.testng.Assert.*;

@SpringApplicationContext({"smart-dao.xml"})
public class UserDaoTest extends UnitilsTestNG {

    @SpringBean("jdbcUserDao")
    private UserDao userDao;

    @BeforeMethod
    public void setUp() throws Exception {
    }

    @AfterMethod
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetMatchCount() throws Exception {
    }

    @Test
    @DataSet("UserDao.Users.xls")
    public void testFindUserByUserName() throws Exception {
        User user=userDao.findUserByUserName("tony");
        assertNull(user,"用户不存在");
        user=userDao.findUserByUserName("jan2");
        assertNotNull(user,"jan存在");
        assertEquals("jan",user.getUserName());
    }

    @Test
    public void testUpdateLoginInfo() throws Exception {
    }

    @Test
    @ExpectedDataSet("UserDao.ExpectedSaveUser.xls")
    public void testSave() throws Exception {

        User user=new User();
        user.setUserId(10);
        user.setUserName("tom1");
        user.setPassword("123456");
        user.setLastVisit(new Date());
        user.setCredit(30);
        user.setLastIp("127.0.0.1");
        userDao.save(user);
    }

    @Test
    public void testClean() throws Exception {
    }

}