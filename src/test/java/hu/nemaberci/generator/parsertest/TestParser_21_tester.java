package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_21;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_21_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(3, RegexParserContainer.getImplementation(TestParser_21.class).findMatches("bcabcaabcaaabcaaaabcaaaaabcbcbc").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_21.class).matches("bcabcaabcaaabcaaaabcaaaaabcbcbc"));
    }
}
