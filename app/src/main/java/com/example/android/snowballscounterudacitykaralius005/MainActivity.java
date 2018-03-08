package com.example.android.snowballscounterudacitykaralius005;

import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;
import pl.droidsonroids.gif.GifTextView;

public class MainActivity extends AppCompatActivity {
    Button abutton;
    Button bbutton;
    Button mina;
    Button minb;
    Button reset;
    TextView scorea,scoreb;
    int tracka = 0;
    int trackb=0;
    GifImageView gif; // with the help of https://stackoverflow.com/questions/6533942/adding-gif-image-in-an-imageview-in-android
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abutton = findViewById(R.id.buttonfirst);
        bbutton = findViewById(R.id.buttonsecond);
        scorea = findViewById(R.id.scorea);
        scoreb = findViewById(R.id.scoreb);
        gif = findViewById(R.id.gif);
        mina = findViewById(R.id.buttonfirstminus);
        minb = findViewById(R.id.buttonsecondminus);
        reset = findViewById(R.id.resetbtn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tracka=0;
                trackb=0;
                showb();
                showa();
            }
        });
        mina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tracka>0) {
                    tracka--;
                    showa();
                }
            }
        });
        minb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(trackb>0) {
                    trackb--;
                    showb();
                }
            }
        });
        abutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gif.setVisibility(View.VISIBLE);
                gif.setBackgroundResource(R.drawable.a_hits);
                trackb++;
                setGone();
                showb();
            }
        });
        bbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tracka++;
                gif.setVisibility(View.VISIBLE);
                gif.setBackgroundResource(R.drawable.b_hits);
                setGone();
                showa();
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("avalue",tracka);
        savedInstanceState.putInt("bvalue",trackb);
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        tracka = savedInstanceState.getInt("avalue");
        trackb = savedInstanceState.getInt("bvalue");
        showa();
        showb();
    }
    private void setGone()
    {
        // with the help of https://stackoverflow.com/questions/3072173/how-to-call-a-method-after-a-delay-in-android
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                gif.setVisibility(View.GONE);
            }
        },1900);
    }
    private void showa ()
    {
        scorea.setText(String.valueOf(tracka));
    }
    private void showb()
    {
        scoreb.setText(String.valueOf(trackb));
    }
}
