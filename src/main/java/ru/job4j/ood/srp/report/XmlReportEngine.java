package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class XmlReportEngine implements Report {

    private final Store store;
    JAXBContext context;
    Marshaller marshaller;

    public XmlReportEngine(Store store) throws JAXBException {
        this.store = store;
        context = JAXBContext.newInstance(Employees.class);
        marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = new ArrayList<>();
        employees.addAll(store.findBy(filter));
        String result = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(new Employees(employees), writer);
            result = writer.getBuffer().toString();
        } catch (IOException e) {
                e.printStackTrace();
        } catch (JAXBException e) {
                e.printStackTrace();
        }
        return result;
    }
}
