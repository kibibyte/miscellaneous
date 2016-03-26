package org.examples.timezone;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class DateConverter {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    public String convert(String date, String sourceTimeZone, String destinationTimeZone) {
        ZoneId sourceZoneId = ZoneId.of(sourceTimeZone);
        ZoneId destinationZoneId = ZoneId.of(destinationTimeZone);
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        ZonedDateTime sourceTime = ZonedDateTime.of(dateTime, sourceZoneId);
        ZonedDateTime destinationTime = sourceTime.withZoneSameInstant(destinationZoneId);
        return destinationTime.format(formatter);
    }

}
