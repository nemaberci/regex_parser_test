package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_14;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_14_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(0, RegexParserContainer.getImplementation(TestParser_14.class).findMatches("qweabc").getMatches().size());
    }
}
