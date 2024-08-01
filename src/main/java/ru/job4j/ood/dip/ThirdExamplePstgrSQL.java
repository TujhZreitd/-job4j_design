package ru.job4j.ood.dip;

public class ThirdExamplePstgrSQL {
    void save() {
        System.out.println("Save info");
    }
}

class DataBase {
    ThirdExamplePstgrSQL pstgrSQL;

    public DataBase(ThirdExamplePstgrSQL pstgrSQL) {
        this.pstgrSQL = pstgrSQL;
    }
}
