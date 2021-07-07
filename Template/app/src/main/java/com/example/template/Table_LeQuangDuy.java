package com.example.template;

public class Table_LeQuangDuy {
    private int columnInt;
    private String columnString;
    private double columnDouble;
    private int columnBoolean;

    public Table_LeQuangDuy(int columnInt, String columnString, double columnDouble, int columnBoolean) {
        this.columnInt = columnInt;
        this.columnString = columnString;
        this.columnDouble = columnDouble;
        this.columnBoolean = columnBoolean;
    }

    public Table_LeQuangDuy(String columnString, double columnDouble, int columnBoolean) {
        this.columnString = columnString;
        this.columnDouble = columnDouble;
        this.columnBoolean = columnBoolean;
    }

    public int getColumnInt() {
        return columnInt;
    }

    public void setColumnInt(int columnInt) {
        this.columnInt = columnInt;
    }

    public String getColumnString() {
        return columnString;
    }

    public void setColumnString(String columnString) {
        this.columnString = columnString;
    }

    public double getColumnDouble() {
        return columnDouble;
    }

    public void setColumnDouble(double columnDouble) {
        this.columnDouble = columnDouble;
    }

    public int isColumnBoolean() {
        return columnBoolean;
    }

    public void setColumnBoolean(int columnBoolean) {
        this.columnBoolean = columnBoolean;
    }
}
