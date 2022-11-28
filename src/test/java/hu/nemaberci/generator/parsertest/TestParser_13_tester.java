package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_13;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_13_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(1, RegexParserContainer.getImplementation(TestParser_13.class).findMatches("abcqwe").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_13.class).matches("abcqwe"));
    }
}
