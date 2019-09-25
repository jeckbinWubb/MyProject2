package org.test.redis;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = TestBaseApplication.class)
public class TestCase01 extends TestBaseApplication{

    @Test
    public void test01(){
        Assert.assertSame("计算有误！",6,2*3);
    }
}
