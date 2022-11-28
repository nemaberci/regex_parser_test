package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_15;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_15_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(0, RegexParserContainer.getImplementation(TestParser_15.class).findMatches("abcqwe").getMatches().size());
        Assertions.assertFalse(RegexParserContainer.getImplementation(TestParser_15.class).matches("abcqwe"));
    }
}
