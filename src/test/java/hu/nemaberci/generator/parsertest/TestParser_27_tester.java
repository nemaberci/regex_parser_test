package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_27;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_27_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(2, RegexParserContainer.getImplementation(TestParser_27.class).findMatches("ddddddaadddddaadddddadd").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_27.class).matches("ddddddaadddddaadddddadd"));
    }
}
