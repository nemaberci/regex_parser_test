package hu.nemaberci.api;

import static hu.nemaberci.TestMain.REGEX_PATTERN3;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;

@RegularExpression(REGEX_PATTERN3)
public interface TestRegexParser3 extends RegexParser {

}
