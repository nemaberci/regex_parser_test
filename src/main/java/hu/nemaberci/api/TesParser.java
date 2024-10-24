package hu.nemaberci.api;


import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;

@RegularExpression("^t{1,3}es(t?)$")
public interface TesParser extends RegexParser {

}
