package com.mathquiz.k12.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {
int score;
TextView s;
Button again;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        s=findViewById(R.id.score);
        again=findViewById(R.id.again);
        Bundle gg = new Bundle();
        gg=getIntent().getExtras();
        score=Integer.parseInt(gg.getString("score"));
        s.setText("YOUR SCORE IS: "+score);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(intent);

            }
        });
    }

}
