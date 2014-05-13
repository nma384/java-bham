package predictive;


/**
 * The interface Dictionary.
 * This interface holds the method signatureToWords which other classes will 
 * implement. 
 * @author Nemitari Ajienka
 * tutor group :  17
 * Date : 22nd February 2014
 */


import java.util.Set;

public interface Dictionary
{
    Set<String> signatureToWords(String p0);
}
