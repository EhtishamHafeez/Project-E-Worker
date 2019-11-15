package com.example.projectphase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpScreen extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private EditText password;
    private EditText confirmPassword;
    private CheckBox termsNconditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_screen);

        name=findViewById(R.id.et_signup_name);
        email=findViewById(R.id.et_signup_email);
        confirmPassword=findViewById(R.id.et_signup_cpassword);
        password=findViewById(R.id.et_signup_password);
        termsNconditions=findViewById(R.id.checkBox_terms);
    }

    public void call_login1(View view)
    {
        if( TextUtils.isEmpty(name.getText())){
            name.setError( "Name is required!" );
            //Toast.makeText(MainActivity.this, "Email is required!", Toast.LENGTH_SHORT).show();
        }
        if( TextUtils.isEmpty(email.getText())){
            email.setError( "Email is required!" );
            //Toast.makeText(MainActivity.this, "Email is required!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(TextUtils.isEmpty((password.getText())))
            {
               this.show_toast("Please enter password!");
            }
            else if(TextUtils.isEmpty((confirmPassword.getText())))
            {
              this.show_toast("Please confirm your password!");
            }
            else if(termsNconditions.isChecked())
            {

                this.show_toast("Successfully Logged In!");
                Intent intent = new Intent(SignUpScreen.this, SignUpScreen.class);
                startActivity(intent);
            }
            else
            {
                this.show_toast("Please agree to Terms and Conditions!");
            }
        }
    }

    public void call_signin(View view)
    {
        Intent intent = new Intent(SignUpScreen.this, SignInScreen.class);
        startActivity(intent);
    }

    public void show_toast(String string)
    {
        Toast toast = Toast.makeText(SignUpScreen.this, string, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 40);
        toast.show();
    }
}
