package com.moringaschool.plenty.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.moringaschool.plenty.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.findMealsButton)
    Button mFindMealsButton;
    @BindView(R.id.mealsEditText)
    EditText mMealsEditText;
    @BindView(R.id.appNameTextView)
    TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        mFindMealsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mFindMealsButton) {
            String meals = mMealsEditText.getText().toString();
            Intent intent = new Intent(AboutActivity.this, MealListActivity.class);
            intent.putExtra("meals", meals);
            startActivity(intent);
//                    Toast.makeText(AboutActivity.this, name, Toast.LENGTH_LONG).show();
        }
    }
}