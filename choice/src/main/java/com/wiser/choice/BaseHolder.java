package com.wiser.choice;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * @author Wiser
 * Holder base
 */
public abstract class BaseHolder<T> extends RecyclerView.ViewHolder {

    private BaseAdapter adapter;

    public BaseHolder(@NonNull View itemView) {
        super(itemView);
    }

    public void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
    }

    public BaseAdapter adapter() {
        return adapter;
    }

    public abstract void bindData(T t, int position);

}
