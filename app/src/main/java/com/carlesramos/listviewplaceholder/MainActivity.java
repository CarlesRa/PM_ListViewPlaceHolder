package com.carlesramos.listviewplaceholder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.carlesramos.listviewplaceholder.model.Country;
import com.carlesramos.listviewplaceholder.model.CountryAdapter;
import com.carlesramos.listviewplaceholder.model.CountryParser;

public class MainActivity extends AppCompatActivity {
    private CountryAdapter adaptadorPaisos;
    private CountryParser parser;
    private ListView lvPrincipal;
    private Country[] paisos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parser = new CountryParser(this);
        parser.parse();
        paisos = parser.getCountries();
        lvPrincipal = findViewById(R.id.lvPrincipal);
        adaptadorPaisos = new CountryAdapter(MainActivity.this,paisos);
        lvPrincipal.setAdapter(adaptadorPaisos);
    }
}
