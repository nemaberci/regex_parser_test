package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_7;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_7_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(2, RegexParserContainer.getImplementation(TestParser_7.class).findMatches("ihreg]]eorwuherg]]]]erwg").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_7.class).matches("ihreg]]eorwuherg]]]]erwg"));
    }
}
