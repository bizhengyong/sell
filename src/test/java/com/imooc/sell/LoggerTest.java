package com.imooc.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author bizy
 * @date 2019/9/11 20:15
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

    @Test
    public void test1(){
        String str1 = "hello";
        String str2 = "world";
        log.info("str1={},str2={}",str1,str2);
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
    }
}
