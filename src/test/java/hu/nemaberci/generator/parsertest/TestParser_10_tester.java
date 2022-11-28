package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_10;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_10_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(2, RegexParserContainer.getImplementation(TestParser_10.class).findMatches("--]g-g-]]]--]").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_10.class).matches("--]g-g-]]]--]"));
    }
}
