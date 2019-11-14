package com.taikang.choiceslayout;

import java.util.ArrayList;
import java.util.List;

import com.wiser.choice.ChoicesControlLayout;
import com.wiser.choice.OnChoiceAdapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnChoiceAdapter<ChoicesModel> {

	ChoicesControlLayout<ChoicesModel>	choicesControlLayout;

	ChoicesControlLayout<ChoicesModel>	choicesControlLayout1;

	ChoicesControlLayout<ChoicesModel>	choicesControlLayout2;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		choicesControlLayout = findViewById(R.id.ccl_layout);
		choicesControlLayout1 = findViewById(R.id.ccl_layout1);
		choicesControlLayout2 = findViewById(R.id.ccl_layout2);

		choicesControlLayout.setItems(choicesModels());
		choicesControlLayout1.setItems(choicesModels());
		choicesControlLayout2.setItems(choicesModels());

		choicesControlLayout.setOnChoiceAdapter(this);
		choicesControlLayout1.setOnChoiceAdapter(this);
		choicesControlLayout2.setOnChoiceAdapter(this);
	}

	private List<ChoicesModel> choicesModels() {
		List<ChoicesModel> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ChoicesModel choicesModel = new ChoicesModel();
			choicesModel.name = "第" + i + "个";
			list.add(choicesModel);
		}
		return list;
	}

	@Override public void onCreateItemView(final View itemView, final ChoicesModel choicesModel, final int position) {
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
				if (itemView.getParent().equals(choicesControlLayout)) choicesControlLayout.notifyItemPositionData(position, choicesModel);
				if (itemView.getParent().equals(choicesControlLayout1)) choicesControlLayout1.notifyItemPositionData(position, choicesModel);
				if (itemView.getParent().equals(choicesControlLayout2)) choicesControlLayout2.notifyItemPositionData(position, choicesModel);
			}
		});
	}
}
