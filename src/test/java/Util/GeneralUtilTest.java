package Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GeneralUtilTest {

    @Test
    void samoSlovaTrue() {
        String s = "DZami";
        Assertions.assertEquals(true, GeneralUtil.samoSlova(s));
    }

    @Test
    void samoSlovaFalse() {
        String s = "Dz2A.i";
        Assertions.assertEquals(false, GeneralUtil.samoSlova(s));
    }

    @Test
    void samoSlovaEmpty() {
        String s = "";
        Assertions.assertEquals(false, GeneralUtil.samoSlova(s));
    }

    @Test
    void samoSlovaNull() {
        String s = null;
        Assertions.assertEquals(false, GeneralUtil.samoSlova(s));
    }

    @Test
    void samoCifreTrue() {
        String s = "321321";
        Assertions.assertEquals(true, GeneralUtil.samoCifre(s));
    }

    @Test
    void samoCifreFalse() {
        String s = "M3ksa3KAS";
        Assertions.assertEquals(false, GeneralUtil.samoCifre(s));
    }

    @Test
    void samoCifreEmpty() {
        String s = "";
        Assertions.assertEquals(false, GeneralUtil.samoCifre(s));
    }

    @Test
    void samoCifreNull() {
        String s = null;
        Assertions.assertEquals(false, GeneralUtil.samoCifre(s));
    }
}