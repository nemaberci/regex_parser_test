package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_18;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_18_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(5, RegexParserContainer.getImplementation(TestParser_18.class).findMatches("bcabcaabcaaabcaaaabcaaaaabcbcbc").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_18.class).matches("bcabcaabcaaabcaaaabcaaaaabcbcbc"));
    }
}
