package predictivegui;


import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.BorderLayout;
import java.awt.Component;
import java.io.IOException;

import javax.swing.UIManager;

import predictivegui.View.Keypad;


// TODO: Auto-generated Javadoc
/**
* The Class MessageGUI.
* 
* This class will be used to instantiate a new T9 GUI to test the program behind the interface to 
* see if it works
* @author Nemitari Ajienka
* tutor group :  17
* Date : 22nd February 2014
* 
*/

public class GUI {
	
	/**
	 * Instantiates a new message gui.
	 */
	public GUI(){
		
	}
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws ClassNotFoundException the class not found exception
	 * @throws InstantiationException the instantiation exception
	 * @throws IllegalAccessException the illegal access exception
	 * @throws UnsupportedLookAndFeelException the unsupported look and feel exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main (String [] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{
		
		
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		JFrame t9 = new JFrame();
		
		Model dictionaryModel = new Model();
		View messageview = new View(dictionaryModel);
		
		
	
		dictionaryModel.addObserver(messageview);
		t9.setLayout(new BorderLayout());
		
		t9.add(messageview, "Center");
		
		t9.setSize(200, 300);
		t9.setTitle("Predictive Text");
		t9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t9.setVisible(true);
	
	}
	
	
}
