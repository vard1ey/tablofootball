package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private int score1 = 0;
    private int score2 = 0;

    private TextView dinamo;
    private TextView spartak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dinamo = findViewById(R.id.textView2);
        spartak = findViewById(R.id.textView);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt("score1", 0);
            score2 = savedInstanceState.getInt("score2", 0);
            updateScoreDisplay();
        }
    }

    public void dinamo(View view) {
        score1++;
        updateScoreDisplay();
    }

    public void spartak(View view) {
        score2++;
        updateScoreDisplay();
    }

    private void updateScoreDisplay() {
        dinamo.setText(String.valueOf(score1));
        spartak.setText(String.valueOf(score2));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score1", score1);
        outState.putInt("score2", score2);
    }
}