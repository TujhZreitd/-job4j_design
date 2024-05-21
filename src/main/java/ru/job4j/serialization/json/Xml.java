package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;
import javax.xml.bind.JAXBException;
import java.util.ArrayList;
import java.util.List;

public class Xml {
    public static void main(String[] args) throws JAXBException {

        /* JSONObject из json-строки строки */
        JSONObject jsonModel = new JSONObject("{\"engine\":\"250\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Automatic transmission");
        list.add("Climate control");
        JSONArray jsonEquipments = new JSONArray(list);

        /* JSONObject напрямую методом put */
        Car car = new Car(true, 2, "Chevrolet",
                new Engine(250),
                new String[]{"Automatic transmission", "Climate control"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cabriolet", car.isCabriolet());
        jsonObject.put("quantityDoors", car.getQuantityDoors());
        jsonObject.put("model", jsonModel);
        jsonObject.put("statuses", jsonEquipments);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(car).toString());
    }
}
