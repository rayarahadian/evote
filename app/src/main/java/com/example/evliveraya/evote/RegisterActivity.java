package com.example.evliveraya.evote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private EditText NIK, email, nama, password;
    private Button register;
    private DBHandler dbHandler;
    private String value_NIK, value_email, value_nama, value_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        NIK = (EditText) findViewById(R.id.register_NIK);
        email = (EditText) findViewById(R.id.register_email);
        nama = (EditText) findViewById(R.id.register_nama);
        password = (EditText) findViewById(R.id.register_password);
        register = (Button) findViewById(R.id.register_register);

        dbHandler = new DBHandler(this);

        // Action
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value_NIK = NIK.getText().toString();
                value_email = email.getText().toString();
                value_nama = nama.getText().toString();
                value_password = password.getText().toString();
                if ((!value_NIK.equals("")) && (!value_email.equals("")) && (!value_nama.equals("")) && (!value_password.equals(""))) {
                    User user = new User();
                    user.setNama(value_nama);
                    user.setNik(value_NIK);
                    user.setEmail(value_email);
                    user.setPassword(value_password);
                    user.setVote(0);
                    dbHandler.insertUser(user);
                    Toast toast = Toast.makeText(getApplicationContext(), "Registrasi berhasil", Toast.LENGTH_SHORT);
                    toast.show();
                    Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Tolong lengkapi semua form", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        nama.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nama.getText().toString().equals("Nama")) {
                    nama.setText("");
                }
            }
        });

        NIK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NIK.getText().toString().equals("NIK")) {
                    NIK.setText("");
                }
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().equals("Email")) {
                    email.setText("");
                }
            }
        });

        password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                password.setText("");
            }
        });
    }
}
