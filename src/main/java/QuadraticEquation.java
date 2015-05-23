/**
 * Квадратное уравнение
 */
public class QuadraticEquation {

    /**
     * Решение квадратного уравнения: ax^2 + bx + c = 0
     *
     * @param a коэффициент при x^2
     * @param b коэффициент при x
     * @param c константа
     * @return корни уравнения (значения x)
     */
    public static double[] solve(double a, double b, double c) {
        return new double[]{-b / (2 * a)};
    }
}
