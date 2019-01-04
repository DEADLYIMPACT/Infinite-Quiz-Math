package com.mathquiz.k12.quizapp;

import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;
import java.text.DecimalFormat;
import android.os.Handler;

import static android.view.View.VISIBLE;


public class MainActivity extends AppCompatActivity {
    static TextView no;
    static TextView score;
    static TextView question;
    static TextView ans;
    static TextView timer;
    static ProgressBar bar;
    static Button submit;
    static Button next;
    static int a;
    static int b;
    static int c;
    static int e;
    static int q=1;
    static int scor;
    static int i;
    static int p;
    static double d;
    static double f;
    static double g;
    static double h;
    static double time;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        i=Integer.parseInt(intent.getStringExtra("level"));
        no=findViewById(R.id.No);
        score=findViewById(R.id.score);
        question=findViewById(R.id.question);
        ans=findViewById(R.id.answer);
        bar=findViewById(R.id.bar);
        submit=findViewById(R.id.submit);
        next=findViewById(R.id.next);
        q=1;
        q1();
        next.setVisibility(View.INVISIBLE);
        submit.setVisibility(View.VISIBLE);
        no.setText("Question No:1");
        bar.setMax(5);
        bar.setProgress(0);
        ans.setText("0");
        score.setText("Score:"+scor);
        Bundle more=getIntent().getExtras();
        i=Integer.parseInt(more.getString("level"));
        p=Integer.parseInt(more.getString("power"));
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ans.getText()!="") {
                    if (q == 1) {
                        c = Integer.parseInt(ans.getText().toString());
                        if (c == a + b) {
                            correct();
                        } else {
                            wrong();
                        }
                        q++;
                        next.setVisibility(VISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                    } else if (q == 2) {
                        c = Integer.parseInt(ans.getText().toString());
                        if (c == a - b) {
                            correct();
                        } else {
                            wrong();
                        }
                        q++;
                        next.setVisibility(VISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                    } else if (q == 3) {
                        c = Integer.parseInt(ans.getText().toString());
                        if (c == a * b) {
                            correct();
                        } else {
                            wrong();
                        }
                        q++;
                        next.setVisibility(VISIBLE);
                        submit.setVisibility(View.INVISIBLE);
                    } else if (q == 5) {
                        c = Integer.parseInt(ans.getText().toString());
                        if (c == Math.pow(a, b)) {
                            correct();
                        } else {
                            wrong();
                        }
                        q++;
                        end();


                    } else if (q == 4) {
                        d = Double.parseDouble(ans.getText().toString());
                        DecimalFormat df = new DecimalFormat("###.##");
                        d = Double.parseDouble(df.format(d));
                        if (d == f) {
                            correct();
                        } else {
                            question.setText("Wrong. The correct answer was " + f);
                        }
                        q++;
                        next.setVisibility(VISIBLE);
                        submit.setVisibility(View.INVISIBLE);

                    }
                    else if (q==6){
                        Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                        Bundle gg=new Bundle();
                        gg.putString("score",Integer.toString(scor));
                        intent.putExtras(gg);
                        startActivity(intent);
                }


                }
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(q==2){
                    ans.setText("0");
                    q2();
                    no.setText("Question No:2");
                    bar.setProgress(1);
                }else if(q==3){
                    ans.setText("0");
                    q3();
                    no.setText("Question No:3");
                    bar.setProgress(2);
                }
                else if(q==4){
                    ans.setText("0");
                    q4();
                    no.setText("Question No:4");
                    bar.setProgress(3);
                }
                else if(q==5){
                    ans.setText("0");
                    q5();
                    no.setText("Question No:5");
                    bar.setProgress(4);
                }
            }
        });


    }
    static void q1(){
        a = new Random().nextInt(i);
        b = new Random().nextInt(i);
        question.setText(a + "+" + b);
        e=a+b;
        submit.setVisibility(VISIBLE);
    }
    static void q2(){
        a = new Random().nextInt(i);
        b = new Random().nextInt(i);
        question.setText(a + "-" + b);
        e=a-b;
        next.setVisibility(View.INVISIBLE);
        submit.setVisibility(VISIBLE);

    }
    static void q3(){
        a = new Random().nextInt(i);
        b = new Random().nextInt(i);
        question.setText(a + "x" + b);
        e=a*b;
        next.setVisibility(View.INVISIBLE);
        submit.setVisibility(VISIBLE);

    }
    static void q4(){
        g = new Random().nextInt(i);
        h = new Random().nextInt(i);
        question.setText(g + "/" + h);
        f=g/h;
        DecimalFormat fd = new DecimalFormat("###.##");
        f=Double.parseDouble(fd.format(f));
        next.setVisibility(View.INVISIBLE);
        submit.setVisibility(VISIBLE);
    }
    static void q5(){
        a = new Random().nextInt(p);
        b = new Random().nextInt(p);
        question.setText(a + "^" + b);
        d=Math.pow(a,b);
        e=(int) d;
        next.setVisibility(View.INVISIBLE);
        submit.setVisibility(VISIBLE);
    }

    static void correct(){
        question.setText("Correct");
        scor++;
        score.setText("Score:"+scor);

    }
    static void wrong(){
        question.setText("Wrong. The correct answer was "+e);
        score.setText("Score:"+scor);

    }
    static void end(){
        submit.setText("FINISH");
    }

}
