import org.junit.Assert;
import org.junit.Test;

/**
 * Тесты для решения квадратного уравнения
 */
public class QuadraticEquationTest extends Assert {
    public static final double EPS = 1e-10;

    /**
     * Стандартное квадратное уравнение с одним решением
     */
    @Test
    public void testSimpleOneRoot() {
        assertArrayEquals("x^2 = 0", new double[]{0}, QuadraticEquation.solve(1, 0, 0), EPS);
        assertArrayEquals("(x-1)^2 = x^2-2x+1", new double[]{1}, QuadraticEquation.solve(1, -2, 1), EPS);
        assertArrayEquals("2(x-1)^2 = 2x^2-4x+2", new double[]{1}, QuadraticEquation.solve(2, -4, 2), EPS);
    }
}
