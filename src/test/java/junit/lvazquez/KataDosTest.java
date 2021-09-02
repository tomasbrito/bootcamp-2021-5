package junit.lvazquez;

import org.junit.Test;

import static org.junit.Assert.*;

public class KataDosTest {

    @Test
    public void fixedTests() {
        assertEquals("HELLO WORLD", KataDos.toAlternativeString("hello world"));
        assertEquals("hello world", KataDos.toAlternativeString("HELLO WORLD"));
        assertEquals("HELLO world", KataDos.toAlternativeString("hello WORLD"));
        assertEquals("hEllO wOrld", KataDos.toAlternativeString("HeLLo WoRLD"));
        assertEquals("Hello World", KataDos.toAlternativeString(KataDos.toAlternativeString("Hello World")));
        assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", KataDos.toAlternativeString("StringUtils.toAlternatingCase"));
    }

    @Test
    public void testNums(){
        assertEquals("12345", KataDos.toAlternativeString("12345"));
        assertEquals("1A2B3C4D5E", KataDos.toAlternativeString("1a2b3c4d5e"));
    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", KataDos.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", KataDos.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", KataDos.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", KataDos.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}