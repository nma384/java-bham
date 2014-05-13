package predictive;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.TreeSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
* The Class PredictivePrototype.
* 
* This class will be used to find a set of words from a dictionary,  that match a given signature argument
* @author Nemitari Ajienka
* tutor group :  17
* Date : 22nd February 2014
* 
*/
public class PredictivePrototype
{
    
    /**
     * Word to signature.
     *
     * @param s the s
     * @return the string
     */
    public static String wordToSignature(final String s) {
        final StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 == 'a' || char1 == 'b' || char1 == 'c') {
                sb.append('2');
            }
            else if (char1 == 'd' || char1 == 'e' || char1 == 'f') {
                sb.append('3');
            }
            else if (char1 == 'g' || char1 == 'h' || char1 == 'i') {
                sb.append('4');
            }
            else if (char1 == 'j' || char1 == 'k' || char1 == 'l') {
                sb.append('5');
            }
            else if (char1 == 'm' || char1 == 'n' || char1 == 'o') {
                sb.append('6');
            }
            else if (char1 == 'p' || char1 == 'q' || char1 == 'r' || char1 == 's') {
                sb.append('7');
            }
            else if (char1 == 't' || char1 == 'u' || char1 == 'v') {
                sb.append('8');
            }
            else if (char1 == 'w' || char1 == 'x' || char1 == 'y' || char1 == 'z') {
                sb.append('9');
            }
            else {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
    
    /**
     * Valid word.
     *
     * @param s the s
     * @return true, if successful
     */
    public static boolean validWord(final String s) {
        for (int i = 0; i < s.length(); ++i) {
            final char char1 = s.charAt(i);
            if (char1 < 'a' || char1 > 'z') {
                return false;
            }
        }
        return s.length() >= 1;
    }
    
    /**
     * Signature to words.
     *
     * @param s the signature string
     * @return the sets the
     */
    public static Set<String> signatureToWords(final String s) {
        final TreeSet<String> set = new TreeSet<String>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("words.txt"));
            while (scanner.hasNext()) {
                final String lowerCase = scanner.nextLine().toLowerCase();
                if (validWord(lowerCase) && wordToSignature(lowerCase).equals(s)) {
                    set.add(lowerCase);
                }
            }
        }
        
        catch (IOException ex) {
            System.err.println(ex);
        }
        
        finally {
            scanner.close();
        }
        return set;
    }
    
    /**
     * The main method.
     * This method is used to test the signatureToWords methods to see if it actually works as expected.

     * @param array the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] array) throws IOException {
        System.out.println(signatureToWords("43556"));
        System.out.println(signatureToWords("96753"));
        System.out.println(signatureToWords("69"));
        System.out.println(signatureToWords("6263"));
        System.out.println(signatureToWords("47"));
        System.out.println(signatureToWords(""));
        System.out.println(signatureToWords("111111111111111"));
    }
}
