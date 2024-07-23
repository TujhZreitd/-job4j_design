package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;
import java.util.function.Predicate;

public class ReportEngine implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dataTimeParser;

    public ReportEngine(Store store, DateTimeParser<Calendar> dataTimeParser) {
        this.store = store;
        this.dataTimeParser = dataTimeParser;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(" ")
                    .append(dataTimeParser.parse(employee.getHired()))
                    .append(" ")
                    .append(dataTimeParser.parse(employee.getFired()))
                    .append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
