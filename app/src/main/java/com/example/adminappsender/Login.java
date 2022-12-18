package com.example.adminappsender;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private Button login;
    private EditText logpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        login = (Button) findViewById(R.id.loginbutton);
        login.setOnClickListener(this);
        logpassword = (EditText) findViewById(R.id.passwordinput);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case (R.id.loginbutton):
                btnlogin();
                break;
        }
    }

    private void btnlogin() {
        Intent intent;
        String Adminpass = logpassword.getText().toString().trim();

        switch (Adminpass) {

            case ("admin"):
                intent = new Intent(Login.this, MainActivity.class);
                startActivity(intent);
                finish();

                break;

                default:
                Toast.makeText(Login.this, "Failed to login, incorrect credentials", Toast.LENGTH_LONG).show();

        }


        if(Adminpass.isEmpty()){
            logpassword.setError("Please enter your password");
            logpassword.requestFocus();
            return;
        }
    }
}
