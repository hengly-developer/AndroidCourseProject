package com.example.xxxxxx.androidcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private EditText txtSecondName;
    private TextView txtSecondResult;
    private Button btnSecondClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        txtSecondName = findViewById(R.id.txtSecondName);
        txtSecondResult = findViewById(R.id.txtSecondResult);

        btnSecondClick = findViewById(R.id.btnSecondClick);

        GetIntent();
        ClickSecondIntent();
    }

    private void GetIntent() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String data = bundle.getString("data");
            txtSecondResult.setText(data);
            txtSecondName.setText(data);
        }
    }

    private void ClickSecondIntent() {

        btnSecondClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = txtSecondName.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });
    }
}
