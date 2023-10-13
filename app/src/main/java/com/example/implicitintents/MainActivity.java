package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar a la variable el valor del EditText
        mWebsiteEditText = findViewById(R.id.website_edittext);
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        // Codifica y analiza el String en un objeto Uri
        Uri webpage = Uri.parse(url);

        // Aquí se especifica una accion y los datos para esa accion
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Busca una actividad para entregar la intención y comenzar la actividad
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "¡No puedo con esto!");
        }
    }

    public void openLocation(View view) {
    }

    public void shareText(View view) {
    }
}