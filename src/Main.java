import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;


public class Main {

	public static void main(String[] args) {

	try {
		FlatLightLaf.setup();
		UIManager.setLookAndFeel("com.formdev.flatlaf.FlatLightLaf");
		//UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		//UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	} catch (ClassNotFoundException | InstantiationException
			| IllegalAccessException | UnsupportedLookAndFeelException e) {
		e.printStackTrace();
	}
		
		new Fenetre();
		
	}
}

