package ru.job4j.ood.srp.report;


import ru.job4j.ood.srp.comparators.SalaryComparator;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class ReportForHR implements Report {
    private final Store store;

    public ReportForHR(Store store) {
        this.store = store;
    }

    private List<Employee> sortStore(Predicate<Employee> filter) {
        List<Employee> result = store.findBy(filter);
        Collections.sort(result, new SalaryComparator());
        return result;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = sortStore(filter);
        StringBuilder result = new StringBuilder()
                .append("Name; salary")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            result.append(employee.getName())
                    .append(" ")
                    .append(employee.getSalary())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
