package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_16;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_16_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(1, RegexParserContainer.getImplementation(TestParser_16.class).findMatches("qweabc").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_16.class).matches("qweabc"));
    }
}
