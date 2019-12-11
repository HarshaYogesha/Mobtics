package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DecryptionActivity extends AppCompatActivity {

    private EditText editTextEncryption;

    private Button btnSubmit;

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decryption);

        editTextEncryption =  findViewById(R.id.input);
        btnSubmit =  findViewById(R.id.btn);
        result = findViewById(R.id.result);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strEncrypt = editTextEncryption.getText().toString();
                if (strEncrypt.trim().equals("")) {
                    Toast.makeText(DecryptionActivity.this, "plz enter Input ", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                  decrypt(strEncrypt);
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

    private void decrypt(String strEncrypt) {

        int k = 0;
        StringBuffer stringBuffer = new StringBuffer();

        while(k < strEncrypt.length() - 1){
            char ch = strEncrypt.charAt(k);
            int n = strEncrypt.charAt(++k);
            n -= 48;

            for(int i = 1;i <= n; i++){
                stringBuffer.append(ch);

            }
            k++;
        }
        System.out.println("result String is " +stringBuffer);

        result.setText("result : " +stringBuffer);
    }

}
