package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_9;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestParser_9_tester {
    @Test
    public void testParser1() {
        Assertions.assertEquals(2, RegexParserContainer.getImplementation(TestParser_9.class).findMatches("iouhdfg---eroeg-ergerg").getMatches().size());
        Assertions.assertTrue(RegexParserContainer.getImplementation(TestParser_9.class).matches("iouhdfg---eroeg-ergerg"));
    }
}
