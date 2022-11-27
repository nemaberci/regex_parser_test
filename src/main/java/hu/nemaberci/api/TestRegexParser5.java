package hu.nemaberci.api;

import static hu.nemaberci.TestMain.REGEX_PATTERN5;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;

@RegularExpression(REGEX_PATTERN5)
public interface TestRegexParser5 extends RegexParser {

}
