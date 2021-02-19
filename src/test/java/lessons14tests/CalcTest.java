package lessons14tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalcTest {
    Calculator c;

    @Before
    public void init() {
        c = new Calculator();
    }

    @After
    public void close() {
        System.out.println("After");
        //......
    }

    @Test
    public void addTest() {
        Assert.assertEquals(4, c.add(1, 3));
//        Assert.assertEquals(6, c.sub(9, 3));
//        Assert.assertEquals(6, c.sub(9, 3));
//        Assert.assertEquals(6, c.sub(9, 3));
//        Assert.assertEquals(6, c.sub(9, 3));
    }

}
