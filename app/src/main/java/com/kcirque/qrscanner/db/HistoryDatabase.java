package com.kcirque.qrscanner.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.kcirque.qrscanner.db.entity.History;

import static com.kcirque.qrscanner.db.HistoryDatabase.DATABASE_VERSION;

@Database(entities = {History.class}, version = DATABASE_VERSION)
public abstract class HistoryDatabase extends RoomDatabase {
    private static HistoryDatabase instance;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "history_database";

    public abstract HistoryDao historyDao();

    public static synchronized HistoryDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, HistoryDatabase.class, DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }


}
