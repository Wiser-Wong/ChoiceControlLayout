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
              implementation 'com.github.Wiser-Wong:ChoiceControlLayout:1.0.0'
      }

## 使用说明
### 注意事项
   需要设置ccl_layoutId属性，否则会报异常
   * ChoicesControlLayout
   
    <com.wiser.choice.ChoicesControlLayout
        android:id="@+id/ccl_layout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:ccl_LayoutId="@layout/choice_item"
        app:ccl_spanCount="4" />

    choicesControlLayout.setItems(choicesDatas());
    
    choicesControlLayout.setOnChoiceAdapter(new OnChoiceAdapter<ChoicesModel>() {
			@Override
			public void onCreateItemView(final View itemView, final ChoicesModel choicesModel, final int position) {
				if (choicesModel == null) return;
				TextView tvChoiceName = itemView.findViewById(R.id.tv_choice_name);
				ImageView ivChoiceIcon = itemView.findViewById(R.id.iv_choice_icon);
				if (choicesModel.isCheck) {
					itemView.setBackgroundResource(R.drawable.choice_st);
					ivChoiceIcon.setVisibility(View.VISIBLE);
				} else {
					itemView.setBackgroundResource(0);
					ivChoiceIcon.setVisibility(View.GONE);
				}
				tvChoiceName.setText(choicesModel.name);

				itemView.setOnClickListener(new View.OnClickListener() {

					@Override public void onClick(View v) {
						choicesModel.isCheck = !choicesModel.isCheck;
						if (itemView.getParent().equals(choicesControlLayout)) choicesControlLayout.notifyItemPositionData(position,        choicesModel);
						if (itemView.getParent().equals(choicesControlLayout1)) choicesControlLayout1.notifyItemPositionData(position, choicesModel);
						if (itemView.getParent().equals(choicesControlLayout2)) choicesControlLayout2.notifyItemPositionData(position, choicesModel);
					}
				});
			}
		});
    
## 操作手册
### ChoicesControlLayout
* ccl_LayoutId:所选择的item布局id
* ccl_spanCount：所展示的列表列数
