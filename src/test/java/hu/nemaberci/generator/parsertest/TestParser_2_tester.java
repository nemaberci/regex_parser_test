package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_2;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_2_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(3, RegexParserContainer.getImplementation(TestParser_2.class).findMatches("aaaabbbcccabbbbababbcccbbcbacbabc").getMatches().size());
    }
}
