package com.example.ashutosh.dbproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class SingleAdapter extends RecyclerView.Adapter<SingleAdapter.ViewHolder> {
    Context context;
    List<String> data;

    public SingleAdapter(Context context,List<String> data)
    {
        this.context = context;
        this.data=data;
    }

    @NonNull
    @Override
    public SingleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_single, null);
        SingleAdapter.ViewHolder viewHolder = new SingleAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SingleAdapter.ViewHolder holder, int position) {
        holder.s_tv.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView s_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            s_tv = (TextView) itemView.findViewById(R.id.s_tv);
        }
    }
}
