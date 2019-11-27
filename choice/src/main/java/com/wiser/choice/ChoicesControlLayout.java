package com.wiser.choice;

import java.util.List;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.View;

/**
 * @author Wiser
 *
 *         选择控件
 */
public class ChoicesControlLayout<T> extends RecyclerView implements OnChoiceCallBack<T> {

	private int								choiceLayoutId;

	private int								spanCount	= 3;

	private ChoicesRecycleViewAdapter<T>	choicesRecycleViewAdapter;

	private OnChoiceAdapter<T>				onChoiceAdapter;

	private OnChoiceListener<T>				onChoiceListener;

	public ChoicesControlLayout(@NonNull Context context) {
		super(context);
		init(context, null);
	}

	public ChoicesControlLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
		super(context, attrs);
		init(context, attrs);
	}

	// 初始化
	private void init(Context context, AttributeSet attrs) {

		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.ChoicesControlLayout);
		if (ta != null) {
			choiceLayoutId = ta.getResourceId(R.styleable.ChoicesControlLayout_ccl_layoutId, -1);
			spanCount = ta.getInt(R.styleable.ChoicesControlLayout_ccl_spanCount, spanCount);
			ta.recycle();
		}

		initData();
	}

	private void initData() {
		// 去掉自带滑动
		setOverScrollMode(OVER_SCROLL_NEVER);
		setLayoutManager(new GridLayoutManager(getContext(), spanCount));
		setAdapter(choicesRecycleViewAdapter = new ChoicesRecycleViewAdapter<>(getContext(), choicesLayoutId()));
		choicesRecycleViewAdapter.setOnChoiceCallBack(this);
	}

	private int choicesLayoutId() {
		if (choiceLayoutId == -1) throw new InflateException("未设置布局ccl_layoutId,该属性是需要展示的item布局xml文件");
		return choiceLayoutId;
	}

	public void setItems(List<T> list) {
		if (choicesRecycleViewAdapter != null) choicesRecycleViewAdapter.setItems(list);
	}

	// 更新数据
	public void notifyItemPositionData(int position, T t) {
		choicesRecycleViewAdapter.getItems().set(position, t);
		choicesRecycleViewAdapter.notifyItemChanged(position);
	}

	public void setOnChoiceAdapter(OnChoiceAdapter<T> onChoiceAdapter) {
		if (this.onChoiceAdapter == null) {
			this.onChoiceAdapter = onChoiceAdapter;
			if (choicesRecycleViewAdapter != null) choicesRecycleViewAdapter.setOnChoiceAdapter(onChoiceAdapter);
		}
	}

	public void setOnChoiceListener(OnChoiceListener<T> onChoiceListener) {
		this.onChoiceListener = onChoiceListener;
	}

	@Override public void callBackAdapterClick(View itemView, int position, T t) {
		if (onChoiceListener != null) onChoiceListener.onChoiceItemClick(this, itemView, position, t);
	}

}
