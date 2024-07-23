package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportForITTest {
    @Test
    public void reportForIT() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Egor", now, now, 100);
        store.add(worker);
        DateTimeParser<Calendar> parser = new ReportDateTimeParser();
        Report report = new ReportForIT(store, parser);
        StringBuilder result = new StringBuilder()
                .append("name;hired;fired;salary")
                .append(System.lineSeparator())
                .append(worker.getName())
                .append(";")
                .append(parser.parse(worker.getHired()))
                .append(";")
                .append(parser.parse(worker.getFired()))
                .append(";")
                .append(worker.getSalary())
                .append(System.lineSeparator());
        assertThat(report.generate(employee -> true)).isEqualTo(result.toString());
    }

}