package com.wiser.choice;

import android.view.View;

public interface OnChoiceCallBack<T> {

	void callBackAdapterClick(View itemView, int position, T t);
}