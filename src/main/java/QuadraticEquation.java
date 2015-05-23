/**
 * Квадратное уравнение
 */
public class QuadraticEquation {
    public static final double EPS = 1e-10;

    /**
     * Решение квадратного уравнения: ax^2 + bx + c = 0
     *
     * @param a коэффициент при x^2
     * @param b коэффициент при x
     * @param c константа
     * @return корни уравнения (значения x)
     */
    public static double[] solve(double a, double b, double c) {
        if (Math.abs(a) < EPS) {
            if (Math.abs(b) < EPS)
                return new double[]{};
            return new double[]{-c / b};
        }
        // Дискриминант
        double D = Math.pow(b, 2) - 4 * a * c;
        if (Math.abs(D) < EPS)
            return new double[]{-b / (2 * a)};
        if (D < 0)
            return new double[]{};
        double d = Math.sqrt(D);
        return new double[]{(-b - d) / (2 * a), (-b + d) / (2 * a)};
    }
}
