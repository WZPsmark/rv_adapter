package com.sk.rvadapter.holder;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.util.Linkify;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.widget.AbsListView;
import android.widget.Checkable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by smark on 2020/4/13.
 * 邮箱：smarkwzp@163.com
 * 自定义拓展ViewHolder
 */
public class SViewHolder extends RecyclerView.ViewHolder {
    private SparseArray<View> mViews = new SparseArray<>();
    private int mLayoutId;

    private SViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    public static SViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId) {
        if (convertView == null) {
            View holder2 = LayoutInflater.from(context).inflate(layoutId, parent, false);
            SViewHolder holder1 = new SViewHolder(holder2);
            holder1.mLayoutId = layoutId;
            return holder1;
        } else {
            SViewHolder holder = (SViewHolder) convertView.getTag();
            return holder;
        }
    }

    public int getLayoutId() {
        return mLayoutId;
    }

    public <T extends View> T getView(int viewId) {
        View view = this.mViews.get(viewId);
        if (view == null) {
            view = this.itemView.findViewById(viewId);
            this.mViews.put(viewId, view);
        }
        return (T) view;
    }

    public SViewHolder setText(int viewId, CharSequence text) {
        TextView tv = (TextView) this.getView(viewId);
        tv.setText(text);
        return this;
    }

    public SViewHolder setSelected(int viewId, boolean selected) {
        View v = this.getView(viewId);
        v.setSelected(selected);
        return this;
    }

    public SViewHolder setImageResource(int viewId, int resId) {
        ImageView view = (ImageView) this.getView(viewId);
        view.setImageResource(resId);
        return this;
    }

    public SViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView view = (ImageView) this.getView(viewId);
        view.setImageBitmap(bitmap);
        return this;
    }

    public SViewHolder setImageDrawable(int viewId, Drawable drawable) {
        ImageView view = (ImageView) this.getView(viewId);
        view.setImageDrawable(drawable);
        return this;
    }

    public SViewHolder setBackgroundColor(int viewId, int color) {
        View view = this.getView(viewId);
        view.setBackgroundColor(color);
        return this;
    }

    public SViewHolder setBackgroundRes(int viewId, int backgroundRes) {
        View view = this.getView(viewId);
        view.setBackgroundResource(backgroundRes);
        return this;
    }

    public SViewHolder setTextColor(int viewId, int textColor) {
        TextView view = (TextView) this.getView(viewId);
        view.setTextColor(textColor);
        return this;
    }

    public SViewHolder setTextColorRes(int viewId, int textColorRes) {
        TextView view = (TextView) this.getView(viewId);
        view.setTextColor(this.itemView.getContext().getResources().getColor(textColorRes));
        return this;
    }

    @SuppressLint({"NewApi"})
    public SViewHolder setAlpha(int viewId, float value) {
        if (Build.VERSION.SDK_INT >= 11) {
            this.getView(viewId).setAlpha(value);
        } else {
            AlphaAnimation alpha = new AlphaAnimation(value, value);
            alpha.setDuration(0L);
            alpha.setFillAfter(true);
            this.getView(viewId).startAnimation(alpha);
        }

        return this;
    }

    public SViewHolder setVisible(int viewId, boolean visible) {
        View view = this.getView(viewId);
        view.setVisibility(visible ? View.VISIBLE : View.GONE);
        return this;
    }

    public SViewHolder linkify(int viewId) {
        TextView view = (TextView) this.getView(viewId);
        Linkify.addLinks(view, Linkify.ALL);
        return this;
    }

    public SViewHolder setTypeface(Typeface typeface, int... viewIds) {
        int[] var3 = viewIds;
        int var4 = viewIds.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            int viewId = var3[var5];
            TextView view = (TextView) this.getView(viewId);
            view.setTypeface(typeface);
            view.setPaintFlags(view.getPaintFlags() | 128);
        }

        return this;
    }

    public SViewHolder setProgress(int viewId, int progress) {
        ProgressBar view = (ProgressBar) this.getView(viewId);
        view.setProgress(progress);
        return this;
    }

    public SViewHolder setProgress(int viewId, int progress, int max) {
        ProgressBar view = (ProgressBar) this.getView(viewId);
        view.setMax(max);
        view.setProgress(progress);
        return this;
    }

    public SViewHolder setMax(int viewId, int max) {
        ProgressBar view = (ProgressBar) this.getView(viewId);
        view.setMax(max);
        return this;
    }

    public SViewHolder setRating(int viewId, float rating) {
        RatingBar view = (RatingBar) this.getView(viewId);
        view.setRating(rating);
        return this;
    }

    public SViewHolder setRating(int viewId, float rating, int max) {
        RatingBar view = (RatingBar) this.getView(viewId);
        view.setMax(max);
        view.setRating(rating);
        return this;
    }

    public SViewHolder setTag(int viewId, Object tag) {
        View view = this.getView(viewId);
        view.setTag(tag);
        return this;
    }

    public SViewHolder setTag(int viewId, int key, Object tag) {
        View view = this.getView(viewId);
        view.setTag(key, tag);
        return this;
    }

    public SViewHolder setChecked(int viewId, boolean checked) {
        Checkable view = (Checkable) this.getView(viewId);
        view.setChecked(checked);
        return this;
    }

    public SViewHolder setOnClickListener(int viewId, View.OnClickListener listener) {
        View view = this.getView(viewId);
        view.setOnClickListener(listener);
        return this;
    }

    public SViewHolder setOnTouchListener(int viewId, View.OnTouchListener listener) {
        View view = this.getView(viewId);
        view.setOnTouchListener(listener);
        return this;
    }

    public SViewHolder setOnLongClickListener(int viewId, View.OnLongClickListener listener) {
        View view = this.getView(viewId);
        view.setOnLongClickListener(listener);
        return this;
    }

    public void setItemVisible(boolean visible) {
        if (null != this.itemView) {
            if (visible) {
                if (null != this.itemView.getLayoutParams()) {
                    this.itemView.getLayoutParams().width = -1;
                    this.itemView.getLayoutParams().height = -2;
                } else {
                    this.itemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                }

                this.itemView.setVisibility(View.VISIBLE);
            } else {
                if (null != this.itemView.getLayoutParams()) {
                    this.itemView.getLayoutParams().width = -1;
                    this.itemView.getLayoutParams().height = 1;
                } else {
                    this.itemView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                }

                this.itemView.setVisibility(View.GONE);
            }
        }

    }

    public void setHItemVisible(boolean visible) {
        if (null != this.itemView) {
            if (visible) {
                if (null != this.itemView.getLayoutParams()) {
                    this.itemView.getLayoutParams().width = -2;
                    this.itemView.getLayoutParams().height = -2;
                } else {
                    this.itemView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
                }

                this.itemView.setVisibility(View.VISIBLE);
            } else {
                if (null != this.itemView.getLayoutParams()) {
                    this.itemView.getLayoutParams().width = -1;
                    this.itemView.getLayoutParams().height = 1;
                } else {
                    this.itemView.setLayoutParams(new AbsListView.LayoutParams(-1, 1));
                }

                this.itemView.setVisibility(View.GONE);
            }
        }

    }
}
