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

    /**
     * Уравнения с двумя корнями
     */
    @Test
    public void testTwoSolutions() {
        assertArrayEquals("(x-1)(x-2) = x^2-3x+2", new double[]{1, 2}, QuadraticEquation.solve(1, -3, 2), EPS);
    }

    /**
     * Погрешность вычислений (точность вычисления дискриминанта)
     */
    @Test
    public void testOneRootAccuracy() {
        for (int q = 1; q < 999; q++) {
            double t = 0.3;
            assertArrayEquals("t(x-q)^2 = t*x^2 - 2*t*q*x + t*q^2", new double[]{q}, QuadraticEquation.solve(t, -2 * t * q, t * q * q), EPS);
        }
    }

    /**
     * Нет решений (корней)
     */
    @Test
    public void testNoRoots() {
        assertArrayEquals("x^2 + 2 = 0", new double[]{}, QuadraticEquation.solve(1, 0, 2), EPS);
    }
}
