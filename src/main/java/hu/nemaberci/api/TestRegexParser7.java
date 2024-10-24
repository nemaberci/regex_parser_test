package hu.nemaberci.api;

import static hu.nemaberci.TestMain.REGEX_PATTERN7;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;

@RegularExpression(REGEX_PATTERN7)
public interface TestRegexParser7 extends RegexParser {

}
