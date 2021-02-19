package lessons14tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lessons14Test {

    int[] intArray = {11, 5, 11, 2, 1, 4, 5};
    int[] intArray2 = {1, 1, 1, 4, 1, 1};

    Lessons14 l14T;

    @Before
    public void init() {
        l14T = new Lessons14();
    }

    @Test
    public void check1Test() {
        Assert.assertArrayEquals(new Integer[]{2,1, 4, 5},l14T.check1(intArray,11));
    }

    @Test
    public void check2Test() {
        Assert.assertTrue("true",l14T.check2(intArray2,1,4));
    }

}
