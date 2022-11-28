package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_8;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_8_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(2, RegexParserContainer.getImplementation(TestParser_8.class).findMatches("]]]]gerugherg]]]ergerg]]]]").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_8.class).matches("]]]]gerugherg]]]ergerg]]]]"));
    }
}
