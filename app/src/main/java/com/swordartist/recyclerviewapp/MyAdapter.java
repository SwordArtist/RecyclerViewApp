package com.swordartist.recyclerviewapp;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {
    private String[] mDataset;
    private Context mContext;

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
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        CardView v = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.billing_overview_card, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ConstraintLayout constraintLayout = (ConstraintLayout) v.findViewById(R.id.constraint_layout);

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
        LinearLayout billingDetailLayout = (LinearLayout) ((View) v.getParent().getParent()).findViewById(R.id.billing_detail_layout);
        if (billingDetailLayout.getVisibility() == View.GONE) {
            billingDetailLayout.setVisibility(View.VISIBLE);
        } else {
            billingDetailLayout.setVisibility(View.GONE);
        }
    }
}