package psu.kit.tanya;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TanyaCalculatorTest {
    private TanyaCalculator calc;


    @BeforeMethod
    public void setUp() throws Exception {
        calc = new TanyaCalculator();
    }

    @DataProvider(name = "Tanya")
    public Object[][] getTanya(){
        return new Object[][]{
                {"AbC", "DCbA", 3, 0}
        };

    }

    @Test(dataProvider = "Tanya")
    public void testCalculate(String s, String t, int yayCount, int whoopsCount) throws Exception {
        TanyaReaction result = calc.calculate(s, t);
        assertEquals(result.getWhoopsCount(), whoopsCount);
        assertEquals(result.getYayCount(), yayCount);
    }
}