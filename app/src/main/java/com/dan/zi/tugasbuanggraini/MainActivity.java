package com.dan.zi.tugasbuanggraini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.UnsupportedEncodingException;

public class MainActivity extends AppCompatActivity {
private EditText edtTeks;
private TextView tvRes;
private Button btnEncode, btnDecode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        btnDecode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edtTeks.getText().toString();
                decodeTex(text);
            }
        });
    }

    private void initView() {
        edtTeks =  findViewById(R.id.edt_process);
        btnDecode = findViewById(R.id.btn_decode);
        btnEncode = findViewById(R.id.btn_encode);
        tvRes = findViewById(R.id.text_result);
    }


    private void decodeTex(String text) {
        try {
            byte[] data = text.getBytes("UTF-8");
            String base64 = Base64.encodeToString(data, Base64.DEFAULT);
            tvRes.setText(base64);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

}
