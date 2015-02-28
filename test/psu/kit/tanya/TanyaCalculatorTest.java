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
    public Object[][] getTanya() {
        return new Object[][] {
                // codeforces tests
                {"AbC", "DCbA", 3, 0},
                {"ABC", "abc", 0, 3},
                {"abacaba", "AbaCaBA", 3, 4},
                {"zzzzz", "ZZZZZ", 0, 5},
                {"zzzZZZ", "ZZZzzZ", 5, 1},
                {"abcdefghijklmnopqrstuvwxyz", "ABCDEFGHIJKLMNOPQRSTUVWXYZ", 0, 26},
                {"l", "FPbAVjsMpPDTLkfwNYFmBDHPTDSWSOUlrBHYJHPM", 1, 0},
                {"ncMeXssLHS", "uwyeMcaFatpInZVdEYpwJQSnVxLK", 6, 1},
                {"DpiNBmCRFWxpdbfGOzvvOcemjructoAdEwegTvbVbfWWRPGyEAxGdDRWVlqNyGWMWHMrHAIZpyxvgaflrsVZhhZRouvpxrKXFZam",
                        "wwPLFtNfPtJXvMLuHjKfYyaRhreNSWSzOvDpqHCGcqllACNPGHxReeFUCmAqIKXYytsSQwIxJzNiiUtgebVuwRmWpRALLyKAzyDPvgIGxALSaeeTIqm\n", 66, 12},
                {"sabc", "AbCsS", 2, 2},
                {"x", "xX", 1, 0}
        };
    }

    @Test(dataProvider = "Tanya")
    public void testCalculate(String s, String t, int yayCount, int whoopsCount) throws Exception {
        TanyaReaction result = calc.calculate(s, t);
        assertEquals(result.getWhoopsCount(), whoopsCount);
        assertEquals(result.getYayCount(), yayCount);
    }
}
