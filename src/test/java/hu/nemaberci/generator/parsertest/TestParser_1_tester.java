package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_1;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_1_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(3, RegexParserContainer.getImplementation(TestParser_1.class).findMatches("aaaabcaaaabbbbabcbbbbccccabcccc").getMatches().size());
    }
}
