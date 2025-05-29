package com.example.appmedia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ImageView car ;
        car = (ImageView)findViewById(R.id.imageView3);
        ImageView moto ;
        moto = (ImageView)findViewById(R.id.imageView4);
        MediaPlayer carPlayer = MediaPlayer.create(this, R.raw.car);
        MediaPlayer motoPlayer = MediaPlayer.create(this, R.raw.moto);

        car.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Car Sound", Toast.LENGTH_LONG) .show();
            if (motoPlayer.isPlaying()) {
                motoPlayer.pause();
                motoPlayer.seekTo(0);
            }
            carPlayer.start();
        });

        moto.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(),"Moto Sound", Toast.LENGTH_LONG) .show();
            if (carPlayer.isPlaying()) {
                carPlayer.pause();
                carPlayer.seekTo(0);
            }
            motoPlayer.start();
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}