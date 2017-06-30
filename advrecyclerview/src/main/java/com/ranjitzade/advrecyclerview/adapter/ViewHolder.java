package com.ranjitzade.advrecyclerview.adapter;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author ranjit
 */
public class ViewHolder extends RecyclerView.ViewHolder {
    public ViewHolder(View itemView) {
        super(itemView);
    }

    protected <T extends View> T findViewById(@IdRes int id) {
        return itemView.findViewById(id);
    }
}
