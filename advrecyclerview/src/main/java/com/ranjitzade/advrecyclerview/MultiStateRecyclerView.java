package com.ranjitzade.advrecyclerview;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

/**
 * @author ranjit
 */
public class MultiStateRecyclerView extends FrameLayout implements SwipeRefreshLayout.OnRefreshListener {
    // changes the view state of the layout to loading, content, empty or error
    private MultiStateView mMultiStateView;
    private RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private Params mParams;
    private boolean mSwipeRefreshEnabled;

    private AppCompatImageView mErrorImageView;
    private AppCompatTextView mErrorTextView;
    private AppCompatButton mErrorRetryButton;

    public MultiStateRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public MultiStateRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public MultiStateRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    /**
     * initialise views and set desired attributes
     */
    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.msv_recyclerview, this, true);
        mSwipeRefreshLayout = findViewById(R.id.swipe_refresh_layout);
        mRecyclerView = findViewById(R.id.recyclerView);
        mMultiStateView = findViewById(R.id.multi_state_view);
        mMultiStateView.setInitialSetting(attrs, R.styleable.MultiStateRecyclerView);

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.MultiStateRecyclerView);
        mSwipeRefreshEnabled = a.getBoolean(R.styleable.MultiStateRecyclerView_msr_swiperefreshenabled, true);
        a.recycle();

        mSwipeRefreshLayout.setOnRefreshListener(this);
        initMultiStateView();
    }

    /* ================= RecyclerView Methods ==============================*/

    /**
     * @return recyclerView imported with the layout
     */
    public RecyclerView getRecyclerView() {
        return mRecyclerView;
    }

    public void setParams(Params params) {
        if (params == null) {
            throw new NullPointerException("Please specify valid params");
        }
        this.mParams = params;
        mRecyclerView.setLayoutManager(mParams.layoutManager);

        if (checkNotNull(mParams.itemAnimator)) {
            mRecyclerView.setItemAnimator(mParams.itemAnimator);
        }

        if (checkNotNull(mParams.itemDecoration)) {
            mRecyclerView.addItemDecoration(mParams.itemDecoration);
        }
        if (checkNotNull(mParams.scrollListener)) {
            mRecyclerView.addOnScrollListener(mParams.scrollListener);
        }

        mRecyclerView.setAdapter(mParams.adapter);

        if (checkNotNull(mParams.errorView)) {
            mMultiStateView.setViewForState(mParams.errorView, MultiStateView.VIEW_STATE_ERROR);
        }

        if (checkNotNull(mParams.emptyView)) {
            mMultiStateView.setViewForState(mParams.emptyView, MultiStateView.VIEW_STATE_EMPTY);
        }
        if (checkNotNull(mParams.loadingView)) {
            mMultiStateView.setViewForState(mParams.loadingView, MultiStateView.VIEW_STATE_LOADING);
        }

        mSwipeRefreshLayout.setEnabled(mSwipeRefreshEnabled);
    }

    public Params getParams() {
        return mParams;
    }

    private static boolean checkNotNull(Object object) {
        return object != null;
    }

    private static boolean checkNotNull(int i) {
        return !(i < 0 || i == 0);
    }

    /*====================================================
     ================= SwipeToRefreshLayout ==============
     ====================================================*/
    @Override
    public void onRefresh() {
        if (checkNotNull(mParams.stateListener)) {
            mParams.stateListener.onRefresh();
        } else {
            throw new NullPointerException("Please initialise StateListener in ParamBuilder");
        }
    }

    public void setRefreshing(boolean isRefreshing) {
        mSwipeRefreshLayout.setRefreshing(isRefreshing);
    }

    public void setSwipeRefreshColorScheme(@ColorRes int... colorScheme) {
        mSwipeRefreshLayout.setColorSchemeResources(colorScheme);
    }

    public SwipeRefreshLayout getSwipeRefreshLayout() {
        return mSwipeRefreshLayout;
    }

    public void setSwipeRefreshEnabled(boolean refreshEnabled) {
        mSwipeRefreshEnabled = refreshEnabled;
        mSwipeRefreshLayout.setEnabled(mSwipeRefreshEnabled);
    }

    public void setLoadingView() {
        if (mMultiStateView.getViewState() != MultiStateView.VIEW_STATE_LOADING) {
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_LOADING);
        }
    }

    public void setContentView() {
        if (mMultiStateView.getViewState() != MultiStateView.VIEW_STATE_CONTENT) {
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_CONTENT);
        }
    }

    public void setEmptyView() {
        if (mMultiStateView.getViewState() != MultiStateView.VIEW_STATE_EMPTY) {
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_EMPTY);
        }
    }

    public void setErrorView() {
        if (mMultiStateView.getViewState() != MultiStateView.VIEW_STATE_ERROR) {
            mMultiStateView.setViewState(MultiStateView.VIEW_STATE_ERROR);
        }
    }

    /**
     * initialize {@link MultiStateView} layouts
     * for empty and error view, use layout {R.layout.layout_no_internet_connection}
     * for progress use {R.layout.layout_progress}
     */
    private void initMultiStateView() {
        // init error and empty view
        View mErrorView = mMultiStateView.getView(MultiStateView.VIEW_STATE_ERROR);

        // init views from loading, error and empty view
        if (mErrorView != null) {
            mErrorImageView = (AppCompatImageView) mErrorView.findViewById(R.id.imageViewError);
            mErrorTextView = (AppCompatTextView) mErrorView.findViewById(R.id.textViewError);
            mErrorRetryButton = (AppCompatButton) mErrorView.findViewById(R.id.buttonRetryError);
            mErrorRetryButton.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mParams.stateListener == null) {
                        throw new RuntimeException("Initialise RecycleViewStateListener first");
                    }
                    mParams.stateListener.onRetry();
                }
            });
        }
    }

    /**
     * This will set the error view according to the user demanded image and message below it
     *
     * @param drawable set to error imageView
     * @param message  set to error textView
     */
    public void setErrorView(@DrawableRes int drawable, String message) {
        setErrorView(drawable, message, getResources().getString(R.string.tap_to_retry), false);
    }

    public void setErrorView(@DrawableRes int drawable, String message, boolean hideRetry) {
        setErrorView(drawable, message, getResources().getString(R.string.tap_to_retry), hideRetry);
    }

    /**
     * This will set the error view according to the user demanded image and message below it
     *
     * @param drawable        set to error imageView
     * @param message         set to error textView
     * @param errorButtonText set to error button
     * @param hideRetry       hides retry button from default error layout
     */
    public void setErrorView(@DrawableRes int drawable, String message, String errorButtonText, boolean hideRetry) {
        setErrorView();
        if (checkNotNull(mErrorImageView)) {
            mErrorImageView.setImageDrawable(ContextCompat.getDrawable(getContext(), drawable));
        }
        if (checkNotNull(mErrorTextView)) {
            mErrorTextView.setText(message);
        }
        if (checkNotNull(mErrorRetryButton)) {
            mErrorRetryButton.setText(errorButtonText);
            if (hideRetry) {
                mErrorRetryButton.setVisibility(INVISIBLE);
            } else {
                mErrorRetryButton.setVisibility(VISIBLE);
            }
        }
    }

    /**
     * This will set the empty view according to the user demanded image and message below it
     *
     * @param drawable        set to error imageView
     * @param message         set to error textView
     * @param errorButtonText set to error button
     */
    public void setEmptyView(@DrawableRes int drawable, String message, String errorButtonText) {
        setErrorView(drawable, message, errorButtonText, true);
    }

    /**
     * This will set no internet to errorView
     */
    public void setNoInternet() {
        setNoInternet(getResources().getString(R.string.no_internet_connection));
    }

    public void setNoInternet(String message) {
        setErrorView(R.drawable.ic_error_network, message);
    }

}