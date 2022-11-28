package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_12;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_12_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(0, RegexParserContainer.getImplementation(TestParser_12.class).findMatches("qweabcqwe").getMatches().size());
        Assertions.assertFalse(RegexParserContainer.getImplementation(TestParser_12.class).matches("qweabcqwe"));
    }
}
