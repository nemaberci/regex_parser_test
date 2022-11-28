package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_25;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_25_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(6, RegexParserContainer.getImplementation(TestParser_25.class).findMatches("bcabcaabcaaabcaaaabcaaaaabcbcbc").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_25.class).matches("bcabcaabcaaabcaaaabcaaaaabcbcbc"));
    }
}
