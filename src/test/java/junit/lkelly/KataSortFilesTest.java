package junit.lkelly;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class KataSortFilesTest {
    String preSorting;
    String postSorting;

    public KataSortFilesTest(String preSorting, String postSorting) {
        this.preSorting = preSorting;
        this.postSorting = postSorting;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> establecerDatosDePrueba() {
        List<Object[]> datosDePrueba = new ArrayList<>();
        String preS1 = "myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n" + "17945;10091;10088;3907;10132\n" + "2;12;13;48;11";
        String postS1 = "Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n" + "3907;17945;10091;10088;10132\n" + "48;2;12;13;11";
        datosDePrueba.add(new Object[]{preS1, postS1});
        String preS2 = "IronMan;Thor;Captain America;Hulk\n" + "arrogant;divine;honorably;angry\n" + "armor;hammer;shield;greenhorn\n" + "Tony;Thor;Steven;Bruce";
        String postS2 = "Captain America;Hulk;IronMan;Thor\n" + "honorably;angry;arrogant;divine\n" + "shield;greenhorn;armor;hammer\n" + "Steven;Bruce;Tony;Thor";
        datosDePrueba.add(new Object[] {preS2, postS2});
        return datosDePrueba;
    }

    @Test
    public void test() {
        assertEquals(postSorting, KataSortFiles.SortCsvColumns(preSorting));
    }

}
