package com.room.flores.list_dinamyc_android;

public class Person {
    private int id;
    private String name;
    private String dni;

    public Person(int id, String name, String dni) {
        this.id = id;
        this.name = name;
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }
}
