package com.kcirque.qrscanner.fragment;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kcirque.qrscanner.R;
import com.kcirque.qrscanner.adapter.HistoryAdapter;
import com.kcirque.qrscanner.db.HistoryViewModel;
import com.kcirque.qrscanner.db.entity.History;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.historySwipeRefreshLayout)
    SwipeRefreshLayout historySwipeRefreshLayout;
    @BindView(R.id.historyRecyclerView)
    RecyclerView historyRecyclerView;

    // Variables
    List<History> historyList;
    private RecyclerView.LayoutManager layoutManager;
    private HistoryAdapter adapter;

    HistoryViewModel historyViewModel;

    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ButterKnife.bind(view);
        historyViewModel = ViewModelProviders.of(this).get(HistoryViewModel.class);
        historySwipeRefreshLayout.setOnRefreshListener(this);

        layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        historyRecyclerView.setLayoutManager(layoutManager);
        adapter = new HistoryAdapter();
        historyRecyclerView.setAdapter(adapter);
        getData();
    }

    private void getData() {
        historyViewModel.getAllHistory().observe(this, new Observer<List<History>>() {
            @Override
            public void onChanged(@Nullable List<History> histories) {
                historyList = histories;
                adapter.setHistories(historyList);
            }
        });

    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getData();
                historySwipeRefreshLayout.setRefreshing(false);
            }
        }, 2000);
    }


}
