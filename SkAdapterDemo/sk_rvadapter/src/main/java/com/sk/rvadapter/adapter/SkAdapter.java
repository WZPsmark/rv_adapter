package com.sk.rvadapter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sk.rvadapter.callback.OnItemClickListener;
import com.sk.rvadapter.holder.SViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by smark on 2020/4/13.
 * 邮箱：smarkwzp@163.com
 * 拓展通用recycleView适配器
 */
public abstract class SkAdapter<T> extends RecyclerView.Adapter<SViewHolder> {
    protected Context mContext;
    protected int mLayoutId;
    protected List<T> mDatas;
    protected LayoutInflater mInflater;
    protected ViewGroup mRv;
    private OnItemClickListener mOnItemClickListener;

    public SkAdapter setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
        return this;
    }

    public OnItemClickListener getItemClickListener() {
        return this.mOnItemClickListener;
    }

    public SkAdapter(Context context, List<T> data, int layoutId) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mLayoutId = layoutId;
        this.mDatas = data;
    }

    @NonNull
    @Override
    public SViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        SViewHolder sViewHolder = SViewHolder.get(this.mContext, null, parent, this.mLayoutId);
        if (null == this.mRv) {
            this.mRv = parent;
        }
        return sViewHolder;
    }

    protected int getPosition(SViewHolder viewHolder) {
        return viewHolder.getAdapterPosition();
    }

    protected boolean isEnabled(int viewType) {
        return true;
    }

    /**
     * @deprecated
     */
    @Deprecated
    protected void setListener(final ViewGroup parent, final SViewHolder viewHolder, int viewType) {
        if (this.isEnabled(viewType)) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (SkAdapter.this.mOnItemClickListener != null) {
                        int position = SkAdapter.this.getPosition(viewHolder);
                        SkAdapter.this.mOnItemClickListener.onItemClick(parent, v, SkAdapter.this.mDatas.get(position), position);
                    }

                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v) {
                    if (SkAdapter.this.mOnItemClickListener != null) {
                        int position = SkAdapter.this.getPosition(viewHolder);
                        return SkAdapter.this.mOnItemClickListener.onItemLongClick(parent, v, SkAdapter.this.mDatas.get(position), position);
                    } else {
                        return false;
                    }
                }
            });
        }
    }

    public void onBindViewHolder(SViewHolder holder, int position) {
        this.setListener(position, holder);
        this.convert(holder, this.mDatas.get(position));
    }

    protected void setListener(final int position, final SViewHolder viewHolder) {
        if (this.isEnabled(this.getItemViewType(position))) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (SkAdapter.this.mOnItemClickListener != null) {
                        SkAdapter.this.mOnItemClickListener.onItemClick(SkAdapter.this.mRv, v, SkAdapter.this.mDatas.get(position), position);
                    }

                }
            });
            viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View v) {
                    if (SkAdapter.this.mOnItemClickListener != null) {
                        int position = SkAdapter.this.getPosition(viewHolder);
                        return SkAdapter.this.mOnItemClickListener.onItemLongClick(SkAdapter.this.mRv, v, SkAdapter.this.mDatas.get(position), position);
                    } else {
                        return false;
                    }
                }
            });
        }
    }

    // 用于用户实现设置数据
    public abstract void convert(SViewHolder holder, T data);

    public int getItemCount() {
        return this.mDatas != null ? this.mDatas.size() : 0;
    }

    public void setData(List<T> list) {
        if (this.mDatas != null) {
            if (null != list) {
                ArrayList temp = new ArrayList();
                temp.addAll(list);
                this.mDatas.clear();
                this.mDatas.addAll(temp);
            } else {
                this.mDatas.clear();
            }
        } else {
            this.mDatas = list;
        }

        this.notifyDataSetChanged();
    }

    public void remove(int i) {
        if (null != this.mDatas && this.mDatas.size() > i && i > -1) {
            this.mDatas.remove(i);
            this.notifyDataSetChanged();
        }

    }

    public void addData(List<T> list) {
        if (null != list) {
            ArrayList temp = new ArrayList();
            temp.addAll(list);
            if (this.mDatas != null) {
                this.mDatas.addAll(temp);
            } else {
                this.mDatas = temp;
            }

            this.notifyDataSetChanged();
        }

    }

    public List<T> getData() {
        return this.mDatas;
    }

    public T getItem(int position) {
        return position > -1 && null != this.mDatas && this.mDatas.size() > position ? this.mDatas.get(position) : null;
    }
}
