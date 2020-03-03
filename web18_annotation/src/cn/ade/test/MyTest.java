package cn.ade.test;

import cn.ade.annotation.MyAnnotation;
import org.junit.Test;

/**
 * 注解的测试类
 *
 * @author ade
 * @version 1.0，2020-02-25 21:44:47
 */
@MyAnnotation(username = "jie")
public class MyTest {

    @Test
    public void test() {
        boolean flag = MyTest.class.isAnnotationPresent(MyAnnotation.class);
        System.out.println(flag);
    }

}
