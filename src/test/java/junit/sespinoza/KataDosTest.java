package junit.sespinoza;

import org.junit.Test;

import static org.junit.Assert.*;

public class KataDosTest {

    @Test
    public void test1(){assertEquals("HELLO WORLD", KataDos.toAlternativeString("hello world"));}

    @Test
    public void test2(){assertEquals("hello world", KataDos.toAlternativeString("HELLO WORLD"));}

    @Test
    public void test3(){assertEquals("HELLO world", KataDos.toAlternativeString("hello WORLD"));}

    @Test
    public void test4(){assertEquals("hEllO wOrld", KataDos.toAlternativeString("HeLLo WoRLD"));}

    @Test
    public void test5(){assertEquals("Hello World", KataDos.toAlternativeString(KataDos.toAlternativeString("Hello World")));}

    @Test
    public void test6(){assertEquals("12345", KataDos.toAlternativeString("12345"));}

    @Test
    public void test7(){assertEquals("1A2B3C4D5E", KataDos.toAlternativeString("1a2b3c4d5e"));}

    @Test
    public void test8(){assertEquals("sTRINGuTILS.TOaLTERNATINGcASE", KataDos.toAlternativeString("StringUtils.toAlternatingCase"));}

    @Test
    public void test9(){assertEquals("ALTerNAtiNG CaSe", KataDos.toAlternativeString("altERnaTIng cAsE"));}

    @Test
    public void test10(){assertEquals("altERnaTIng cAsE", KataDos.toAlternativeString("ALTerNAtiNG CaSe"));}

    @Test
    public void test11(){assertEquals("ALTerNAtiNG CaSe <=> altERnaTIng cAsE", KataDos.toAlternativeString("altERnaTIng cAsE <=> ALTerNAtiNG CaSe"));}

    @Test
    public void test12(){assertEquals("altERnaTIng cAsE <=> ALTerNAtiNG CaSe", KataDos.toAlternativeString("ALTerNAtiNG CaSe <=> altERnaTIng cAsE"));}

}