package com.example.projectphase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignInScreen extends AppCompatActivity {

    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_screen);

        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);

    }

    public void call_signup(View view)
    {
        Intent intent = new Intent(SignInScreen.this, SignUpScreen.class);
        startActivity(intent);
    }


    public void call_login(View view)
    {

        if( TextUtils.isEmpty(email.getText())){
            email.setError( "Email is required!" );
            //Toast.makeText(MainActivity.this, "Email is required!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(TextUtils.isEmpty((password.getText())))
            {
                //password.setError("Password is required!");
                Toast.makeText(SignInScreen.this, "Enter your password!", Toast.LENGTH_SHORT).show();
            }
            else
            {

                Intent intent = new Intent(SignInScreen.this, SignInScreen.class);
                startActivity(intent);
            }
        }
    }

}
