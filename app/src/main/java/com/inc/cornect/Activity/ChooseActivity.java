package com.inc.cornect.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.inc.cornect.Database.AppData;
import com.inc.cornect.R;

public class ChooseActivity extends AppCompatActivity {

    AppData data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        data = new AppData(ChooseActivity.this);
    }

    public void PersonalClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("choose", "Personal");
        Intent intent = new Intent(ChooseActivity.this, LoginActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void CorporateClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("choose", "Corporate");
        Intent intent = new Intent(ChooseActivity.this, LoginActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(data.getLoggedIn()){
            startActivity(new Intent(ChooseActivity.this,HomeActivity.class));
            finish();
        }
    }
}
