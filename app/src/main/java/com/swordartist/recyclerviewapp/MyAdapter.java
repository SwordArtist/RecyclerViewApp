package com.swordartist.recyclerviewapp;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Yusuke Yanai on 2017-05-19.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> implements View.OnClickListener {
    private String[] mDataset;
    private Context mContext;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
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
//        final LinearLayout billingDetailLayout = (LinearLayout) v.findViewById(R.id.billing_detail_layout);
        Button viewDetailButton = (Button) v.findViewById(R.id.view_detail_btn);
        viewDetailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout billingDetailLayout = (LinearLayout)((View)v.getParent().getParent()).findViewById(R.id.billing_detail_layout);
                if (billingDetailLayout.getVisibility() == View.GONE) {
                    billingDetailLayout.setVisibility(View.VISIBLE);
                } else {
                    billingDetailLayout.setVisibility(View.GONE);
                }
            }
        });
        
//        ...
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView textView = (TextView)holder.mCardView.findViewById(R.id.textView11);

        textView.setText(mDataset[position]);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(mContext, "Item Clicked", Toast.LENGTH_LONG).show();
    }
}