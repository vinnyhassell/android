package com.example.vinny.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SoundManager player;
    boolean playing = false;

    public void playSound(int soundId)
    {
        if (playing)
            player.stopPlaying();
        player = player.create(this, soundId);
        playing = true;
    }

    public void stopSound()
    {
        if (playing) {
            player.stopPlaying();
            playing = false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Set up the Timepicker
        TimePicker timePicker = (TimePicker) findViewById(R.id.timePicker1);
        timePicker.setIs24HourView(true);
        //Set up the media player

        final Button btnWhiteNoise =(Button)findViewById(R.id.btnPlayWhiteNoise);
        btnWhiteNoise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"This plays white noise", Toast.LENGTH_LONG).show();
                if (btnWhiteNoise.getTag()=="clicked")
                {
                    btnWhiteNoise.setTextColor(Color.BLACK);
                    btnWhiteNoise.setTag("");
                    stopSound();
                }
                else {
                    btnWhiteNoise.setTag("clicked");
                    btnWhiteNoise.setTextColor(Color.MAGENTA);
                    playSound(R.raw.whitenoise);                }
            }
        });

        final Button btnPinkNoise =(Button)findViewById(R.id.btnPlayPinkNoise);
        btnPinkNoise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"This plays pink noise", Toast.LENGTH_LONG).show();
                btnPinkNoise.setTextColor(Color.MAGENTA);
                playSound(R.raw.pinknoise);
            }
        });

        final Button btnBrownNoise =(Button)findViewById(R.id.btnPlayBrownNoise);
        btnBrownNoise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"This plays brown noise", Toast.LENGTH_LONG).show();
                btnBrownNoise.setTextColor(Color.MAGENTA);
                playSound(R.raw.brownnoise);
            }
        });


       }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onDestroy() {

        super.onDestroy();

    }
}
