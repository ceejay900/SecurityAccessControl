package com.example.useraccesscontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.prefs.Preferences;

public class CreateAccount extends AppCompatActivity {

    EditText newPassword, confirm;
    Button btnNewCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        newPassword = findViewById(R.id.newPassword);
        confirm = findViewById(R.id.confirm);


        btnNewCreate = findViewById(R.id.btnNewCreate);

        btnNewCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String newPass = newPassword.getText().toString();
                String newConfirm = confirm.getText().toString();

                if (newPass.isEmpty() || newConfirm.isEmpty()) {
                    Toast.makeText(CreateAccount.this, "fill the requirements", Toast.LENGTH_SHORT).show();
                } else {
                    if (newPass.length() == newConfirm.length()) {
                        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(CreateAccount.this);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.putString("newPass", newPassword.getText().toString());
                        editor.commit();
                        Toast.makeText(CreateAccount.this, "New password created", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(CreateAccount.this, "Password not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}