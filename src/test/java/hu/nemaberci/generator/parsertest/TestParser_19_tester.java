package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_19;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_19_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(8, RegexParserContainer.getImplementation(TestParser_19.class).findMatches("bcabcaabcaaabcaaaabcaaaaabcbcbc").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_19.class).matches("bcabcaabcaaabcaaaabcaaaaabcbcbc"));
    }
}
