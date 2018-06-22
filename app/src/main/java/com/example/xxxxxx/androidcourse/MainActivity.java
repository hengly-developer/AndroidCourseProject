package com.example.xxxxxx.androidcourse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtName,txtSubject,txtSendData;
    private TextView textViewName,textViewSubject;
    private Button btnSendData,btnAdd,btnFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtSubject = findViewById(R.id.txtSubject);
        txtSendData = findViewById(R.id.txtSendData);
        textViewSubject = findViewById(R.id.textViewSubject);
        textViewName = findViewById(R.id.textViewName);

        btnSendData = findViewById(R.id.btnSendData);
        btnAdd = findViewById(R.id.btnAdd);
        btnFragment = findViewById(R.id.btnFragment);

        GetIntent();
        ClickIntent();
        AddData();
        OpenFragment();
    }

    private void OpenFragment() {
        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),DynamicFragmentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Name",txtName.getText().toString());
        outState.putString("Subject",txtSubject.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = savedInstanceState.getString("Name");
        String subject = savedInstanceState.getString("Subject");
        textViewName.setText(name);
        textViewSubject.setText(subject);
    }

    private void AddData() {

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String name = ;
//                String subject = ;

                textViewName.setText(txtName.getText().toString());
                textViewSubject.setText(txtSubject.getText().toString());
//
//                txtName.setText("");
//                txtSubject.setText("");
            }
        });
    }

    private void GetIntent() {
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String data = bundle.getString("data");
            txtSendData.setText(data);
        }
    }

    private void ClickIntent() {

        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String data = txtSendData.getText().toString().trim();
                Intent intent = new Intent(getApplicationContext(),SecondActivity.class);
                intent.putExtra("data",data);
                startActivity(intent);
            }
        });
    }
}
