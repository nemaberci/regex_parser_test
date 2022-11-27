package hu.nemaberci.generator.parsertest;
import hu.nemaberci.generator.parser.TestParser_8;
import hu.nemaberci.regex.container.RegexParserContainer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
public class TestParser_8_tester {
    @Test
    public void testParser1() {
        Assert.assertEquals(2, RegexParserContainer.getImplementation(TestParser_8.class).findMatches("]]]]gerugherg]]]ergerg]]]]").getMatches().size());
    }
}
