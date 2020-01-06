package com.wiser.choice;

import android.view.View;

/**
 * @author Wiser
 * @param <T>
 *     RecycleView 点击事件
 */
public interface OnChoiceRecycleClickListener<T> {

	void callBackAdapterClick(View itemView, int position, T t);
}