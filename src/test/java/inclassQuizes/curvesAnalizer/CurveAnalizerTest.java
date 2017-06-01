package inclassQuizes.curvesAnalizer;

import org.junit.Test;

import static org.junit.Assert.*;


public class CurveAnalizerTest {
    @Test
    public void testCheck() {
        CurveAnalizer ca = new CurveAnalizer();
        assertEquals(true,  ca.matches(""));
        assertEquals(true,  ca.matches("s"));
        assertEquals(true,  ca.matches("(dsf sdfs)"));
        assertEquals(true,  ca.matches("[sdfsdf]"));
        assertEquals(true,  ca.matches("{}"));
        assertEquals(true,  ca.matches("{(a + d) +c}"));
        assertEquals(true,  ca.matches("{()[]()}"));
        assertEquals(true,  ca.matches("{()[{}]()}"));
        assertEquals(true,  ca.matches("{([])}"));
        assertEquals(true,  ca.matches("{([([])])}"));
        assertEquals(true,  ca.matches("[([([])])]"));
        assertEquals(false, ca.matches("[(]"));
        assertEquals(false, ca.matches("[(}]"));
        assertEquals(false, ca.matches("[)"));
        assertEquals(false, ca.matches("["));
        assertEquals(false, ca.matches("[)]"));
        assertEquals(false, ca.matches("}{"));
        assertEquals(false, ca.matches(")("));
        assertEquals(false, ca.matches("]["));
    }

    @Test
    public void testSecondMethod(){
        CurveAnalizer ca = new CurveAnalizer();
        assertEquals(true,  ca.matchesUsingMap(""));
        assertEquals(true,  ca.matchesUsingMap("s"));
        assertEquals(true,  ca.matchesUsingMap("(dsf sdfs)"));
        assertEquals(true,  ca.matchesUsingMap("[sdfsdf]"));
        assertEquals(true,  ca.matchesUsingMap("{}"));
        assertEquals(true,  ca.matchesUsingMap("{(a + d) +c}"));
        assertEquals(true,  ca.matchesUsingMap("{()[]()}"));
        assertEquals(true,  ca.matchesUsingMap("{()[{}]()}"));
        assertEquals(true,  ca.matchesUsingMap("{([])}"));
        assertEquals(true,  ca.matchesUsingMap("{([([])])}"));
        assertEquals(true,  ca.matchesUsingMap("[([([])])]"));
        assertEquals(false, ca.matchesUsingMap("[(]"));
        assertEquals(false, ca.matchesUsingMap("[(}]"));
        assertEquals(false, ca.matchesUsingMap("[)"));
        assertEquals(false, ca.matchesUsingMap("[)]"));
        assertEquals(false, ca.matchesUsingMap("}{"));
        assertEquals(false, ca.matchesUsingMap(")("));
        assertEquals(false, ca.matchesUsingMap("]["));
    }

}