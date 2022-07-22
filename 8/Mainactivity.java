package com.example.callandsave;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private TextView inputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextView = findViewById(R.id.txt_phonenumber);

        Button zeroBtn = findViewById(R.id.btn_zero);
        Button oneBtn = findViewById(R.id.btn_one);
        Button twoBtn = findViewById(R.id.btn_two);
        Button threeBtn = findViewById(R.id.btn_three);
        Button fourBtn = findViewById(R.id.btn_four);
        Button fiveBtn = findViewById(R.id.btn_five);
        Button sixBtn = findViewById(R.id.btn_six);
        Button sevenBtn = findViewById(R.id.btn_seven);
        Button eightBtn = findViewById(R.id.btn_eight);
        Button nineBtn = findViewById(R.id.btn_nine);

        Button dotBtn = findViewById(R.id.btn_start);
        Button hashBtn = findViewById(R.id.btn_hash);
        TextView backspaceBtn = findViewById(R.id.btn_delete);

        Button callBtn = findViewById(R.id.btn_call);
        Button saveBtn = findViewById(R.id.btn_save);

        zeroBtn.setOnClickListener(this);
        oneBtn.setOnClickListener(this);
        twoBtn.setOnClickListener(this);
        threeBtn.setOnClickListener(this);
        fourBtn.setOnClickListener(this);
        fiveBtn.setOnClickListener(this);
        sixBtn.setOnClickListener(this);
        sevenBtn.setOnClickListener(this);
        eightBtn.setOnClickListener(this);
        nineBtn.setOnClickListener(this);

        dotBtn.setOnClickListener(this);
        backspaceBtn.setOnClickListener(this);
        backspaceBtn.setOnLongClickListener(this);
        hashBtn.setOnClickListener(this);

        callBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        int id = view.getId();
        String inputPhoneNo = inputTextView.getText().toString();

        switch (id) {
            case R.id.btn_call:
                callMethod(inputPhoneNo);
                break;
            case R.id.btn_save:
                saveMethod(inputPhoneNo);
                break;
            case R.id.btn_zero:
                inputTextView.append("0");
                break;
            case R.id.btn_one:
                inputTextView.append("1");
                break;
            case R.id.btn_two:
                inputTextView.append("2");
                break;
            case R.id.btn_three:
                inputTextView.append("3");
                break;
            case R.id.btn_four:
                inputTextView.append("4");
                break;
            case R.id.btn_five:
                inputTextView.append("5");
                break;
            case R.id.btn_six:
                inputTextView.append("6");
                break;
            case R.id.btn_seven:
                inputTextView.append("7");
                break;
            case R.id.btn_eight:
                inputTextView.append("8");
                break;
            case R.id.btn_nine:
                inputTextView.append("9");
                break;
            case R.id.btn_start:
                inputTextView.append("*");
                break;
            case R.id.btn_hash:
                inputTextView.append("#");
                break;
            case R.id.btn_delete:
                int inputLength = inputPhoneNo.length();
                if (inputLength > 0) {
                    inputTextView.setText(inputPhoneNo.substring(0, inputLength - 1));
                }
                break;
        }
    }

    private void callMethod(String number) {
        // if Intent.ACTION_CALL is used instead of Intent.ACTION_DIAL,
        // then manually allow the telephone permission in the App Settings
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri uri = Uri.parse("tel:" + number);
        intent.setData(uri);
        startActivity(intent);
    }

    private void saveMethod(String inputPhoneNo) {
        Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
        intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);
        intent.putExtra(ContactsContract.Intents.Insert.PHONE, inputPhoneNo);
        startActivity(intent);
    }

    @Override
    public boolean onLongClick(View view) {
        inputTextView.setText("");
        return true;
    }
}
