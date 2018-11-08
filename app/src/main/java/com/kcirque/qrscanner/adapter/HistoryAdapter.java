package com.kcirque.qrscanner.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kcirque.qrscanner.R;
import com.kcirque.qrscanner.db.entity.History;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryHolder> {
    private List<History> histories = new ArrayList<>();

    @NonNull
    @Override
    public HistoryHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.history_item, viewGroup, false);
        return new HistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryHolder historyHolder, int i) {
        History history = histories.get(i);
        historyHolder.contextTextView.setText(history.getContext());
        historyHolder.dateTextView.setText(history.getDate());
    }

    public void setHistories(List<History> histories) {
        this.histories = histories;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class HistoryHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.contextTextView)
        TextView contextTextView;
        @BindView(R.id.dateTextView)
        TextView dateTextView;

        public HistoryHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(itemView);
        }
    }
}
