import javax.swing.JOptionPane;

public class Equations {
    public static void main(String[] args) {
        String number;
        number = JOptionPane.showInputDialog("Chọn phương trình bạn muốn giải: \n1: PT bậc nhất \n2: PT nhiều biến \n3: PT bậc hai");
        
        if (number.equals("1")) {
            first_degree_one_variable();
        } else if (number.equals("2")) {
            first_degree_many_variables();
        } else if (number.equals("3")) {
            second_degree_one_variable();
        }
    }

    public static void first_degree_one_variable() {
        try {
            double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a: "));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b: "));
            double x;

            if (a == 0) {
                if (b != 0) {
                    JOptionPane.showMessageDialog(null, "PT vô nghiệm");
                } else {
                    JOptionPane.showMessageDialog(null, "PT vô số nghiệm");
                }
            } else {
                x = -b / a;
                JOptionPane.showMessageDialog(null, "Giá trị x là: " + x);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void first_degree_many_variables() {
        try {
            double a11 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a11: "));
            double a12 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a12: "));
            double b1 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b1: "));
            double a21 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a21: "));
            double a22 = Double.parseDouble(JOptionPane.showInputDialog("Nhập a22: "));
            double b2 = Double.parseDouble(JOptionPane.showInputDialog("Nhập b2: "));

            double D = a11 * a22 - a21 * a12;
            double D1 = b1 * a22 - b2 * a12;
            double D2 = a11 * b2 - a21 * b1;

            if (D != 0) {
                double x1 = D1 / D;
                double x2 = D2 / D;
                JOptionPane.showMessageDialog(null, "Hệ phương trình có nghiệm duy nhất:\n x1 = " + x1 + "\n x2 = " + x2);
            } else if (D == 0 && D1 == 0 && D2 == 0) {
                JOptionPane.showMessageDialog(null, "Hệ phương trình có vô số nghiệm.");
            } else {
                JOptionPane.showMessageDialog(null, "Hệ phương trình vô nghiệm.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void second_degree_one_variable() {
        try {
            // Nhập hệ số cho phương trình bậc hai
            double a = Double.parseDouble(JOptionPane.showInputDialog("Nhập a: "));
            double b = Double.parseDouble(JOptionPane.showInputDialog("Nhập b: "));
            double c = Double.parseDouble(JOptionPane.showInputDialog("Nhập c: "));

            if (a == 0) {
                JOptionPane.showMessageDialog(null, "Hệ số a không thể bằng 0. Đây không phải là phương trình bậc hai.");
                return;
            }

            // Tính delta (Δ)
            double delta = b * b - 4 * a * c;
            String res;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                res = "Phương trình có hai nghiệm phân biệt:\n x1 = " + x1 + "\n x2 = " + x2;
            } else if (delta == 0) {
                double x = -b / (2 * a);
                res = "Phương trình có nghiệm kép: x = " + x;
            } else {
                res = "Phương trình vô nghiệm (không có nghiệm thực).";
            }

            JOptionPane.showMessageDialog(null, res);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
