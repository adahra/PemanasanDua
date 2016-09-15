package com.sebangsa.adnanto.pemanasandua.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.sebangsa.adnanto.pemanasandua.R;
import com.sebangsa.adnanto.pemanasandua.activity.ProfilActivity;
import com.sebangsa.adnanto.pemanasandua.model.Friend;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adnanto on 9/7/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
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
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_view_main, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        final Friend friend = dataUser.get(position);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().postSticky(friend);
                Intent intent = new Intent(context, ProfilActivity.class);
                context.startActivity(intent);
            }
        });

        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        holder.tvUserName.setText(dataUser.get(position).getUsername().trim());
        holder.tvName.setText(dataUser.get(position).getName().trim());
        // holder.tvDeskripsi.setText(dataUser.get(position).getBio().trim());

        if (dataUser.get(position).getAction().isFollow()) {
            holder.imgBtnGambar.setImageResource(R.drawable.i_followed);
            holder.imgBtnGambar.setBackgroundResource(R.color.colorGreenSebangsa);
        } else {
            holder.imgBtnGambar.setImageResource(R.drawable.i_follow);
            holder.imgBtnGambar.setBackgroundResource(R.color.colorWhite);
        }
    }

    @Override
    public int getItemCount() {
        return dataUser.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView ivGambar;
        protected TextView tvUserName;
        protected TextView tvName;
        protected TextView tvDeskripsi;
        protected ImageButton imgBtnGambar;
        protected CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.card_view_list);
            ivGambar = (ImageView) itemView.findViewById(R.id.iv_gambar);
            tvUserName = (TextView) itemView.findViewById(R.id.tv_user_name);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.tv_deskripsi);
            imgBtnGambar = (ImageButton) itemView.findViewById(R.id.img_btn_gambar);
        }
    }
}
