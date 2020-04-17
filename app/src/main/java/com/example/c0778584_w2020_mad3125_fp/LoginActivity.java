package com.example.c0778584_w2020_mad3125_fp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private String username,password;
    private Button ok;
    private EditText editTextUsername,editTextPassword;
    private CheckBox saveLoginCheckBox;
    private SharedPreferences loginPreferences;
    private SharedPreferences.Editor loginPrefsEditor;
    private Boolean saveLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ok = (Button)findViewById(R.id.buttonLogin);
        ok.setOnClickListener(this);
        editTextUsername = (EditText)findViewById(R.id.editTextEmail);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);
        saveLoginCheckBox = (CheckBox)findViewById(R.id.checkBoxRememberMe);
        loginPreferences = getSharedPreferences("loginPrefs", MODE_PRIVATE);
        loginPrefsEditor = loginPreferences.edit();

        saveLogin = loginPreferences.getBoolean("saveLogin", false);
        if (saveLogin == true) {
            editTextUsername.setText(loginPreferences.getString("username", ""));
            editTextPassword.setText(loginPreferences.getString("password", ""));
            saveLoginCheckBox.setChecked(true);
        }

    }
    public void onClick(View view) {
        if (view == ok) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(editTextUsername.getWindowToken(), 0);

            username = editTextUsername.getText().toString();
            password = editTextPassword.getText().toString();

            if (saveLoginCheckBox.isChecked())
            {
                loginPrefsEditor.putBoolean("saveLogin", true);
                loginPrefsEditor.putString("username", username);
                loginPrefsEditor.putString("password", password);
                loginPrefsEditor.commit();
                // doSomethingElse();
            } else
            {
                loginPrefsEditor.clear();
                loginPrefsEditor.commit();
                //    doSomethingElse();
            }
            goNext();
        }
    }
    public void goNext() {
        if (editTextUsername.getText().toString().equals("asd") && (editTextPassword.getText().toString().equals("asd"))) {
            startActivity(new Intent(LoginActivity.this, CustomerListActivity.class));
            LoginActivity.this.finish();
        }

    }

}

