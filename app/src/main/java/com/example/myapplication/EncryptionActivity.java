package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EncryptionActivity extends AppCompatActivity {

    private EditText editTextEncryption;

    private Button btnSubmit;

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_encryption);
        editTextEncryption =  findViewById(R.id.input);
        btnSubmit =  findViewById(R.id.btn);
        result = findViewById(R.id.result);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEncrypt = editTextEncryption.getText().toString();
                if (strEncrypt.trim().equals("")) {
                    Toast.makeText(EncryptionActivity.this, "plz enter your Input", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    enCrypt(strEncrypt);
                }
            }
        });

        editTextEncryption.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if(keyCode == KeyEvent.KEYCODE_DEL) {
                    result.setText("result : " +"");
                }
                return false;
            }
        });
    }

    private void enCrypt(String strEncrypt) {

        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0; i < strEncrypt.length();i++){
            int k = i;
            int count = 1;
            char ch = strEncrypt.charAt(i);
            while ( k < (strEncrypt.length() - 1) && ch == strEncrypt.charAt(++k)){
                count ++;
            }
            stringBuffer.append(ch+""+count);
            i += count - 1;
        }

        System.out.println("result String is " +stringBuffer);

        result.setText("result : " +stringBuffer);
    }
}
