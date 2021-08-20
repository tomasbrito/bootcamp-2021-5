package junit.ebalcaldi;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Kata2Test {
    @Test
    public void fixedTests() {
        assertEquals("hOLA", Kata2.toAlternativeString("Hola"));


    }

    @Test
    public void kataTitleTests() {
        assertEquals("ALTerNAtiNG CaSe", Kata2.toAlternativeString("altERnaTIng cAsE"));
        assertEquals("altERnaTIng cAsE", Kata2.toAlternativeString("ALTerNAtiNG CaSe"));
        assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", Kata2.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));
        assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", Kata2.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));
    }
}
