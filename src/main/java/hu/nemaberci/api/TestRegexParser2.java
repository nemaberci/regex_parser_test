package hu.nemaberci.api;

import static hu.nemaberci.TestMain.REGEX_PATTERN2;

import hu.nemaberci.regex.annotation.RegularExpression;
import hu.nemaberci.regex.api.RegexParser;

@RegularExpression(REGEX_PATTERN2)
public interface TestRegexParser2 extends RegexParser {

}
