package com.hef.spittr;

import config.RootConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.management.*;
import java.io.IOException;
import java.util.Set;

/**
 * @Date 2019-05-03
 * @Author lifei
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class MBeanTest {

    @Autowired
    private MBeanServerConnection mBeanServerConnection;

    @Test
    public void shouldNotNull(){
        Assert.assertNotNull(mBeanServerConnection);
    }

    /**
     * 查询MBean的名称
     */
    @Test
    public void showMBeanName(){
        try {
            Set<ObjectName> mbeanNames = mBeanServerConnection.queryNames(null, null);
            for (ObjectName name :
                    mbeanNames) {
                System.out.println(name);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取属性值
     */
    @Test
    public void showSpittleName(){
        try {
            Object spittlesPerPage = mBeanServerConnection.getAttribute(new ObjectName("spitter:name=SpittleController"),
                    "SpittlesPerPage");
            System.out.println(spittlesPerPage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 设置值
     */
    @Test
    public void reSetSpittlesPerPage(){
        try {
            mBeanServerConnection.setAttribute(new ObjectName("spitter:name=SpittleController"),
                    new Attribute("SpittlesPerPage", 3));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过调用方法设置值
     */
    @Test
    public void invokSetSpittlesPerPage(){
        try {
            mBeanServerConnection.invoke(new ObjectName("spitter:name=SpittleController"),
                    "setSpittlesPerPage", new Object[]{5}, new String[]{"int"});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
