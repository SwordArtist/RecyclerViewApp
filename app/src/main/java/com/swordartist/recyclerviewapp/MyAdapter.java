package com.swordartist.recyclerviewapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {
    private String[] mDataset;
    private Context mContext;
    private ArrayList<Boolean> detailLayoutExpandStates = new ArrayList<>();

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        public CardView mCardView;

        public ViewHolder(CardView v) {
            super(v);
            mCardView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(Context context, String[] myDataset) {
        mContext = context;
        mDataset = myDataset;

        // initialize layout state list
        for (int i = 0; i < mDataset.length; i++) {
            detailLayoutExpandStates.add(false);
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.overview_card, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView textView = (TextView) holder.mCardView.findViewById(R.id.textView11);
        textView.setText(mDataset[position]);

        // set visibility for detail layout based on the saved status 
        LinearLayout detailLayout = (LinearLayout) holder.mCardView.findViewById(R.id.detail_linearlayout);
        if (detailLayoutExpandStates.get(position)) {
            detailLayout.setVisibility(View.VISIBLE);
        } else {
            detailLayout.setVisibility(View.GONE);
        }

        MyButton viewDetailButton = (MyButton) ((View) textView.getParent().getParent()).findViewById(R.id.view_detail_btn);
        viewDetailButton.setOnClickListenerCustom(this, position);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public void onClick(View v) {
        // Change detail layout visibility, also save the status.
        LinearLayout detailLayout = (LinearLayout) ((View) v.getParent().getParent()).findViewById(R.id.detail_linearlayout);
        if (detailLayout.getVisibility() == View.GONE) {
            detailLayoutExpandStates.set(((MyButton) v).position, Boolean.TRUE);
            detailLayout.setVisibility(View.VISIBLE);
        } else {
            detailLayoutExpandStates.set(((MyButton) v).position, Boolean.FALSE);
            detailLayout.setVisibility(View.GONE);
        }
    }
}