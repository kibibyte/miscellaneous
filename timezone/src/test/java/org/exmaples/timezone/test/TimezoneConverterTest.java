package org.exmaples.timezone.test;

import org.examples.timezone.TimeZoneConverter;
import org.junit.Assert;
import org.junit.Test;



public class TimezoneConverterTest {

    private TimeZoneConverter timeZoneConverter = new TimeZoneConverter();

    @Test
    public void shouldConvertDate() {
        String convertedDate =
                timeZoneConverter.convertDate("03\\24\\/1980 16:00:00", "Europe/Warsaw", "America/New York");
        Assert.assertEquals("03\\24\\/1980 11:00:00", convertedDate);
    }
}
