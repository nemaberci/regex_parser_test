package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_25;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_25_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(6, RegexParserContainer.getImplementation(TestParser_25.class).findMatches("bcabcaabcaaabcaaaabcaaaaabcbcbc").getMatches().size());
    }
}
