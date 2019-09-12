package com.example.classroom;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends Activity {

    private static final String TAG = "NewActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        setContentView(R.layout.new_activity);
        String selectedItem = getIntent().getStringExtra("selected item");
        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(selectedItem);
    }
}
