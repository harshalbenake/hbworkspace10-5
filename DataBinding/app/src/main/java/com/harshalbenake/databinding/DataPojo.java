package com.harshalbenake.databinding;

public class DataPojo{
    private final String name;
    private final String email;

    public DataPojo(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
