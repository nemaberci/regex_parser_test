package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_24;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_24_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(8, RegexParserContainer.getImplementation(TestParser_24.class).findMatches("bcabcaabcaaabcaaaabcaaaaabcbcbc").getMatches().size());
    }
}
