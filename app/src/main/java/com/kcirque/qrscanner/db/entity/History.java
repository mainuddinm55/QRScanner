package com.kcirque.qrscanner.db.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class History implements Serializable {
    @ColumnInfo()
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String date;
    private String context;

    @Ignore
    public History(String date, String context) {
        this.date = date;
        this.context = context;
    }

    public History() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }


}
