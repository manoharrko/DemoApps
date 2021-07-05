package com.example.demoapp;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerItemViewHolder> {

    ArrayList<RecyclerData> myList;
    int mLastPosition = 0;

    public RecyclerAdapter(ArrayList<RecyclerData> myList) {
        this.myList = myList;
    }


    @Override
    public RecyclerItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        RecyclerItemViewHolder holder = new RecyclerItemViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerItemViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.etTitleTextView.setText(myList.get(position).getTitle());
        holder.etDescriptionTextView.setText(myList.get(position).getDescription());
//        holder.crossImage.setImageResource(R.drawable.cross);
        mLastPosition =position;
    }

    @Override
    public int getItemCount() {
        return myList.size();
    }

    public void notifyData(ArrayList<RecyclerData> myList) {
        myList = myList;
    }

    public class RecyclerItemViewHolder extends RecyclerView.ViewHolder {

        private final TextView etTitleTextView;
        private final TextView etDescriptionTextView;
        private LinearLayout mainLayout;

        public RecyclerItemViewHolder(final View itemView) {
            super(itemView);
            etTitleTextView = itemView.findViewById(R.id.txtTitle);
            etDescriptionTextView = itemView.findViewById(R.id.txtDescription);

        }
    }
}