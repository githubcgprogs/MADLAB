package com.example.signup;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText txtUsername;
    EditText txtPassword;
    Button btnSignup;
    String regularExpression = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUsername = (EditText) findViewById(R.id.txt_username);
        txtPassword = (EditText) findViewById(R.id.txt_password);
        btnSignup = (Button) findViewById(R.id.btn_signup);
        btnSignup.setOnClickListener(this);
    }
    public void onClick(View v) {
        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();
        if (validatePassword(password)) {
            Bundle bundle = new Bundle();
            bundle.putString("Rehman", username);
            bundle.putString("Rehman@123", password);
            Intent it = new Intent(this, login.class);
            it.putExtra("data", bundle);
            startActivity(it);
        } else {
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
        }
    }
    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
