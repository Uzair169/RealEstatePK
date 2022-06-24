package com.example.realestatepk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Loginactivity extends AppCompatActivity {


    TextView register;
    private EditText inputmail,inputpass;
    Button signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginactivity);

        register = findViewById(R.id.btnregister);
        signin = findViewById(R.id.button3);
        inputmail = findViewById(R.id.TextEmailAddress);
        inputpass = findViewById(R.id.TextPassword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Loginactivity.this, Signupactivity.class);
                startActivity(intent);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkCredentials();

            }

            private void checkCredentials() {
                String email=inputmail.getText().toString();
                String password=inputpass.getText().toString();
                if(email.isEmpty() || !email.contains("@"))
                {
                    showError(inputmail,"Email Invalid");
                }
                else if(password.isEmpty()  )
                {
                    showError(inputpass,"Password Not Entered");
                }
                else{
                    Intent intent = new Intent(Loginactivity.this, FragmentsActivity.class);
                    startActivity(intent);
                }

            }

            private void showError(EditText input, String email_invalid) {
                input.setError(email_invalid);
                input.requestFocus();
            }
        });
    }
    }