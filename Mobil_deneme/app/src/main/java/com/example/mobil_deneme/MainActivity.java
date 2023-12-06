package com.example.mobil_deneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    Button btn_convertor,btn_sms, btn_random;

    TextView tvNo,tv_İsim;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_convertor=findViewById(R.id.btn_convertor);
        btn_random=findViewById(R.id.btn_random);
        btn_sms=findViewById(R.id.btn_sms);
        tv_İsim=findViewById(R.id.tv_İsim);
        tvNo=findViewById(R.id.tvNo);


        btn_convertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, ConvertorActivity.class);
                startActivity(i);

            }
        });

        btn_random.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, RandomActivity.class);
                startActivity(i);

            }
        });

        btn_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, SmsActivity.class);
                startActivity(i);

            }
        });

    }
}