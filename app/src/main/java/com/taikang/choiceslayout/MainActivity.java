package com.taikang.choiceslayout;

import java.util.ArrayList;
import java.util.List;

import com.wiser.choice.ChoiceControlLayout;
import com.wiser.choice.ChoiceIrregularLayout;
import com.wiser.choice.ChoiceRuleLayout;
import com.wiser.choice.OnChoiceAdapter;
import com.wiser.choice.OnChoiceListener;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements OnChoiceAdapter<ChoiceModel>, OnChoiceListener<ChoiceModel> {

	ChoiceControlLayout<ChoiceModel> choiceControlLayout;

	ChoiceRuleLayout<ChoiceModel> choiceRuleLayout;

	ChoiceIrregularLayout<ChoiceModel> choiceIrregularLayout;

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		choiceControlLayout = findViewById(R.id.ccl_layout);
		choiceRuleLayout = findViewById(R.id.cl_layout);
		choiceIrregularLayout = findViewById(R.id.cil_layout);

		choiceControlLayout.setChoiceAdapter(this);
		choiceControlLayout.setOnChoiceListener(this);
		choiceRuleLayout.setOnChoiceListener(this);
		choiceIrregularLayout.setOnChoiceListener(this);
		choiceRuleLayout.setChoiceAdapter(this);
		choiceIrregularLayout.setChoiceAdapter(this);

		choiceControlLayout.setItems(choiceModels());
		choiceRuleLayout.setItems(choiceModels());
		choiceIrregularLayout.setItems(choiceModelsIrregular());


	}

	private List<ChoiceModel> choiceModels() {
		List<ChoiceModel> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ChoiceModel choiceModel = new ChoiceModel();
			choiceModel.name = "第" + i + "个";
			list.add(choiceModel);
		}
		return list;
	}

	private List<ChoiceModel> choiceModelsIrregular() {
		List<ChoiceModel> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			ChoiceModel choiceModel = new ChoiceModel();
			if (i < 2) choiceModel.name = ("第顶顶顶顶顶" + i + "个");
			if (i >= 2 && i <= 5) choiceModel.name = ("第" + i + "个");
			if (i > 5) choiceModel.name = ("第" + i + "顶顶顶顶顶顶顶顶顶个");
			list.add(choiceModel);
		}
		return list;
	}

	@Override public void onCreateItemView(final View itemView, final int position, final ChoiceModel choiceModel) {
		if (choiceModel == null) return;
		TextView tvChoiceName = itemView.findViewById(R.id.tv_choice_name);
		ImageView ivChoiceIcon = itemView.findViewById(R.id.iv_choice_icon);
		if (choiceModel.isCheck) {
			itemView.setBackgroundResource(R.drawable.choice_st);
			ivChoiceIcon.setVisibility(View.VISIBLE);
		} else {
			itemView.setBackgroundResource(0);
			ivChoiceIcon.setVisibility(View.GONE);
		}
		tvChoiceName.setText(choiceModel.name);
	}

	@Override public void onChoiceItemClick(ViewGroup viewGroup,View view, int position, ChoiceModel choiceModel) {
		choiceModel.isCheck = !choiceModel.isCheck;
		if (viewGroup.equals(choiceControlLayout)) choiceControlLayout.notifyItemPositionData(position, choiceModel);
		if (viewGroup.equals(choiceRuleLayout)) choiceRuleLayout.notifyItemPositionData(position, choiceModel);
		if (viewGroup.equals(choiceIrregularLayout)) choiceIrregularLayout.notifyItemPositionData(position, choiceModel);
	}

}
