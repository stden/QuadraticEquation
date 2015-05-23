import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * Интерфейс Swing
 */
public class QEForm {
    private JPanel panel1;
    private JTextField textFieldA;
    private JTextField textFieldB;
    private JTextField textFieldC;
    private JButton calcButton;
    private JTextArea result;

    public QEForm() {
        calcButton.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                double a = Double.parseDouble(textFieldA.getText());
                double b = Double.parseDouble(textFieldB.getText());
                double c = Double.parseDouble(textFieldC.getText());
                try {
                    double[] roots = QuadraticEquation.solve(a, b, c);
                    switch (roots.length) {
                        case 0:
                            result.setText("Нет решений");
                            break;
                        case 1:
                            result.setText("Одно решение: " + roots[0]);
                            break;
                        case 2:
                            result.setText("Два решения: " + roots[0] + " " + roots[1]);
                            break;
                    }
                } catch (AnyXException ex) {
                    result.setText("x - любое");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Решение квадратного уравнения");
        frame.setContentPane(new QEForm().panel1);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
