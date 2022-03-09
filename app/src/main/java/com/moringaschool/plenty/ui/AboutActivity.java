package com.moringaschool.plenty.ui;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.moringaschool.plenty.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AboutActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.shopButton) Button mShopButton;
    @BindView(R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);

        ButterKnife.bind(this);
        mShopButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mShopButton) {
            String location = mLocationEditText.getText().toString();
            Intent intent = new Intent(AboutActivity.this, MealListActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
//                    Toast.makeText(AboutActivity.this, name, Toast.LENGTH_LONG).show();
        }
    }
}
