package lessons14tests;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Project java_core_android
 *
 * @Author Alexander Grigorev
 * Created 18.02.2021
 * v1.0
 */
@RunWith(Parameterized.class)
public class ParametrizedTest {

    @Parameterized.Parameters
    public static Collection<Object[]> params() {
        return Arrays.asList(new Object[][]{
                {Arrays.asList(16, 17, 18),4,8}
        });
    }
    private int[] n1;
    private int n2, res;
    private Calculator calculator;

    public ParametrizedTest(int[] n1, int n2, int res) {
        this.n1 = n1;
        this.n2 = n2;
        this.res = res;
    }

    @Before
    public void init() {
        int[] a = {1, 2, 3, 4, 5};

//        Arrays.stream(a).filter(v -> v % 3 == 0)
        calculator = new Calculator();
    }


}
