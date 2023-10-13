package com.example.implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText mWebsiteEditText;

    private EditText mLocationEditText;

    private EditText mShareEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignar a la variable el valor del EditText
        mWebsiteEditText = findViewById(R.id.website_edittext);

        // Asigna a la variable el valor del EditText de la localización
        mLocationEditText = findViewById(R.id.location_edittext);

        // Asigna a la variable el EditText del Share
        mShareEditText = findViewById(R.id.share_edittext);
    }

    public void openWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();

        // Codifica y analiza el String en un objeto Uri
        Uri webpage = Uri.parse(url);

        // Aquí se especifica una accion y los datos para esa accion
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);

        // Busca una actividad para entregar la intención y comenzar la actividad

        startActivity(intent);

    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();

        // Analiza la cadena en un objeto Uri con una consulta de búsqueda geográfica
        Uri addressUri = Uri.parse("geo:0,0?q=" + loc);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);

        startActivity(intent);
    }

    public void shareText(View view) {
        String txt = mShareEditText.getText().toString();

        String mimeType = "text/plain";

        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Comparte este texto con: ")
                .setText(txt)
                .startChooser();
    }
}