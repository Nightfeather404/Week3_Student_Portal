package com.example.student.portal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class UpdateActivity extends AppCompatActivity {

    EditText portalURL;
    EditText portalTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        portalURL = findViewById(R.id.editText_url);
        portalTitle = findViewById(R.id.editText_title);

        FloatingActionButton fab = findViewById(R.id.fab_add);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = portalURL.getText().toString();
                String title = portalTitle.getText().toString();

                if (!(TextUtils.isEmpty(url)) && !(TextUtils.isEmpty(title))) {
                    portalURL.setText("");
                    portalTitle.setText("");

                    Intent intent = new Intent(UpdateActivity.this, MainActivity.class);
                    Portal newportal = new Portal(url, title);
                    intent.putExtra(MainActivity.ADDITIONAL_PORTAL, newportal);
                    setResult(RESULT_OK, intent);
                    finish();
                } else {
                    Snackbar.make(view, "Please enter text in this field!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
            }
        });
    }
}
