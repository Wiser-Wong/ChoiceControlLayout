package com.taikang.choiceslayout;

import java.util.ArrayList;
import java.util.List;

import com.wiser.choice.ChoicesControlLayout;
import com.wiser.choice.ChoicesIrregularLayout;
import com.wiser.choice.ChoicesRuleLayout;
import com.wiser.choice.OnChoiceAdapter;
import com.wiser.choice.OnChoiceListener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnChoiceAdapter<ChoicesModel>, OnChoiceListener<ChoicesModel> {

	ChoicesControlLayout<ChoicesModel>		choicesControlLayout;

	ChoicesRuleLayout<ChoicesModel>			choicesRuleLayout;

	ChoicesIrregularLayout<ChoicesModel>	choicesIrregularLayout;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		choicesControlLayout = findViewById(R.id.ccl_layout);
		choicesRuleLayout = findViewById(R.id.cl_layout);
		choicesIrregularLayout = findViewById(R.id.cil_layout);

		choicesControlLayout.setOnChoiceAdapter(this);
		choicesControlLayout.setOnChoiceListener(this);
		choicesRuleLayout.setOnChoiceListener(this);
		choicesIrregularLayout.setOnChoiceListener(this);
		choicesRuleLayout.setChoiceAdapter(this);
		choicesIrregularLayout.setChoiceAdapter(this);

		choicesControlLayout.setItems(choicesModels());
		choicesRuleLayout.setItems(choicesModels());
		choicesIrregularLayout.setItems(choicesModelsIrregular());


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

	private List<ChoicesModel> choicesModelsIrregular() {
		List<ChoicesModel> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ChoicesModel choicesModel = new ChoicesModel();
			if (i < 2) choicesModel.name = ("第顶顶顶顶顶" + i + "个");
			if (i >= 2 && i <= 5) choicesModel.name = ("第" + i + "个");
			if (i > 5) choicesModel.name = ("第" + i + "顶顶顶顶顶顶顶顶顶个");
			list.add(choicesModel);
		}
		return list;
	}

	@Override public void onCreateItemView(final View itemView, final int position, final ChoicesModel choicesModel) {
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
	}

	@Override public void onChoiceItemClick(ViewGroup viewGroup,View view, int position, ChoicesModel choicesModel) {
		choicesModel.isCheck = !choicesModel.isCheck;
		if (viewGroup.equals(choicesControlLayout)) choicesControlLayout.notifyItemPositionData(position, choicesModel);
		if (viewGroup.equals(choicesRuleLayout)) choicesRuleLayout.notifyItemPositionData(position, choicesModel);
		if (viewGroup.equals(choicesIrregularLayout)) choicesIrregularLayout.notifyItemPositionData(position, choicesModel);
	}

}
