package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ConfigActivity extends AppCompatActivity {

    Button setupWidget,configButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        setResult(RESULT_CANCELED);
        setupWidget = findViewById(R.id.setupWidget);
        configButton = findViewById(R.id.configButton);

        setupWidget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSetupWidget();
            }
        });

        configButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleSetupWidget();
            }
        });
    }

    private void handleSetupWidget() {
        showAppWidget();

    }

    private void handleConfigWidget() {
        Toast.makeText(ConfigActivity.this,
                "Configuration options", Toast.LENGTH_LONG).show();

    }
    int appWidgetId;
    private void showAppWidget() {
        appWidgetId = AppWidgetManager.INVALID_APPWIDGET_ID;
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {
            appWidgetId = extras.getInt(
                    AppWidgetManager.EXTRA_APPWIDGET_ID,
                    AppWidgetManager.INVALID_APPWIDGET_ID);
            if (appWidgetId == AppWidgetManager.INVALID_APPWIDGET_ID) {
                finish();
            }

            Intent resultValue = new Intent();
            resultValue.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
            setResult(RESULT_OK, resultValue);
            finish();
        }
    }


}
