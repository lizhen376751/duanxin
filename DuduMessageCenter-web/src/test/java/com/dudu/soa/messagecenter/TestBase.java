package com.dudu.soa.messagecenter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import javax.annotation.Resource;

/**
 * Created by ZCD_WORK on 2017-01-09.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@TransactionConfiguration(transactionManager = "transactionManager")
@ContextConfiguration("classpath*:conf/*-spring.xml")
public abstract class TestBase {
    @Resource
    ApplicationContext ctx;

    public void init(){
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void test() {
    	String[] names = ctx.getBeanDefinitionNames();
    	for(String name : names){
    		System.out.println(name);
    	}
    }
}
