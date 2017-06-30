package com.ranjitzade.advrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ranjitzade.advrecyclerview.adapter.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ranjit
 */
public abstract class RecyclerAdapter<I extends Item> extends RecyclerView.Adapter<ViewHolder> {

    private List<I> mList;
    private Context mContext;


    public RecyclerAdapter(Context context, List<I> list) {
        this.mList = list;
        this.mContext = context;
    }

    public RecyclerAdapter(Context context) {
        this.mContext = context;
        this.mList = new ArrayList<>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int position) {
        View view = LayoutInflater.from(mContext).inflate(mList.get(position).getItemLayoutId(), parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);

    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        /*I i = mList.get(position);
        if (i instanceof HeaderItem) {
            return ItemType.HEADER;
        } else if (i instanceof FooterItem) {
            return ItemType.FOOTER;
        } else if (i instanceof StickyHeader) {
            return ItemType.STICKY;
        }
        return ItemType.ITEM;*/
        return position;
    }
}
