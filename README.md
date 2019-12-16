# ChoiceControlLayout
多选 选择控件 需要使用自己的自定义布局

# 截图
![images](https://github.com/Wiser-Wong/ChoiceControlLayout/blob/master/images/choice.gif)

## 环境配置
     allprojects {
        repositories {
          ...
          maven { url 'https://jitpack.io' }
        }
      }

        dependencies {
              implementation 'com.github.Wiser-Wong:ChoiceControlLayout:1.3.0'
      }

## 使用说明
   
   * ChoiceRuleLayout
   
    <com.wiser.choice.ChoiceRuleLayout
         android:id="@+id/cl_layout"
         android:layout_width="match_parent"
         android:layout_height="wrap_content"
         app:crl_layoutId="@layout/choice_item"
         app:crl_spanCount="3" />   	

    choiceRuleLayout.setChoiceAdapter(new OnChoiceAdapter<ChoicesModel>() {
			@Override
			public void onCreateItemView(final View itemView, final ChoiceModel choiceModel, final int position) {
				if (choiceModel == null) return;
				TextView tvChoiceName = itemView.findViewById(R.id.tv_choice_name);
				ImageView ivChoiceIcon = itemView.findViewById(R.id.iv_choice_icon);
				if (choicesModel.isCheck) {
					itemView.setBackgroundResource(R.drawable.choice_st);
					ivChoiceIcon.setVisibility(View.VISIBLE);
				} else {
					itemView.setBackgroundResource(0);
					ivChoiceIcon.setVisibility(View.GONE);
				}
				tvChoiceName.setText(choiceModel.name);
			}
		});
   
    choiceRuleLayout.setOnChoiceListener(new OnChoiceListener<ChoiceModel>() {
			@Override
			public void onChoiceItemClick(ViewGroup viewGroup, View view, int position, ChoiceModel choiceModel) {
				choiceModel.isCheck = !choiceModel.isCheck;
		if (viewGroup.equals(choiceRuleLayout)) choiceRuleLayout.notifyItemPositionData(position, choiceModel);
			}
		});
		
    choiceRuleLayout.setItems(choiceDatas());
    
   * ChoiceIrregularLayout
   
         <com.wiser.choice.ChoiceIrregularLayout
            android:id="@+id/cil_layout"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            app:cil_isFillSurplusWidth="false"
            app:cil_layoutId="@layout/choice_item" />
	    
	choiceIrregularLayout.setChoiceAdapter(new OnChoiceAdapter<ChoicesModel>() {
			@Override
			public void onCreateItemView(final View itemView, final ChoiceModel choiceModel, final int position) {
				if (choiceModel == null) return;
				TextView tvChoiceName = itemView.findViewById(R.id.tv_choice_name);
				ImageView ivChoiceIcon = itemView.findViewById(R.id.iv_choice_icon);
				if (choicesModel.isCheck) {
					itemView.setBackgroundResource(R.drawable.choice_st);
					ivChoiceIcon.setVisibility(View.VISIBLE);
				} else {
					itemView.setBackgroundResource(0);
					ivChoiceIcon.setVisibility(View.GONE);
				}
				tvChoiceName.setText(choiceModel.name);
			}
		});
   
    choiceIrregularLayout.setOnChoiceListener(new OnChoiceListener<ChoiceModel>() {
			@Override
			public void onChoiceItemClick(ViewGroup viewGroup, View view, int position, ChoiceModel choiceModel) {
				choiceModel.isCheck = !choiceModel.isCheck;
		if (viewGroup.equals(choiceIrregularLayout)) choiceIrregularLayout.notifyItemPositionData(position, choiceModel);
			}
		});
		
    choiceIrregularLayout.setItems(choiceDatas());
    
   * ChoiceControlLayout
   
    <com.wiser.choice.ChoicesControlLayout
        android:id="@+id/ccl_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:ccl_LayoutId="@layout/choice_item"
        app:ccl_spanCount="4" />

    choiceControlLayout.setItems(choiceDatas());
    
    choiceControlLayout.setChoiceAdapter(new OnChoiceAdapter<ChoicesModel>() {
			@Override
			public void onCreateItemView(final View itemView, final ChoiceModel choiceModel, final int position) {
				if (choiceModel == null) return;
				TextView tvChoiceName = itemView.findViewById(R.id.tv_choice_name);
				ImageView ivChoiceIcon = itemView.findViewById(R.id.iv_choice_icon);
				if (choicesModel.isCheck) {
					itemView.setBackgroundResource(R.drawable.choice_st);
					ivChoiceIcon.setVisibility(View.VISIBLE);
				} else {
					itemView.setBackgroundResource(0);
					ivChoiceIcon.setVisibility(View.GONE);
				}
				tvChoiceName.setText(choiceModel.name);
			}
		});
   
    choiceControlLayout.setOnChoiceListener(new OnChoiceListener<ChoiceModel>() {
			@Override
			public void onChoiceItemClick(ViewGroup viewGroup, View view, int position, ChoiceModel choiceModel) {
				choiceModel.isCheck = !choiceModel.isCheck;
		if (viewGroup.equals(choiceControlLayout)) choiceControlLayout.notifyItemPositionData(position, choiceModel);
			}
		});
		
## 操作手册

### ChoiceRuleLayout 规则排版平分布局
* crl_layoutId:item布局id
* crl_spanCount:所展示的列表列数

### ChoiceIrregularLayout 不规则排版布局
* cil_layoutId:item布局id
* cil_isFillSurplusWidth:是否填充剩余宽度，并且是平分方式填充

### ChoiceControlLayout RecycleView实现
* ccl_layoutId:item布局id
* ccl_spanCount：所展示的列表列数
