package com.kcirque.qrscanner.db;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.kcirque.qrscanner.db.entity.History;

import java.util.List;

@Dao
public interface HistoryDao {
    @Insert
    void insertHistory(History history);

    @Update
    void updateHistory(History history);

    @Delete
    void deleteHistory(History history);

    @Query("DELETE FROM History")
    void deleteAllHistory();

    @Query("SELECT * FROM History")
    LiveData<List<History>> getAllHistory();
}
