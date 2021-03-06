package com.example.navadroid.androidonclickevent;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

// TODO: Using XML onClick attribute and selecting view via id
public class Option1Activity extends AppCompatActivity {

    private EditText etInput;
    private TextView tvOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option1);
        bindView();
    }

    private void bindView() {
        etInput = findViewById(R.id.et_input_1);
        tvOutput = findViewById(R.id.tv_body_1);
    }

    // This "process" method MUST be bound in the layout XML file, "android:onClick="process""
    public void process(View v) {
        if(v.getId() == R.id.btn_process_1) {
            greet();
        }
        hideKeyboardInput(v);
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

    //change activity krub
    public void changeActivity(View view) {
        if(view.getId() == R.id.btn_previous1){
            Intent intent = new Intent(getApplicationContext(),Option0Activity.class);
            startActivity(intent);
        }
        if (view.getId() == R.id.btn_next1){
            Intent intent = new Intent(getApplicationContext(),Option2Activity.class);
            startActivity(intent);

        }
    }
}
