package com.wiser.choice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Wiser
 * 
 *         选择适配器
 */
public class ChoiceRecycleViewAdapter<T> extends BaseAdapter<T, ChoiceRecycleViewAdapter.ChoicesHolder> {

	private int					choiceLayoutId;

	private OnChoiceAdapter<T>	onChoiceAdapter;

	private OnChoiceRecycleClickListener<T> onChoiceRecycleClickListener;

	ChoiceRecycleViewAdapter(Context context, int choiceLayoutId) {
		super(context);
		this.choiceLayoutId = choiceLayoutId;
	}

	void setOnChoiceAdapter(OnChoiceAdapter<T> onChoiceAdapter) {
		this.onChoiceAdapter = onChoiceAdapter;
	}

	void setOnChoiceRecycleClickListener(OnChoiceRecycleClickListener<T> onChoiceRecycleClickListener) {
		this.onChoiceRecycleClickListener = onChoiceRecycleClickListener;
	}

	@Override public ChoicesHolder newViewHolder(ViewGroup viewGroup, int type) {
		return new ChoicesHolder(inflate(choiceLayoutId, viewGroup));
	}

	class ChoicesHolder extends BaseHolder<T> {

		ChoicesHolder(@NonNull View itemView) {
			super(itemView);
		}

		@Override public void bindData(final T t, final int position) {
			if (onChoiceAdapter != null) onChoiceAdapter.onCreateItemView(itemView, position, t);
			itemView.setOnClickListener(new View.OnClickListener() {

				@Override public void onClick(View v) {
					if (onChoiceRecycleClickListener != null) onChoiceRecycleClickListener.callBackAdapterClick(itemView, position, t);
				}
			});
		}
	}

}
