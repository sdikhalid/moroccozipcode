package net.faleh.postalcode.api.json;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SingleQuoteNormalizer {

    /**
     * Unicode codes for every character in the regular expression
     *  ‘ : \u2018
     *  ’ : \u2019
     *  ˋ : \u02cb
     *  ´ : \u00b4
     *  ʼ : \u02bc
     *  ʻ : \u02bb
     **/

    private static final String NON_ASCII_QUOTES_REGEX_PATTERN = "‘|’|ˋ|´|ʼ|ʻ";

    private static final String ASCII_SINGLE_QUOTE = "'";

    private static final Pattern pattern = Pattern.compile(NON_ASCII_QUOTES_REGEX_PATTERN);

    SingleQuoteNormalizer() {
    }

    public static String normalizeQuotes(String input) {
        Matcher matcher = pattern.matcher(input);
        return matcher.replaceAll(ASCII_SINGLE_QUOTE);
    }
}
