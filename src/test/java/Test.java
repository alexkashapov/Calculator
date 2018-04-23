

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test

    public void sum() {
        assertEquals(6.0, 6.0,0.5);
    }
    @org.junit.Test
    public void fail() {
        assertEquals(6.0, 5.0,0.5);
    }

}