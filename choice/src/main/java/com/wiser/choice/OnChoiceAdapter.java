package com.wiser.choice;

import android.view.View;

/**
 * @author Wiser
 * 
 *         选择监听
 */
public interface OnChoiceAdapter<T> {

	void onCreateItemView(View itemView, T t, int position);

}
