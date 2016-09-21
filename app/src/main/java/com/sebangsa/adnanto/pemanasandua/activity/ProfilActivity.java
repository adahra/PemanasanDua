package com.sebangsa.adnanto.pemanasandua.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;

import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
<<<<<<< HEAD
=======
import android.util.Log;
>>>>>>> master
import android.view.View;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.sebangsa.adnanto.pemanasandua.R;
import com.sebangsa.adnanto.pemanasandua.model.Friend;
import com.sebangsa.adnanto.pemanasandua.view.CircularImageView;
import com.sebangsa.adnanto.pemanasandua.view.RelativeLayoutButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

<<<<<<< HEAD
=======
import rx.Observer;

>>>>>>> master
public class ProfilActivity extends AppCompatActivity implements View.OnClickListener {
    private CircularImageView circularImageView;
    private TextView tvProfilName;
    private TextView tvProfilUserName;
    private TextView tvProfilBio;
    private RelativeLayoutButton imgbtnProfilSebut;
    private RelativeLayoutButton imgbtnProfilFollowing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);
        this.setTitle("");

        circularImageView = (CircularImageView) findViewById(R.id.iv_profil_placeholder);
        tvProfilName = (TextView) findViewById(R.id.tv_profil_name);
        tvProfilUserName = (TextView) findViewById(R.id.tv_profil_username);
        tvProfilBio = (TextView) findViewById(R.id.tv_profil_bio);
        imgbtnProfilSebut = new RelativeLayoutButton(this, R.id.img_btn_profil_sebut);
        if (imgbtnProfilSebut != null) {
            imgbtnProfilSebut.setOnClickListener(this);
        }

        imgbtnProfilFollowing = new RelativeLayoutButton(this, R.id.img_btn_profil_following);
        if (imgbtnProfilFollowing != null) {
            imgbtnProfilFollowing.setOnClickListener(this);
        }

        EventBus.getDefault().register(this);
<<<<<<< HEAD
=======
        Observer<String> stringObserver = new Observer<String>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.d("MY OBSERVER", s);
            }
        };
>>>>>>> master
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(sticky = true)
    public void onRealmEvent(Friend friend) {
        if (friend != null) {
            tvProfilName.setText(friend.getName());
            tvProfilUserName.setText("@" + friend.getUsername());
            tvProfilBio.setText(friend.getBio());
            Glide.with(ProfilActivity.this).load(friend.getAvatar().getSmall()).asBitmap()
                    .centerCrop().into(new BitmapImageViewTarget(circularImageView) {
                @Override
                protected void setResource(Bitmap resource) {
                    RoundedBitmapDrawable roundedBitmapDrawable = RoundedBitmapDrawableFactory
                            .create(getResources(), resource);
                    roundedBitmapDrawable.setCircular(true);
                    circularImageView.setImageDrawable(roundedBitmapDrawable);
                }
            });

            if (friend.getAction().isFollow()) {
                imgbtnProfilFollowing.setImageResource(R.id.test_button_image,
                        R.drawable.i_followed);
                imgbtnProfilFollowing.setTextColor(R.id.test_button_text, Color.WHITE);
                imgbtnProfilFollowing.setText(R.id.test_button_text, "Following");
            } else {
                imgbtnProfilFollowing.setImageResource(R.id.test_button_image,
                        R.drawable.i_follow);
                imgbtnProfilFollowing.setTextColor(R.id.test_button_text, Color.BLACK);
                imgbtnProfilFollowing.setText(R.id.test_button_text, "Follow");
            }

            imgbtnProfilSebut.setImageResource(R.id.test_button_image, R.drawable.i_join);
            imgbtnProfilSebut.setTextColor(R.id.test_button_text, Color.BLACK);
            imgbtnProfilSebut.setText(R.id.test_button_text, "Mention");

            EventBus.getDefault().removeStickyEvent(Friend.class);
        }
    }
}
