import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

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

    /**
     * Линейное уравнение
     */
    @Test
    public void testLinear() {
        assertArrayEquals("3x + 4 = 0", new double[]{-4 / 3.}, QuadraticEquation.solve(0, 3, 4), EPS);
        assertArrayEquals("1e-16*x^2 + x - 100 = 0", new double[]{100}, QuadraticEquation.solve(1e-16, 1, -100), EPS);
    }

    /**
     * a = 0, b = 0, c != 0 - нет решений
     */
    @Test
    public void testABZeroNoRoots() {
        assertArrayEquals("2 = 0", new double[]{}, QuadraticEquation.solve(0, 0, 2), EPS);
        assertArrayEquals("4.5 = 0", new double[]{}, QuadraticEquation.solve(0, 0, 4.5), EPS);
    }

    /**
     * a = 0, b = 0, c = 0, x - любое (бесконечное число решений)
     * Это не возможно выразить с помощью массива double => генерируем исключение
     */
    @Test(expected = AnyXException.class)
    public void testABСZero() {
        QuadraticEquation.solve(0, 0, 0);
    }

    /**
     * Большие случайные тесты. Выпадает: нет решений или два (одно не выпадает)
     */
    @Test
    public void testBigRandom() {
        Random r = new Random();
        int[] stats = {0, 0, 0};
        for (int test = 0; test < 10000000; ++test) {
            double a = r.nextDouble(), b = r.nextDouble(), c = r.nextDouble();
            double[] roots = QuadraticEquation.solve(a, b, c);
            stats[roots.length]++;
            for (double x : roots) {
                assertEquals(a + " x^2 + " + b + " x + " + c + " = 0",
                        0.0, a * Math.pow(x, 2) + b * x + c, 1e-8);
            }
        }
        System.out.println("Нет решений: " + stats[0]);
        System.out.println("Одно решение: " + stats[1]);
        System.out.println("Два решения: " + stats[2]);
    }
}
