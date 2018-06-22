package com.example.xxxxxx.androidcourse;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DynamicFragmentActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btnFragmentOne,btnFragmentTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        btnFragmentOne = findViewById(R.id.btnFragmentOne);
        btnFragmentTwo = findViewById(R.id.btnFragmentTwo);

        btnFragmentOne.setOnClickListener(this);
        btnFragmentTwo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnFragmentOne:
                OpenFragmentOne();
                break;
            case R.id.btnFragmentTwo:
                OpenFragmentTwo();
                break;
            default:
                break;
        }
    }

    private void OpenFragmentTwo() {
        TwoFragment twoFragment = new TwoFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_fragment,twoFragment)
        .commit();
    }

    private void OpenFragmentOne() {

        OneFragment oneFragment = new OneFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.layout_fragment,oneFragment)
        .commit();
    }
}
