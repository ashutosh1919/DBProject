package com.example.ashutosh.dbproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class FourthAdapter extends RecyclerView.Adapter<FourthAdapter.ViewHolder> {

    Context context;
    List<FourthResult> data;

    public FourthAdapter(Context context,List<FourthResult> data)
    {
        this.context = context;
        this.data=data;
    }

    @NonNull
    @Override
    public FourthAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_fourth_que, null);
        FourthAdapter.ViewHolder viewHolder = new FourthAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull FourthAdapter.ViewHolder holder, int position) {
        holder.roll_tv.setText(data.get(position).getRoll_No());
        holder.fname_tv.setText(data.get(position).getFname());
        holder.minit_tv.setText(data.get(position).getMinit());
        holder.lname_tv.setText(data.get(position).getLname());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView roll_tv,fname_tv,minit_tv,lname_tv;

        public ViewHolder(View itemView) {
            super(itemView);
            roll_tv = (TextView) itemView.findViewById(R.id.roll_tv);
            fname_tv = itemView.findViewById(R.id.fname_tv);
            minit_tv = itemView.findViewById(R.id.minit_tv);
            lname_tv = itemView.findViewById(R.id.lname_tv);
        }
    }
}
