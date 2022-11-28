package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_17;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_17_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(0, RegexParserContainer.getImplementation(TestParser_17.class).findMatches("babcbabcbabcabc").getMatches().size());
        Assertions.assertFalse(RegexParserContainer.getImplementation(TestParser_17.class).matches("babcbabcbabcabc"));
    }
}
