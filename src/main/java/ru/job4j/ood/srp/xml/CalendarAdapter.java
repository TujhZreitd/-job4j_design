package ru.job4j.ood.srp.xml;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarAdapter extends XmlAdapter<String, Calendar> {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd:MM:yyyy HH:mm");

    @Override
    public String marshal(Calendar calendar) throws Exception {
        return DATE_FORMAT.format(calendar.getTime());
    }

    @Override
    public Calendar unmarshal(String string) throws Exception {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(DATE_FORMAT.parse(string));
        return calendar;
    }
}
