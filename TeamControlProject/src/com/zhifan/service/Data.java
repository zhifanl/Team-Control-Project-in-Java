package com.zhifan.service;

public class Data {
    public static final int EMPLOYEE = 10;
    public static final int PROGRAMMER = 11;
    public static final int DESIGNER = 12;
    public static final int ARCHITECT = 13;

    public static final int PC = 21;
    public static final int NOTEBOOK = 22;
    public static final int PRINTER = 23;

    //Employee  :  10, id, name, age, salary
    //Programmer:  11, id, name, age, salary
    //Designer  :  12, id, name, age, salary, bonus
    //Architect :  13, id, name, age, salary, bonus, stock
    public static final String[][] EMPLOYEES = {
        {"10", "1", "Tom", "22", "3000"},
        {"13", "2", "Jerry", "32", "18000", "15000", "2000"},
        {"11", "3", "Matthew", "23", "7000"},
        {"11", "4", "Jack", "24", "7300"},
        {"12", "5", "Colin", "28", "10000", "5000"},
        {"11", "6", "David", "22", "6800"},
        {"12", "7", "Ethan", "29", "10800","5200"},
        {"13", "8", "Frank", "30", "19800", "15000", "2500"},
        {"12", "9", "George", "26", "9800", "5500"},
        {"11", "10", "Hilton", "21", "6600"},
        {"11", "11", "Iris", "25", "7100"},
        {"12", "12", "Kris", "27", "9600", "4800"}
    };
    
    //PC      :21, model, display
    //NoteBook:22, model, price
    //Printer :23, type, name
    public static final String[][] EQIPMENTS = {
        {},      //employ does not have any equipment..
        {"22", "联想T4", "6000"},
        {"21", "戴尔", "NEC17寸"},
        {"21", "戴尔", "三星 17寸"},
        {"23", "激光", "佳能 2900"},
        {"21", "华硕", "三星 17寸"},
        {"21", "华硕", "三星 17寸"},
        {"23", "针式", "爱普生20K"},
        {"22", "惠普m6", "5800"},
        {"21", "戴尔", "NEC 17寸"},
        {"21", "华硕","三星 17寸"},
        {"22", "惠普m6", "5800"}
    };
}