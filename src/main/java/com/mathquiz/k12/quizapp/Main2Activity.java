package com.mathquiz.k12.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

public class Main2Activity extends AppCompatActivity {
static int d,c;
static Button start,easy,medium,hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        start=findViewById(R.id.start);
        easy=findViewById(R.id.easy);
        medium=findViewById(R.id.medium);
        hard=findViewById(R.id.hard);
        easy.setVisibility(INVISIBLE);
        medium.setVisibility(INVISIBLE);
        hard.setVisibility(INVISIBLE);
        start.setVisibility(VISIBLE);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.setVisibility(INVISIBLE);
                easy.setVisibility(VISIBLE);
                medium.setVisibility(VISIBLE);
                hard.setVisibility(VISIBLE);
            }

        });
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=50;
                c=3;
                Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("level",Integer.toString(d));
                bundle.putString("power",Integer.toString(c));
                intent.putExtras(bundle);
                startActivity(intent);
            }});
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=130;
                c=5;
                Intent intent=new Intent(Main2Activity.this, MainActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("level",Integer.toString(d));
                bundle.putString("power",Integer.toString(c));
                intent.putExtras(bundle);
                startActivity(intent);
            }});
        hard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                d=200;
                c=10;
                Intent intent=new Intent(Main2Activity.this, MainActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("level",Integer.toString(d));
                bundle.putString("power",Integer.toString(c));
                intent.putExtras(bundle);
                startActivity(intent);
            }});

    }


}
