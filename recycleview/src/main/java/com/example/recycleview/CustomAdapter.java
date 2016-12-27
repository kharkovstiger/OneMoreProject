package com.example.recycleview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

    private ArrayList<Moovie> moovies;

    public CustomAdapter(ArrayList<Moovie> moovies) {
        this.moovies = moovies;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView= LayoutInflater.from(parent.getContext()).inflate(R.layout.box,parent,false);
        return new CustomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        Moovie moovie=moovies.get(position);
        holder.tvName.setText(moovie.getName());
        holder.tvDate.setText(moovie.getDate());
    }

    @Override
    public int getItemCount() {
        return moovies.size();
    }

    public void remove(){
        if (moovies!=null && moovies.size()>0) {
            moovies.remove(0);
            notifyItemRemoved(0);
        }
    }

    public void add(Moovie moovie){
        if (moovies != null) {
            moovies.add(0,moovie);
            notifyItemInserted(0);
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvDate;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvName= (TextView) itemView.findViewById(R.id.tvName);
            tvDate= (TextView) itemView.findViewById(R.id.tvDate);
        }
    }
}
