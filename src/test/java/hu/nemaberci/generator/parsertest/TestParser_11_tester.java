package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_11;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_11_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(1, RegexParserContainer.getImplementation(TestParser_11.class).findMatches("abc").getMatches().size());
    }
}
