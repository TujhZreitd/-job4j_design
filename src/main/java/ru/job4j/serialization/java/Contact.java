package ru.job4j.serialization.java;

import java.io.*;
import java.nio.file.Files;

public class Contact implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public Contact(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{"
                + "zipCode="
                + zipCode
                + ", phone='"
                + phone
                + '\''
                + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final Contact contact = new Contact(123456, "8-987-654-32-10");

        File tempFile = Files.createTempFile(null, null).toFile();
        try (ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(tempFile))) {
            output.writeObject(contact);
        }
        try (ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(tempFile))) {
            System.out.println(input.readObject());
        }
    }
}
