package com.ranjitzade.advrecyclerview.adapter;

import android.support.annotation.IntDef;

/**
 * @author ranjit
 */
@IntDef({ItemType.FOOTER, ItemType.HEADER, ItemType.STICKY, ItemType.ITEM})
public @interface ItemType {
    int HEADER = 25501;
    int FOOTER = 25502;
    int STICKY = 25503;
    int ITEM = 25500;

}
