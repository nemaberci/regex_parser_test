package hu.nemaberci.api;

import static hu.nemaberci.TestMain.REGEX_PATTERN6;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;

@RegularExpression(REGEX_PATTERN6)
public interface TestRegexParser6 extends RegexParser {

}
