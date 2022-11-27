package hu.nemaberci.api;

import static hu.nemaberci.TestMain.REGEX_PATTERN1;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;

@RegularExpression(REGEX_PATTERN1)
public interface TestRegexParser1 extends RegexParser {

}
