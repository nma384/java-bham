package predictive;

import java.util.Collection;
import java.util.Iterator;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.TreeSet;
import java.util.Set;

// TODO: Auto-generated Javadoc
/**
 * The Class DictionaryImpl.
 * 
 * This class will be used to find a set of words from a dictionary,  that match a given signature argument
 * @author Nemitari Ajienka
 * tutor group :  17
 * Date : 22nd February 2014
 * 
 */
 
public class DictionaryImpl implements Dictionary
{
    
    /** The words. */
    private Set<String> words;
    
    /** The children. */
    private DictionaryImpl[] children;
    
    /**
     * Instantiates a new dictionary impl.
     *
     * @param s the s
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public DictionaryImpl(final String s) throws IOException {
        super();
        this.children = new DictionaryImpl[8];
        this.words = new TreeSet<String>();
        final Scanner scanner = new Scanner(new File(s));
        while (scanner.hasNext()) {
            final String lowerCase = scanner.nextLine().toLowerCase();
            if (PredictivePrototype.validWord(lowerCase)) {
                this.insert(PredictivePrototype.wordToSignature(lowerCase), lowerCase);
            }
        }
    }
    
    /**
     * Instantiates a new dictionary impl.
     */
    private DictionaryImpl() {
        super();
        this.children = new DictionaryImpl[8];
        this.words = new TreeSet<String>();
    }
    
    /**
     * Insert.
     *
     * @param s the s
     * @param s2 the s2
     */
    private void insert(final String s, final String s2) {
        if (s.length() > 0) {
            this.insertHelper(0, s, s2);
        }
    }
    
    /**
     * Insert helper.
     *
     * @param n the n
     * @param s the s
     * @param s2 the s2
     */
    private void insertHelper(final int n, final String s, final String s2) {
        if (n == s.length()) {
            this.words.add(s2);
        }
        else {
            final char char1 = s.charAt(n);
            if (char1 >= '2' && char1 <= '9') {
                final int n2 = Character.digit(char1, 10) - 2;
                if (this.children[n2] == null) {
                    this.children[n2] = new DictionaryImpl();
                }
                this.words.add(s2);
                this.children[n2].insertHelper(n + 1, s, s2);
            }
        }
    }
    
    /* (non-Javadoc)
     * @see predictive.Dictionary#signatureToWords(java.lang.String)
     */
    @Override
    public Set<String> signatureToWords(final String s) {
        final Set<String> find = this.find(s);
        final TreeSet<String> set = new TreeSet<String>();
        final Iterator<String> iterator = find.iterator();
        while (iterator.hasNext()) {
            set.add(iterator.next().substring(0, s.length()));
        }
        return set;
    }
    
    /**
     * Find.
     *
     * @param s the s
     * @return the sets the
     */
    private Set<String> find(final String s) {
        return this.findHelper(0, s);
    }
    
    /**
     * Find helper.
     *
     * @param n the n
     * @param s the s
     * @return the sets the
     */
    private Set<String> findHelper(final int n, final String s) {
        if (n == s.length()) {
            return new TreeSet<String>(this.words);
        }
        final char char1 = s.charAt(n);
        if (char1 < '2' || char1 > '9') {
            return new TreeSet<String>();
        }
        final int n2 = Character.digit(char1, 10) - 2;
        if (this.children[n2] == null) {
            return new TreeSet<String>();
        }
        return this.children[n2].findHelper(n + 1, s);
    }
    
    
    /**
     * The main method.
     * This method is used to test the signatureToWords methods to see if it actually works as expected.
     * @param array the arguments
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public static void main(final String[] array) throws IOException {
        final DictionaryImpl dictionaryImpl = new DictionaryImpl("words.txt");
        System.out.println(dictionaryImpl.children[2].children[1].children[3].children[3].children[4].words);
        System.out.println(dictionaryImpl.signatureToWords("43556"));
        System.out.println(dictionaryImpl.signatureToWords("96753"));
        System.out.println(dictionaryImpl.signatureToWords("69"));
        System.out.println(dictionaryImpl.signatureToWords("6263"));
        System.out.println(dictionaryImpl.signatureToWords("47"));
        System.out.println(dictionaryImpl.signatureToWords(""));
        System.out.println(dictionaryImpl.signatureToWords("111111111111111"));
    }
}
