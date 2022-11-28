package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_6;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_6_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(5, RegexParserContainer.getImplementation(TestParser_6.class).findMatches("nurghbztcuhrtgbuhegauhert").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_6.class).matches("nurghbztcuhrtgbuhegauhert"));
    }
}
