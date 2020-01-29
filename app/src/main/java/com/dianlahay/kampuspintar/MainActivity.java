package com.dianlahay.kampuspintar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv = (ImageView) findViewById(R.id.iiv);
        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.myanimasi);
        iv.startAnimation(myanim);
        final Intent i = new Intent(this, Menu.class);
        Thread timer =new Thread(){
            public void run () {
                try {
                    sleep(3000);
                }catch (InterruptedException e) {
                    e.printStackTrace();

                }
                finally {
                    startActivity(i);
                    finish();

                }
            }
        };
        timer.start();
    }

}
