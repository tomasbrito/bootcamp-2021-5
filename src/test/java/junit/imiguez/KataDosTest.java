package junit.imiguez;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataDosTest {

    @Test
    public void KataDosTest1() {
        assertEquals("HELLO WORLD", KataDos.toAlternativeString("hello world"));
    }

    @Test
    public void KataDosTest2() {
        assertEquals("hello world", KataDos.toAlternativeString("HELLO WORLD"));
    }

    @Test
    public void KataDosTest3() {
        assertEquals("HELLO world", KataDos.toAlternativeString("hello WORLD"));
    }

    @Test
    public void KataDosTest4() {
        assertEquals("hEllO wOrld", KataDos.toAlternativeString("HeLLo WoRLD"));
    }

    @Test
    public void KataDosTest5() {
        assertEquals("Hello World", KataDos.toAlternativeString(KataDos.toAlternativeString("Hello World")));
    }

    @Test
    public void KataDosTest6() {
        assertEquals("12345", KataDos.toAlternativeString("12345"));
    }

    @Test
    public void KataDosTest7() {
        assertEquals("1A2B3C4D5E", KataDos.toAlternativeString("1a2b3c4d5e"));
    }

    @Test
    public void KataDosTest8() {
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", KataDos.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void KataDosTest9() {
        assertEquals("ALTerNAtiNG CaSe", KataDos.toAlternativeString("altERnaTIng cAsE"));
    }

    @Test
    public void KataDosTest10() {
        assertEquals("altERnaTIng cAsE", KataDos.toAlternativeString("ALTerNAtiNG CaSe"));
    }

    @Test
    public void KataDosTest11() {
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", KataDos.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
    }

    @Test
    public void KataDosTest12() {
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", KataDos.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }

}
