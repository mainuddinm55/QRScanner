package com.kcirque.qrscanner.db;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.kcirque.qrscanner.db.entity.History;

import java.util.List;

public class HistoryRepository {
    private HistoryDao historyDao;
    private LiveData<List<History>> allHistory;

    public HistoryRepository(Application application) {
        HistoryDatabase database = HistoryDatabase.getInstance(application);
        historyDao = database.historyDao();
        allHistory = historyDao.getAllHistory();
    }

    public void insertHistory(History history) {
        new InsertHistoryAsyncTask(historyDao).execute(history);
    }

    public void updateHistory(History history) {
        new UpdateHistoryAsyncTask(historyDao).execute(history);
    }

    public void deleteHistory(History history) {
        new DeleteHistoryAsyncTask(historyDao).execute(history);
    }

    public void deleteAllHistory() {
        new DeleteAllHistoryAsyncTask(historyDao).execute();
    }

    public LiveData<List<History>> getAllHistory() {
        return allHistory;
    }

    public static class InsertHistoryAsyncTask extends AsyncTask<History, Void, Void> {
        private HistoryDao historyDao;

        public InsertHistoryAsyncTask(HistoryDao historyDao) {
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... history) {
            historyDao.insertHistory(history[0]);
            return null;
        }
    }


    public static class UpdateHistoryAsyncTask extends AsyncTask<History, Void, Void> {
        private HistoryDao historyDao;

        public UpdateHistoryAsyncTask(HistoryDao historyDao) {
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... history) {
            historyDao.updateHistory(history[0]);
            return null;
        }
    }

    public static class DeleteHistoryAsyncTask extends AsyncTask<History, Void, Void> {
        private HistoryDao historyDao;

        public DeleteHistoryAsyncTask(HistoryDao historyDao) {
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(History... histories) {
            historyDao.deleteHistory(histories[0]);
            return null;
        }
    }

    public static class DeleteAllHistoryAsyncTask extends AsyncTask<Void, Void, Void> {
        private HistoryDao historyDao;

        public DeleteAllHistoryAsyncTask(HistoryDao historyDao) {
            this.historyDao = historyDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            historyDao.deleteAllHistory();
            return null;
        }
    }
}
