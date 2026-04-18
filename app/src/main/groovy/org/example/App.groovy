package org.example

import net.fortuna.ical4j.model.TimeZoneRegistry
import net.fortuna.ical4j.model.TimeZoneRegistryImpl
import net.fortuna.ical4j.model.TimeZone
import net.fortuna.ical4j.model.DateTime

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import java.time.*

class App {
    static void main(String[] args) {
        TimeZoneRegistry timeZoneRegistry = new TimeZoneRegistryImpl()
        TimeZone timeZone = timeZoneRegistry.getTimeZone("Asia/Singapore")
        DateTime dateTime = new DateTime(0)
        dateTime.setTimeZone(timeZone)
        println("Singapore time at epoch time 0:")
        println("   ${dateTime} (should be 07:30!)" )
        println()
        println("Time zone offset in hours at epoch time 0:")
        println("   ${timeZone.getOffset(0) / (60 * 60 * 1000)} (should be 7.5)" )
        println()
        println("Time zone offset at Singapore time 1970-01-01T08:00:00:")
        println("   ${timeZone.getOffset(GregorianCalendar.AD, 1970, 0, 1, 5, 8*60*1000) / (60 * 60 * 1000)} (correct)")
        println()
    }
}
