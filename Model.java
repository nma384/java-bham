package predictivegui;

import java.io.IOException;
import predictive.Dictionary;
import predictive.DictionaryImpl;


import java.util.*;



// TODO: Auto-generated Javadoc

/**
* The Class DictionaryModel.
* 
* This class will be used to create methods with which the model will use to produce words that match 
* signatures entered with the keypad buttons of the GUI. 
* The model in this case is the Dictionary (words.txt)
* 
* @author Nemitari Ajienka
* tutor group :  17
* Date : 22nd February 2014
* 
*/


public class Model extends Observable {
	
	
	/** The model. */
	private Dictionary model;
	
	/** The current matches. */
	private List<String> currentMatches;
	
	/** The current sig. */
	private String currentSig;
	
	/** The message. */
	private List<String> message;
	
	/** The index. */
	private int index;
	
	/**
	 * Instantiates a new dictionary model.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Model() throws IOException{
		 
		this("words.txt");		
	}
	
	/**
	 * Instantiates a new dictionary model.
	 *
	 * @param dict the dict
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Model(String dict) throws IOException{
		
		super();
		
		
		model = new DictionaryImpl(dict);
		message = new ArrayList<String>();
		startNewWordEntry();
		
	}
	
	/**
	 * Gets the words.
	 *
	 * @return the words
	 */
	public List<String> getWords(){
		
		ArrayList<String> allMessage = new ArrayList<String>(message);
		allMessage.add(getCurrentWord());
		return allMessage;
	}
	
	
	/**
	 * Press.
	 *
	 * @param c the c
	 */
	public void press (char c){
		if (c == '0')
		{
			message.add(getCurrentWord());
			startNewWordEntry();
		} else if (c == '*') {
					incrementWordIndex();
					
				}
				else if (c== '#') {
					if (currentSig.length() > 0 )
				{ 
					currentSig = currentSig.substring(0, currentSig.length() -1);
					signatureEntered(currentSig);
					
				}
					
			}else {
				
					currentSig = (new StringBuilder()).append(currentSig).append(c).toString();
					signatureEntered(currentSig);
				}
				setChanged();
				notifyObservers();
			
	}
	
		
		/**
		 * Start new word entry.
		 */
		private void startNewWordEntry(){
			currentMatches = new ArrayList<String>();
			currentSig = "";
			index = 0;
		}
	
		
		/**
		 * Increment word index.
		 */
		private void incrementWordIndex(){
			index++;
			if(index == currentMatches.size()){
				index =0;
			}
		}
	
		/**
		 * Signature entered.
		 *
		 * @param sig the sig
		 */
		private void signatureEntered(String sig){
			
			currentMatches = new ArrayList<String> (model.signatureToWords(sig));
			index =0;
			
		}
	
		
		/**
		 * Gets the current word.
		 *
		 * @return the current word
		 */
		private String getCurrentWord(){
			if (currentMatches.size() > 0) {
				return (String)currentMatches.get(index);
			}else {
				return currentSig;
			}
		}
	
		
	

}
