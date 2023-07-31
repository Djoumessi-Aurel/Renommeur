import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Main {

	public static void main(String[] args) {

	try {
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e) {
		e.printStackTrace();
	}
		
		new Fenetre();
		
	}
}

