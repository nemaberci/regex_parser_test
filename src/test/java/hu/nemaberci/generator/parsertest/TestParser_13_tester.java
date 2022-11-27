package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_13;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_13_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(1, RegexParserContainer.getImplementation(TestParser_13.class).findMatches("abcqwe").getMatches().size());
    }
}
