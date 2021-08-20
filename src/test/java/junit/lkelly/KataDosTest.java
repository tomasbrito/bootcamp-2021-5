package junit.lkelly;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataDosTest {
    @Test
    public void fixedTest1() {
        assertEquals("HELLO WORLD", KataDos.toAlternativeString("hello world"));
          }
    @Test
    public void fixedTest2() {
        assertEquals("hello world", KataDos.toAlternativeString("HELLO WORLD"));
    }
    @Test
    public void fixedTest3() {
        assertEquals("HELLO world", KataDos.toAlternativeString("hello WORLD"));
    }
    @Test
    public void fixedTest4() {
        assertEquals("hEllO wOrld", KataDos.toAlternativeString("HeLLo WoRLD"));
    }
    @Test
    public void fixedTest5() {
        assertEquals("Hello World", KataDos.toAlternativeString(KataDos.toAlternativeString("Hello World")));
    }
    @Test
    public void fixedTest6() {
        assertEquals("12345", KataDos.toAlternativeString("12345"));
    }
    @Test
    public void fixedTest7() {
        assertEquals("1A2B3C4D5E", KataDos.toAlternativeString("1a2b3c4d5e"));
    }
    @Test
    public void fixedTest8() {
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", KataDos.toAlternativeString("StringUtils.toAlternatingCase"));
    }



    @Test
    public void kataTitleTest1() {
        assertEquals("ALTerNAtiNG CaSe", KataDos.toAlternativeString("altERnaTIng cAsE"));
    }
    @Test
    public void kataTitleTest2() {
        assertEquals("altERnaTIng cAsE", KataDos.toAlternativeString("ALTerNAtiNG CaSe"));
    }
    @Test
    public void kataTitleTest3() {
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", KataDos.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
    }
    @Test
    public void kataTitleTest4() {
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", KataDos.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}
