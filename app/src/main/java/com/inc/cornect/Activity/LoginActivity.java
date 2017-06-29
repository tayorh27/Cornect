package com.inc.cornect.Activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import com.inc.cornect.Database.AppData;
import com.inc.cornect.R;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private View mLoginFormView;
    String choose;
    AppData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        data = new AppData(LoginActivity.this);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        getSupportActionBar().setTitle("Login - " + bundle.getString("choose"));
        choose = bundle.getString("choose");
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.email);

        mPasswordView = (EditText) findViewById(R.id.password);

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginUser();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
    }

    private void LoginUser() {
        String username = mEmailView.getText().toString();
        String password = mPasswordView.getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("type", choose);
        if (choose.contentEquals("Personal")) {
            if (data.getPersonalInfo().username.contentEquals(username)) {
                if (data.getPersonalInfo().password.contentEquals(password)) {
                    Snackbar.make(mLoginFormView, "Login successful", Snackbar.LENGTH_SHORT).show();
                    data.setLoggedIn(true);
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class).putExtras(bundle));
                    finish();
                } else {
                    Snackbar.make(mLoginFormView, "Invalid details", Snackbar.LENGTH_SHORT).show();
                }
            } else {
                Snackbar.make(mLoginFormView, "Invalid details", Snackbar.LENGTH_SHORT).show();
            }
        } else {
            if (data.getCorporateInfo().username.contentEquals(username)) {
                if (data.getCorporateInfo().password.contentEquals(password)) {
                    Snackbar.make(mLoginFormView, "Login successful", Snackbar.LENGTH_SHORT).show();
                    data.setLoggedIn(true);
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class).putExtras(bundle));
                    finish();
                } else {
                    Snackbar.make(mLoginFormView, "Invalid details", Snackbar.LENGTH_SHORT).show();
                }
            } else {
                Snackbar.make(mLoginFormView, "Invalid details", Snackbar.LENGTH_SHORT).show();
            }
        }
    }

    public void RegisterClick(View view) {
        if (choose.contentEquals("Personal")) {
            startActivity(new Intent(LoginActivity.this, RegisterPersonalActivity.class));
        } else {
            startActivity(new Intent(LoginActivity.this, RegisterCorporateActivity.class));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }
}

