package com.example.numbers;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int Times = 0;
    TextView num ;
    String TAG = MainActivity.class.getSimpleName();
    int Secret = new Random().nextInt(10)+1;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        num = findViewById(R.id.num);
        imageView = findViewById(R.id.imageView);
        Log.d(TAG,"secret:" + Secret);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Times += 1;
                num.setText(Integer.toString(Times));
                imageView.setVisibility(View.VISIBLE);
                imageView.setAlpha(1.0f);
                if (Times == Secret) {
                    Toast.makeText(MainActivity.this, "Bingo", Toast.LENGTH_LONG).show();
                    imageView.setImageResource(R.drawable.cry);
                } else {
                    imageView.setImageResource(R.drawable.smile);
                    imageView.animate().alpha(0.0f).setDuration(1200);
                }
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

    public void reset (View view){
        Times=0 ;
        num.setText("0");
    }
}
