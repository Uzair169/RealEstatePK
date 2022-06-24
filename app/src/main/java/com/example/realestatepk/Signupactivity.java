package com.example.realestatepk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.InflateException;

public class Signupactivity extends AppCompatActivity {
    TextView already;
    Button register;
    private EditText inputname,phoneno,inputmail,inputpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        register = findViewById(R.id.register);
        inputname = findViewById(R.id.PersonName);
        phoneno = findViewById(R.id.TextPhone);
        inputmail = findViewById(R.id.TextEmailAddress);
        inputpass = findViewById(R.id.Password);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredentials();
            }
        });

    }

    private void checkCredentials() {
        String username =inputname.getText().toString();
        String email=inputmail.getText().toString();
        String password=inputpass.getText().toString();
        String phone=phoneno.getText().toString();
        if(username.isEmpty())
        {
            showError(inputname,"Name Field Is Empty");
        }
        else if(email.isEmpty() || !email.contains("@"))
        {
            showError(inputmail,"Email Invalid");
        }
        else if(password.isEmpty()  )
        {
            showError(inputpass,"Password Not Entered");
        }
        else if(phone.isEmpty() )
        {
            showError(phoneno,"Phone Invalid");
        }
        else
        {
            Intent intent = new Intent(Signupactivity.this, FragmentsActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Account Created", Toast.LENGTH_LONG).show();
        }}

    private void showError(EditText input, String name_field_is_empty) {
        input.setError(name_field_is_empty);
        input.requestFocus();
    }
}