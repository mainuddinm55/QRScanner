package com.kcirque.qrscanner.db;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.kcirque.qrscanner.db.entity.History;

import java.util.List;

public class HistoryViewModel extends AndroidViewModel {
    private HistoryRepository historyRepository;
    private LiveData<List<History>> allHistory;

    public HistoryViewModel(@NonNull Application application) {
        super(application);
        historyRepository = new HistoryRepository(application);
        allHistory = historyRepository.getAllHistory();
    }

    public void insertHistory(History history) {
        historyRepository.insertHistory(history);
    }

    public void updateHistory(History history) {
        historyRepository.updateHistory(history);
    }

    public void deleteHistory(History history) {
        historyRepository.deleteHistory(history);
    }

    public void deleteAllHistory() {
        historyRepository.deleteAllHistory();
    }

    public LiveData<List<History>> getAllHistory() {
        return allHistory;
    }
}
