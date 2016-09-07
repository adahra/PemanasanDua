package com.sebangsa.adnanto.pemanasandua.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sebangsa.adnanto.pemanasandua.R;
import com.sebangsa.adnanto.pemanasandua.model.Friend;

import java.util.ArrayList;

/**
 * Created by adnanto on 9/7/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private int rowLayout;
    private ArrayList<Friend> dataUser = new ArrayList<>();
    private Context context;

//    public RecyclerAdapter(ArrayList<Friend> dataUser, OnItemClickListener onItemClickListener) {
//        this.dataUser = dataUser;
//        this.onItemClickListener = onItemClickListener;
//    }

    public RecyclerAdapter(ArrayList<Friend> dataUser) {
        this.dataUser = dataUser;
    }

    public RecyclerAdapter(ArrayList<Friend> dataUser, int rowLayout, Context context) {
        this.dataUser = dataUser;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            holder.tvUserName.setText(dataUser.get(position).getUsername());
            holder.tvName.setText(dataUser.get(position).getName());
            holder.tvDeskripsi.setText(dataUser.get(position).getBio());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected TextView tvUserName;
        protected TextView tvName;
        protected TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.tvDeskripsi);
        }
    }
}
