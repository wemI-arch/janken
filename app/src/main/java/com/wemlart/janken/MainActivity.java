package com.wemlart.janken;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    int win=0;
    int lose=0;
    TextView comMessage;
    TextView resultMessage;
    TextView comHand;
    TextView youHand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        comMessage = findViewById(R.id.comMessage);
        resultMessage = findViewById(R.id.resultMessage);
        comHand = findViewById(R.id.comHandMessage);
        youHand = findViewById(R.id.youHandMessage);
        //クリックしたらonClick()へ
        findViewById(R.id.button1).setOnClickListener(this);
        findViewById(R.id.button2).setOnClickListener(this);
        findViewById(R.id.button3).setOnClickListener(this);
    }
    @Override   //View.OnClickListener.onClick()をコピーして上書き
    public void onClick(View view) {
        //コンピュータのおてて乱数
        int com = (int)(Math.random()*3); //0=ぐー 1=ちょき 2=ぱー
        //グーチョキパーのボタン
        if(view.getId()==R.id.button1) battle(0,com);
        else if(view.getId()==R.id.button2) battle(1,com);
        else if(view.getId()==R.id.button3) battle(2,com);
    }
    private void battle(int you,int com){
        comMessage.setText("じゃーんけーん…");
        comMessage.setText("ぽん！");
        //自分のおてて
        if(you==0)youHand.setText("✊");
        else if(you==1)youHand.setText("✌");
        else youHand.setText("✋");
        //コンピュータのおてて
        if(com==0)comHand.setText("✊");
        else if(com==1)comHand.setText("✌");
        else comHand.setText("✋");
        //勝敗判定
        if(you==com){   //あいこ
            comMessage.setText("なかなかやるじゃない");
        }
        else if(you-com==-1||you-com==2) {    //勝ち
            win++;
            comMessage.setText("くっ、この私が…");
        }
        else{   //you-com==-2||you-com==1   //負け
            lose++;
            comMessage.setText("ま、当然の結果ね！");
        }
        resultMessage.setText(win+"勝"+lose+"敗");
    }
}