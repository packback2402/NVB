import javax.swing.JOptionPane;
public class Calculate{
	public static void main(String[] args){
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog("Nhap so thu nhat: ");
		strNum2 = JOptionPane.showInputDialog("Nhap so thu hai: ");
		
	try{
		double num1 = Double.parseDouble(strNum1);
		double num2 = Double.parseDouble(strNum2);
		double sum = num1 + num2;
		double dif = num1 - num2;
		double product = num1 * num2;
		String res;
		if(num2 != 0){
			double quotient = num1/num2;
			res = "Sum: " + sum + "\nDif: " + dif + "\nProduct: " + product + "\nQuotient: " + quotient;
		}
		else{
			res = "Sum: " + sum + "\nDif: " + dif + "\nProduct: " + product + "\nCannot divided to zero";
		}
		JOptionPane.showMessageDialog(null, res);
	}
		catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, JOptionPane.ERROR_MESSAGE);
		}	

	}
}