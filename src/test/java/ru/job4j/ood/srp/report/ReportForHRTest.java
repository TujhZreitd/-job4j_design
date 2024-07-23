package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportForHRTest {
    @Test
    public void reportForHR() {
        Store store = new MemoryStore();
        Calendar now = Calendar.getInstance();
        Employee workerFirst = new Employee("Ivan", now, now, 100);
        Employee workerSecond = new Employee("Egor", now, now, 300);
        Employee workerThird = new Employee("Alex", now, now, 200);
        store.add(workerFirst);
        store.add(workerSecond);
        store.add(workerThird);
        Report reportForHR = new ReportForHR(store);
        StringBuilder expected = new StringBuilder()
                .append("Name; salary")
                .append(System.lineSeparator())
                .append(workerSecond.getName())
                .append(" ")
                .append(workerSecond.getSalary())
                .append(System.lineSeparator())
                .append(workerThird.getName())
                .append(" ")
                .append(workerThird.getSalary())
                .append(System.lineSeparator())
                .append(workerFirst.getName())
                .append(" ")
                .append(workerFirst.getSalary())
                .append(System.lineSeparator());
        assertThat(reportForHR.generate(employee -> true)).isEqualTo(expected.toString());
    }

}