package com.swordartist.recyclerviewapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView.Adapter mAdapter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mRecyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_main, container, false);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter
        // The adapter provides access to the items in your data set, creates views for items, 
        // and replaces the content of some of the views with new data items when the original item is no longer visible.
        String[] myDataset = {"item1",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item2",
                "item3",
                "item4"};
        
        mAdapter = new MyAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);

        return mRecyclerView;
    }
}