package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.json.CalendarSerializer;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Predicate;

public class JsonReportEngine implements Report {

    private final Store store;

    private final Gson gson;

    public JsonReportEngine(Store store) {
        this.store = store;
        this.gson = new GsonBuilder()
                .registerTypeAdapter(Calendar.class, new CalendarSerializer())
                .registerTypeAdapter(GregorianCalendar.class, new CalendarSerializer())
                .setPrettyPrinting()
                .create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : store.findBy(filter)) {
            result.add(employee);
        }
        return gson.toJson(result);
    }
}
