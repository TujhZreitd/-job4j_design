package ru.job4j.ood.srp.comparators;

import ru.job4j.ood.srp.model.Employee;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        /*int result;
        if (o1.getSalary() > o2.getSalary()) {
            result = -1;
        } else if (o1.getSalary() == o2.getSalary()) {
            result = 0;
        } else {
            result = 1;
        }
        return result;
        */
        return (int) (o2.getSalary() - o1.getSalary());
    }
}
