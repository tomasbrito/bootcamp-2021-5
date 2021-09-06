package junit.imiguez;

import org.junit.Assert;
import org.junit.Test;

public class CSVFileSortTest {

    @Test
    public void test01() {
        String file = "myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n" +
                "17945;10091;10088;3907;10132\n" +
                "2;12;13;48;11";
        String expected = "Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n" +
                "3907;17945;10091;10088;10132\n" +
                "48;2;12;13;11";
        Assert.assertEquals(expected, CSVFileSort.sortCsvColumns(file));
    }

}
