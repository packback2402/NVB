import javax.swing.JOptionPane;
public class ChoosingOption {
	public static void main(String[] args) {
		String[] options = {"Yes", "No", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, 
				"Do you want to change to the first class ticket?",
				"Choose an option",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options, // tùy chọn 
				options[0] // tùy chọn mặc định
				);
		if(option == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(null, "You've chosen: YES");
		}
		else if(option == JOptionPane.NO_OPTION) {
			JOptionPane.showConfirmDialog(null, "You've chosen: NO");
		}
		else if(option == JOptionPane.CANCEL_OPTION){
			JOptionPane.showConfirmDialog(null, "You've chosen: CANCEL");
		}
		else {
			JOptionPane.showConfirmDialog(null, "No option was selected");
		}
		System.exit(0);
	}
}
