package com.sebangsa.adnanto.pemanasandua.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by adnanto on 9/16/16.
 */
public class RelativeLayoutButton extends RelativeLayout {

    public RelativeLayoutButton(Context context, int id) {
        super(context);

        if (!(context instanceof Activity)) {
            return;
        }

        View view = ((Activity) context).findViewById(id);
        if (!(view instanceof RelativeLayout)) {
            return;
        }

        RelativeLayout relativeLayout = (RelativeLayout) view;
        ViewGroup.LayoutParams params = relativeLayout.getLayoutParams();
        this.setLayoutParams(params);
        Button button = new Button(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            this.setBackground(button.getBackground());
        } else {
            this.setBackgroundDrawable(button.getBackground());
        }

        while (relativeLayout.getChildCount() > 0) {
            View viewChild = relativeLayout.getChildAt(0);
            relativeLayout.removeViewAt(0);
            this.addView(viewChild);
            if (viewChild instanceof TextView) {
                ((TextView) viewChild).setTextColor(button.getTextColors());
            }

            viewChild.setClickable(false);
            viewChild.setFocusable(false);
            viewChild.setFocusableInTouchMode(false);
        }

        relativeLayout.removeAllViews();
        this.setClickable(true);
        this.setFocusable(true);
        this.setFocusableInTouchMode(false);
        ViewGroup viewGroup = (ViewGroup) relativeLayout.getParent();
        int index = viewGroup.indexOfChild(relativeLayout);
        viewGroup.removeView(relativeLayout);
        viewGroup.addView(this, index);
        this.setId(id);
    }

    public void setText(int id, CharSequence charSequence) {
        View view = findViewById(id);
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setText(charSequence);
            }
        }
    }

    public CharSequence getText(int id) {
        String string = "";
        View view = findViewById(id);
        if (view != null) {
            if (view instanceof TextView) {
                return ((TextView) view).getText();
            }
        }

        return string;
    }

    public void setImageDrawable(int id, Drawable drawable) {
        View view = findViewById(id);
        if (view != null) {
            if (view instanceof TextView) {
                ((ImageView) view).setImageDrawable(drawable);
            }
        }
    }

    public void setImageResource(int id, int imageResourceId) {
        View view = findViewById(id);
        if (view != null) {
            if (view instanceof ImageView) {
                ((ImageView) view).setImageResource(imageResourceId);
            }
        }
    }

    public void setTextColor(int id, int color) {
        View view = findViewById(id);
        if (view != null) {
            if (view instanceof TextView) {
                ((TextView) view).setTextColor(color);
            }
        }
    }
}
