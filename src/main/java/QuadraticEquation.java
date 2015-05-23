import java.util.Scanner;

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
            if (Math.abs(b) < EPS) {
                if (Math.abs(c) < EPS)
                    throw new AnyXException();
                return new double[]{};
            }
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

    /**
     * Ввод коэффициентов с консоли или из командной строки
     *
     * @param args Аргументы командной строки, например: java QuadraticEquation 1.0 -2.0 1.0
     */
    public static void main(String[] args) {
        double a, b, c;
        if (args.length == 3) {
            a = Double.parseDouble(args[0]);
            b = Double.parseDouble(args[1]);
            c = Double.parseDouble(args[2]);
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите a: ");
            a = scanner.nextDouble();
            System.out.print("Введите b: ");
            b = scanner.nextDouble();
            System.out.print("Введите c: ");
            c = scanner.nextDouble();
        }
        System.out.printf("%s x^2 + %s x + %s = 0%n", a, b, c);
        try {
            double roots[] = solve(a, b, c);
            System.out.println("Количество решений = " + roots.length);
            for (double x : roots) {
                System.out.println("x = " + x + " -> " + (a * x * x + b * x + c));
            }
        } catch (AnyXException ex) {
            System.out.println("Вырожденное уравнение: x - любое");
        }
    }
}
