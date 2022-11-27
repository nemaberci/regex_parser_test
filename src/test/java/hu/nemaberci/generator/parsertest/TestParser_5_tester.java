package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_5;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_5_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(2, RegexParserContainer.getImplementation(TestParser_5.class).findMatches("aAbBabcababCbacbadABCBABCB").getMatches().size());
    }
}
