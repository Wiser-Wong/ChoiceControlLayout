package com.wiser.choice;

import android.view.View;
import android.view.ViewGroup;

public interface OnChoiceListener<T> {

	void onChoiceItemClick(ViewGroup viewGroup,View view, int position, T t);
}