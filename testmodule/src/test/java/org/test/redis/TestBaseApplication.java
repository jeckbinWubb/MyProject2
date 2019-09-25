package org.test.redis;


import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest
//由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
public class TestBaseApplication {

    @Before
    public void init(){
        System.out.println("-------------->测试开始<-------------");
    }

    @After
    public void after(){
        System.out.println("-------------->测试结束<-------------");
    }
}
