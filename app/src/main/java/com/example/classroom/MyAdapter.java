package com.example.classroom;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<String> mDataset;
    private OnItemsListener mOnItemsListener;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case

        OnItemsListener onItemsListener;

        public LinearLayout linearlayout;
        public MyViewHolder(LinearLayout v, OnItemsListener onItemsListener) {
            super(v);
            linearlayout = v;
            v.setOnClickListener(this);
            this.onItemsListener = onItemsListener;
        }

        @Override
        public void onClick(View view) {
            onItemsListener.onItemClick(getAdapterPosition() );

        }
    }

    public interface OnItemsListener{
        void onItemClick(int position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(ArrayList<String> myDataset, OnItemsListener onItemsListener) {
        mDataset = myDataset;
        this.mOnItemsListener = onItemsListener;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        //...
        MyViewHolder vh = new MyViewHolder(v,  mOnItemsListener);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        TextView tv = (TextView) holder.linearlayout.findViewById(R.id.personName);
        tv.setText(mDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}