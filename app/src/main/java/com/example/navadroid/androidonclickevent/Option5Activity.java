package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// TODO: View.OnClickListener as inner class and selecting view via id

public class Option5Activity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option5);
        bindView();
        initView();
    }

    // To bind views to this activity
    private void bindView(){
        etInput = findViewById(R.id.et_input_5);
        tvOutput = findViewById(R.id.tv_body_5);
    }

    private void initView(){
        // To register click event to view
        findViewById(R.id.btn_process_5).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_previous5).setOnClickListener(new InnerOnClickListener());
        findViewById(R.id.btn_next5).setOnClickListener(new InnerOnClickListener());
    }


    // A class that handles all of click events
    // It is private from other android class since it is within the Activity.
    class InnerOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_process_5:
                    greet();
                    break;
                case R.id.btn_previous5:
                    previousActivity();
                    break;
                case R.id.btn_next5:
                    nextActivity();
                    break;
            }
            hideKeyboardInput(v);
        }
    }

    private void previousActivity() {
        Intent intent = new Intent(getApplicationContext(),Option4Activity.class);
        startActivity(intent);
    }

    private void nextActivity() {
        Intent intent = new Intent(getApplicationContext(),Option0Activity.class);
        startActivity(intent);
    }

    // To greet the user
    private void greet(){
        tvOutput.setText(getString(R.string.greeting) + " " + etInput.getText().toString());
    }

    // To hide Android soft keyboard
    private void hideKeyboardInput(View v){
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
    }

}
