package com.sebangsa.adnanto.pemanasandua.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.sebangsa.adnanto.pemanasandua.R;
import com.sebangsa.adnanto.pemanasandua.model.Friend;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adnanto on 9/7/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
        implements View.OnClickListener {
    private static final String TAG = RecyclerAdapter.class.getSimpleName();
    private int rowLayout;
    private List<Friend> dataUser = new ArrayList<>();
    private Context context;

    public RecyclerAdapter(List<Friend> dataUser, Context context) {
        this.dataUser = dataUser;
        this.context = context;
    }

    public RecyclerAdapter(ArrayList<Friend> dataUser, int rowLayout, Context context) {
        this.dataUser = dataUser;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(context).load(dataUser.get(position).getAvatar().getSmall()).asBitmap()
                .centerCrop().into(new BitmapImageViewTarget(holder.ivGambar) {
            @Override
            protected void setResource(Bitmap resource) {
                RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory
                        .create(context.getResources(), resource);
                roundedBitmapDrawable.setCircular(true);
                holder.ivGambar.setImageDrawable(roundedBitmapDrawable);
            }
        });

        holder.tvUserName.setText(dataUser.get(position).getUsername().trim());
        holder.tvName.setText(dataUser.get(position).getName().trim());
        // holder.tvDeskripsi.setText(dataUser.get(position).getBio().trim());
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() ");
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView ivGambar;
        protected TextView tvUserName;
        protected TextView tvName;
        protected TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivGambar = (ImageView) itemView.findViewById(R.id.ivGambar);
            tvUserName = (TextView) itemView.findViewById(R.id.tvUserName);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.tvDeskripsi);
        }
    }
}
