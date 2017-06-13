package com.ranjitzade.advrecyclerview;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;

/**
 * @author ranjit
 */
public class ParamBuilder {
    private Params param;

    public ParamBuilder() {
        param = new Params();
    }

    public ParamBuilder setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        param.layoutManager = layoutManager;
        return this;
    }

    public ParamBuilder setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        param.itemAnimator = itemAnimator;
        return this;
    }

    public ParamBuilder setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        param.itemDecoration = itemDecoration;
        return this;
    }

    public ParamBuilder setScrollListener(RecyclerView.OnScrollListener scrollListener) {
        param.scrollListener = scrollListener;
        return this;
    }

    public ParamBuilder setAdapter(RecyclerView.Adapter adapter) {
        param.adapter = adapter;
        return this;
    }

    public ParamBuilder setErrorView(@LayoutRes int errorView) {
        param.errorView = errorView;
        return this;
    }

    public ParamBuilder setEmptyView(@LayoutRes int emptyView) {
        param.emptyView = emptyView;
        return this;
    }

    public ParamBuilder setLoadingView(@LayoutRes int loadingView) {
        param.loadingView = loadingView;
        return this;
    }

    public ParamBuilder setStateListener(RecycleViewStateListener stateListener) {
        param.stateListener = stateListener;
        return this;
    }

    public Params build() {
        if (param.layoutManager == null) {
            throw new NullPointerException("Please specify the layout manager.");
        }
        if (param.adapter == null) {
            throw new NullPointerException("Please provide an adapter for recyclerView");
        }
        return param;
    }
}
