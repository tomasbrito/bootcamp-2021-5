package junit.lvazquez;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataCuatroTest {
    @Test
    public void test1() {
        String preSorting = "myjinxin2015;raulbc777;smile67;Dentzil;SteffenVogel_79\n"
                + "17945;10091;10088;3907;10132\n"
                + "2;12;13;48;11";
        String postSorting = "Dentzil;myjinxin2015;raulbc777;smile67;SteffenVogel_79\n"
                + "3907;17945;10091;10088;10132\n"
                + "48;2;12;13;11";
        assertEquals(postSorting, KataCuatro.sortCsvColumns(preSorting));
    }

    @Test
    public void test2() {
        String preSorting = "IronMan;Thor;Captain America;Hulk\n"
                + "arrogant;divine;honorably;angry\n"
                + "armor;hammer;shield;greenhorn\n"
                + "Tony;Thor;Steven;Bruce";
        String postSorting = "Captain America;Hulk;IronMan;Thor\n"
                + "honorably;angry;arrogant;divine\n"
                + "shield;greenhorn;armor;hammer\n"
                + "Steven;Bruce;Tony;Thor";
        assertEquals(postSorting, KataCuatro.sortCsvColumns(preSorting));
    }

    @Test
    public void testPropio(){

        String preSorting = "Celeste;Dorado;Azul;Blanco\n"
                + "3;4;1;2\n"
                + "c;d;a;b";

        String postSorting = "Azul;Blanco;Celeste;Dorado\n"
                + "1;2;3;4\n"
                + "a;b;c;d";

        assertEquals(postSorting, KataCuatro.sortCsvColumns(preSorting));
    }
}