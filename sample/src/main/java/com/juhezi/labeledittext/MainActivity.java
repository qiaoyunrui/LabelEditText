package com.juhezi.labeledittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.juhezi.lableedittextview.view.LabelEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LabelEditText mLetTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLetTest = (LabelEditText) findViewById(R.id.let_test);
        ArrayList<String> labels = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            labels.add("张全蛋" + i + "");
        }
        mLetTest.setLabels(labels);
    }
}
