package com.ranjitzade.advrecyclerview.adapter.model;

/**
 * @author ranjit
 */
public abstract class Item implements LayoutItem {
    protected long _id;
    protected boolean isExpandable;
    protected boolean isSticky;
    protected boolean isHeader;
    protected boolean isFooter;

    public boolean isExpandable() {
        return isExpandable;
    }

    public void setExpandable(boolean expandable) {
        isExpandable = expandable;
    }

    public boolean isSticky() {
        return isSticky;
    }

    public void setSticky(boolean sticky) {
        isSticky = sticky;
    }

    public boolean isHeader() {
        return isHeader;
    }

    public void setHeader(boolean header) {
        isHeader = header;
    }

    public boolean isFooter() {
        return isFooter;
    }

    public void setFooter(boolean footer) {
        isFooter = footer;
    }

    public long getId() {
        return _id;
    }
}