package com.ranjitzade.advrecyclerview;

import android.support.annotation.LayoutRes;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;

/**
 * ParamBuilder class to get params for {@link RecyclerView}, {@link MultiStateView} and {@link SwipeRefreshLayout}
 *
 * @author ranjit
 */
public class Params {

    // stuffs RecyclerView needs
    protected RecyclerView.LayoutManager layoutManager;
    protected RecyclerView.ItemAnimator itemAnimator;
    protected RecyclerView.ItemDecoration itemDecoration;
    protected RecyclerView.OnScrollListener scrollListener;
    protected RecyclerView.Adapter adapter;

    // stuffs MultiStateView needs
    @LayoutRes
    protected int errorView;
    @LayoutRes
    protected int emptyView;
    @LayoutRes
    protected int loadingView;

    // Listeners
    protected RecycleViewStateListener stateListener;

    public RecyclerView.LayoutManager getLayoutManager() {
        return layoutManager;
    }

    public RecyclerView.ItemAnimator getItemAnimator() {
        return itemAnimator;
    }

    public RecyclerView.ItemDecoration getItemDecoration() {
        return itemDecoration;
    }

    public RecyclerView.OnScrollListener getScrollListener() {
        return scrollListener;
    }

    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    public int getErrorView() {
        return errorView;
    }

    public int getEmptyView() {
        return emptyView;
    }

    public int getLoadingView() {
        return loadingView;
    }

}
