package com.example.template;

public class Student {
    private String urlAvatar,name,nameClass,id,birthday;
    private boolean isSelected;

    public Student(String name, String nameClass, String id, String birthday, boolean isSelected) {
        this.name = name;
        this.nameClass = nameClass;
        this.id = id;
        this.birthday = birthday;
        this.isSelected = isSelected;
    }



    public String getUrlAvatar() {
        return urlAvatar;
    }

    public void setUrlAvatar(String urlAvatar) {
        this.urlAvatar = urlAvatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }
}
