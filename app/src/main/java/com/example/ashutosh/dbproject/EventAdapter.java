package com.example.ashutosh.dbproject;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.*;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.ViewHolder> {

    Context context;
    List<Event> data;

    public EventAdapter(Context context,List<Event> data)
    {
        this.context = context;
        this.data=data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_event, null);
        EventAdapter.ViewHolder viewHolder = new EventAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.team_size_tv.setText(String.valueOf(data.get(position).getTeam_Size()));
        holder.event_name_tv.setText(data.get(position).getEvent_Name());
        holder.date_tv.setText(data.get(position).getDate());
        holder.event_id_tv.setText(data.get(position).getEvent_ID());
        holder.venue_tv.setText(data.get(position).getVenue());
        holder.organizer_tv.setText(data.get(position).getOrganizer());
        holder.level_tv.setText(data.get(position).getLevel());
        holder.award_tv.setText(data.get(position).getAward_Type());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView team_size_tv,event_name_tv,date_tv,event_id_tv,venue_tv,organizer_tv,level_tv,award_tv;
        RelativeLayout parent;

        public ViewHolder(View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            team_size_tv = (TextView) itemView.findViewById(R.id.team_size_tv);
            event_name_tv = itemView.findViewById(R.id.event_name_tv);
            date_tv = itemView.findViewById(R.id.date_tv);
            event_id_tv = itemView.findViewById(R.id.event_id_tv);
            venue_tv = itemView.findViewById(R.id.venue_tv);
            organizer_tv = itemView.findViewById(R.id.organizer_tv);
            level_tv = itemView.findViewById(R.id.level_tv);
            award_tv = itemView.findViewById(R.id.award_tv);
        }
    }
}
