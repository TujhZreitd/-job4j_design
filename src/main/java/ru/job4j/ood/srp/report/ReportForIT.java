package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportForIT implements Report {
    private final Store store;

    private final DateTimeParser<Calendar> parser;

    public ReportForIT(Store store, DateTimeParser<Calendar> parser) {
        this.store = store;
        this.parser = parser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder result = new StringBuilder()
                .append("name;hired;fired;salary")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            result.append(employee.getName())
                    .append(";")
                    .append(parser.parse(employee.getHired()))
                    .append(";")
                    .append(parser.parse(employee.getFired()))
                    .append(";")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
