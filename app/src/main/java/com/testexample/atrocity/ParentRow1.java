package com.testexample.atrocity;

import java.util.ArrayList;

public class ParentRow1 {
    private String name;
    private ArrayList<ChildRow> childList;

    public ParentRow1(String name, ArrayList<ChildRow> childList) {
        this.name = name;
        this.childList = childList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<ChildRow> getChildList() {
        return childList;
    }

    public void setChildList(ArrayList<ChildRow> childList) {
        this.childList = childList;
    }
}

