package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_20;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_20_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(4, RegexParserContainer.getImplementation(TestParser_20.class).findMatches("bcabcaabcaaabcaaaabcaaaaabcbcbc").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_20.class).matches("bcabcaabcaaabcaaaabcaaaaabcbcbc"));
    }
}
