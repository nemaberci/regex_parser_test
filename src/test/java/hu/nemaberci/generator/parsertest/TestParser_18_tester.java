package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_18;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_18_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(5, RegexParserContainer.getImplementation(TestParser_18.class).findMatches("bcabcaabcaaabcaaaabcaaaaabcbcbc").getMatches().size());
    }
}