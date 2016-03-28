package org.exmaples.timezone.test;

import java.time.zone.ZoneRulesException;

import org.examples.timezone.DateConverter;
import org.junit.Assert;
import org.junit.Test;



public class DateConverterTest {

    private DateConverter dateConverter = new DateConverter();

    @Test
    public void shouldConvertDate() {
        String convertedDate = dateConverter.convert("03/24/1980 16:00:00", "Europe/Warsaw", "America/New_York");
        Assert.assertEquals("03/24/1980 10:00:00", convertedDate);
    }

    @Test(expected = ZoneRulesException.class)
    public void shouldNotConvertDateWrongTimeZone() {
        dateConverter.convert("03/24/1980 16:00:00", "Test", "America/New_York");
    }

}
