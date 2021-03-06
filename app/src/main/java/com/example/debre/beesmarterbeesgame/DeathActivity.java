package com.example.debre.beesmarterbeesgame;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.debre.beesmarterbeesgame.StartScreen.StartScreenAct;

public class DeathActivity extends AppCompatActivity {

    Button button;
    TextView textView;
    TextView textView2;
    private DeathActivity deathActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_death);

        int mUIFlag = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

        getWindow().getDecorView().setSystemUiVisibility(mUIFlag);
        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);




         SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
       int highScore = settings.getInt("HIGH_SCORE", 0);
       if (GamePanel.gamePanel.score > highScore) {
         textView2.setText(String.valueOf(GamePanel.gamePanel.score));
          textView.setText(String.valueOf(GamePanel.gamePanel.score));
          SharedPreferences.Editor editor = settings.edit();
          editor.putInt("HIGH_SCORE", GamePanel.gamePanel.score);
        editor.commit();
//
       } else {
           textView2.setText(String.valueOf(highScore));
            textView.setText(String.valueOf(GamePanel.gamePanel.score));
//
        }









        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DeathActivity.this, StartScreenAct.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                overridePendingTransition(0, 0);
                startActivity(i);
                finish();
            }
        });

    }
    public DeathActivity(){
        deathActivity = this;



    }






}
