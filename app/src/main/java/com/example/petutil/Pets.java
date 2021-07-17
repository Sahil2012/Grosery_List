package com.example.petutil;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PetsInfo")
public class Pets {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "name")
    private String Name;

    @NonNull
    @ColumnInfo(name = "breed")
    private String Breed;

    @ColumnInfo(name = "gender")
    private boolean sex;

    @NonNull
    @ColumnInfo(name = "weight")
    private String weight;

    public Pets(String Name,String Breed,boolean sex,String weight) {
        this.Name = Name;
        this.Breed = Breed;
        this.sex = sex;
        this.weight = weight;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBreed() {
        return Breed;
    }

    public void setBreed(String breed) {
        Breed = breed;
    }

    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
