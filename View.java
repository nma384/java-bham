package predictivegui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


// TODO: Auto-generated Javadoc
/**
* The Class View.
* 
* this class will be used to implement the view (observer) of the model. The window or text area which 
* will observe the results of entering signatures using the keypad. 
* The view will be updated using the update method in the interface Observer
* 
* @author Nemitari Ajienka
* tutor group :  17
* Date : 22nd February 2014
* 
*/


public class View extends JPanel implements Observer{

	
	
	/** The model. */
	private Model model;
	
	/** The message. */
	private JTextArea message;

	private JLabel label2;
	
	/**
	 * Instantiates a new message view.
	 *
	 * @param dictionaryModel the dictionary model
	 */
	public View(Model dictionaryModel) {
		
		model = dictionaryModel;
		message = new JTextArea(5, 20);
		message.setEditable(false);
		message.setLineWrap(true);
		message.setText("Welcome : enter text.");
		
		JScrollPane scrollPane = new JScrollPane(message);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		
		/*Icon pic = new ImageIcon ("images-7.jpeg");
		ImageIcon imageIcon = new ImageIcon("images-8.jpeg"); // load the image to a imageIcon
		Image image = imageIcon.getImage(); // transform it 
		Image newimg = image.getScaledInstance(90, 90,  java.awt.Image.SCALE_SMOOTH); // scale image the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
		label2 = new JLabel("Welcome", imageIcon, SwingConstants.LEFT);
		label2.setToolTipText("this is label 2");
		label2.setSize(5, 20);
		add(label2);
		*/
		
		
		Keypad keypad = new Keypad(dictionaryModel);
		add(keypad, "South");
		
	}
	

	// TODO: Auto-generated Javadoc

	/**
	* The Class Keypad.
	* 
	* This class will be used to create the buttons and panels needed for the graphical user interface
	* It will also have an inner class for the action listener for the buttons, in order for something to happen 
	* in the user interface when a button is pressed/clicked or else nothing will happen without the action listener
	* @author Nemitari Ajienka
	* tutor group :  17
	* Date : 22nd February 2014
	* 
	*/

	public class Keypad extends JPanel {

		
		/** The key1. */
		private JButton key1;
		
		/** The key2. */
		private JButton key2;
		
		/** The key3. */
		private JButton key3;
		
		/** The key4. */
		private JButton key4;
		
		/** The key5. */
		private JButton key5;
		
		/** The key6. */
		private JButton key6;
		
		/** The key7. */
		private JButton key7;
		
		/** The key8. */
		private JButton key8;
		
		/** The key9. */
		private JButton key9;
		
		/** The key0. */
		private JButton key0;
		
		/** The key star. */
		private JButton keyStar;
		
		/** The key blank. */
		private JButton keyBlank;
		
		/**
		 * Instantiates a new keypad controller.
		 *
		 * @param m the model
		 */
		public Keypad (Model m){
			super();
			setLayout(new GridLayout(4, 3));
			
			key1 = new JButton("1");
			key2 = new JButton(" 2 abc");
			key3 = new JButton("3 def");
			key4 = new JButton("4 ghi");
			key5 = new JButton ("5 jkl");
			key6 = new JButton ("6 mno");
			key7 = new JButton ("7 pqrs");
			key8 = new JButton ("8 tuv");
			key9 = new JButton ("9 wxyz");
			
			keyBlank = new JButton ("Clear");
			key0 = new JButton("<html><center> 0 <p> _ </center></html>");
			keyStar = new JButton("Sel");
				key2.addActionListener(new KeyActionListener(m, '2'));
		key3.addActionListener(new KeyActionListener(m, '3'));
		key4.addActionListener(new KeyActionListener(m, '4'));
		key5.addActionListener(new KeyActionListener(m, '5'));
		key6.addActionListener(new KeyActionListener(m, '6'));
		key7.addActionListener(new KeyActionListener(m, '7'));
		key8.addActionListener(new KeyActionListener(m, '8'));
		key9.addActionListener(new KeyActionListener(m, '9'));
		keyStar.addActionListener(new KeyActionListener(m, '*'));
		key0.addActionListener(new KeyActionListener(m, '0'));
		keyBlank.addActionListener(new KeyActionListener(m, '#'));
		
		
		add(key1);
		key1.setForeground(Color.BLUE);
		add(key2);
		key2.setForeground(Color.BLUE);
		add(key3);
		//key3.setBackground(Color.red);
		key3.setForeground(Color.BLUE);

		add(key4);
		key4.setForeground(Color.BLUE);
		add(key5);
		key5.setForeground(Color.BLUE);
		add(key6);
		key6.setForeground(Color.BLUE);
		add(key7);
		key7.setForeground(Color.BLUE);
		add(key8);
		key8.setForeground(Color.BLUE);
		add(key9);
		key9.setForeground(Color.BLUE);
		add(keyStar);
		keyStar.setForeground(Color.BLUE);
		add(key0);
		key0.setForeground(Color.BLUE);
		add(keyBlank);
		keyBlank.setForeground(Color.BLUE);
		}
		
		
		
		/**
		 * The listener interface for receiving keypad events.
		 * The class that is interested in processing a keypad
		 * event implements this interface, and the object created
		 * with that class is registered with a component using the
		 * component's <code>addKeypadListener<code> method. When
		 * the keypad event occurs, that object's appropriate
		 * method is invoked.
		 *
		 * @see KeypadEvent
		 */
		public class KeyActionListener implements ActionListener {
			
			/** The model. */
			private Model model;
			
			/** The key. */
			private char key;
			
			/**
			 * Instantiates a new keypad listener.
			 *
			 * @param m the model m
			 * @param k the char k
			 */
			public KeyActionListener (Model m, char k){
				
				model = m;
				key = k;
				
			}
			
			/* (non-Javadoc)
			 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
			 */
			public void actionPerformed(ActionEvent actionEvent){
				model.press(key);
				
			}
		}
		
		
		
	}

	
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	
	@Override
	public void update(Observable obs, Object obj) {
		// TODO Auto-generated method stub
		
		
		StringBuffer words = new StringBuffer();
		String s;
		for (Iterator<String> iterator = model.getWords().iterator(); iterator.hasNext();
				words.append((new StringBuilder()).append(s).append(" ").toString()))
		s = (String)iterator.next();
			message.setText(words.toString());
		
	}

		
	

}
