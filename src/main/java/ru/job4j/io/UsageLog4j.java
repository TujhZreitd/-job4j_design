package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        LOG.debug("User info name : {}, age : {}", name, age);
        byte variableByte = 8;
        short variableShort = 200;
        int variableInt = 1234;
        long variableLong = 4321L;
        float variableFloat = 2.3F;
        double variableDouble = 3.14;
        char variableChar = 'c';
        boolean variableBoolean = true;
        LOG.debug("{}, {}, {}, {}, {}, {}, {}, {}",
                variableByte,
                variableShort,
                variableInt,
                variableLong,
                variableFloat,
                variableDouble,
                variableChar,
                variableBoolean);
    }
}
