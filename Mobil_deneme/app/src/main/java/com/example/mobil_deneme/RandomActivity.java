package com.example.mobil_deneme;


import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


import androidx.appcompat.app.AppCompatActivity;


public class RandomActivity extends AppCompatActivity {

    private LinearLayout layout;
    private EditText minEditText, maxEditText, countEditText;
    private Button generateButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random);

        layout = findViewById(R.id.layout);
        minEditText = findViewById(R.id.minEditText);
        maxEditText = findViewById(R.id.maxEditText);
        countEditText = findViewById(R.id.countEditText);
        generateButton = findViewById(R.id.generateButton);


        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateRandomNumbers();
            }
        });




    }

    private void generateRandomNumbers() {
        layout.removeAllViews(); // Önceki progress barları temizle

        int min = Integer.parseInt(minEditText.getText().toString());
        int max = Integer.parseInt(maxEditText.getText().toString());
        int count = Integer.parseInt(countEditText.getText().toString());

        if (min >= max) {
            // Hata durumunda kullanıcıya hata mesajı göster
            Toast.makeText(this, "Min değeri max değerinden büyük veya eşit olamaz.", Toast.LENGTH_SHORT).show();
            return;
        }



        Random random = new Random();

        for (int i = 0; i < count; i++) {
            int randomNumber = random.nextInt((max - min) + 1) + min;

            // Layout için bir satır oluştur
            LinearLayout rowLayout = new LinearLayout(this);
            rowLayout.setOrientation(LinearLayout.HORIZONTAL);

            // Sayıyı gösteren bir TextView oluştur
            TextView numberTextView = new TextView(this);
            numberTextView.setText(String.valueOf(randomNumber));







            // Progress bar oluştur
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT
            );
            params.width = 800;
            params.height=300;



            ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
            progressBar.setMax(max - min);
            progressBar.setProgress(randomNumber - min);
            progressBar.setLayoutParams(params);

            // Yüzde değerini gösteren bir TextView oluştur
            TextView percentageTextView = new TextView(this);
            percentageTextView.setText(String.format("%d%%", (randomNumber - min) * 100 / (max - min)));

            // TextView ve ProgressBar'ı dikey LinearLayout'a ekle
            rowLayout.addView(numberTextView);
            rowLayout.addView(progressBar);

            rowLayout.addView(percentageTextView);

            // Ana layout'a dikey LinearLayout'ı ekle
            layout.addView(rowLayout);
        }
    }
    }

