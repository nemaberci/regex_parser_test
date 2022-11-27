package hu.nemaberci.api;

import static hu.nemaberci.TestMain.REGEX_PATTERN4;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;

@RegularExpression(REGEX_PATTERN4)
public interface TestRegexParser4 extends RegexParser {

}
