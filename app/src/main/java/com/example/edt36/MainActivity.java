package com.example.edt36;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    private Spinner spinner;
    private ArrayList<Country> countries = new ArrayList<>();
    private CountryAdapter countryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        initList();
        countryAdapter = new CountryAdapter(this, countries);
        spinner.setAdapter(countryAdapter);
        spinner.setSelected(false);  // must
        spinner.setSelection(0,true);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Country selectedItem = (Country) parent.getItemAtPosition(position);
                String selectedCountryName = selectedItem.getName();

                if (!selectedCountryName.equals("Select a country")) {
                    Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                    intent.putExtra("pais", selectedCountryName);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(MainActivity.this, "Nothing selected", Toast.LENGTH_SHORT).show();
            }
        });


    }

    //@RequiresApi(api = Build.VERSION_CODES.O)
    private void initList() {
        countries.addAll(Arrays.asList(
                new Country("argentina",R.drawable.argentina),
                new Country("australia",R.drawable.australia),
                new Country("canada",R.drawable.canada),
                new Country("congo",R.drawable.congo),
                new Country("egypt",R.drawable.egypt),
                new Country("france",R.drawable.france),
                new Country("germany",R.drawable.germany),
                new Country("greece",R.drawable.greece),
                new Country("india",R.drawable.india),
                new Country("indonesia",R.drawable.indonesia),
                new Country("ireland",R.drawable.ireland),
                new Country("italy",R.drawable.italy),
                new Country("kenya",R.drawable.kenya),
                new Country("mexico",R.drawable.mexico),
                new Country("newzeland",R.drawable.newzeland),
                new Country("norway",R.drawable.norway),
                new Country("poland",R.drawable.poland),
                new Country("qatar",R.drawable.qatar),
                new Country("southafrica",R.drawable.southafrica),
                new Country("southkorea",R.drawable.southkorea),
                new Country("spain",R.drawable.spain),
                new Country("uk",R.drawable.uk),
                new Country("usa",R.drawable.usa)
        ));


        /*
        String str = "/Descargas/Edt19/app/src/main/res/drawable";
        Path*//* path = Paths.get(str);

       // DecimalFormat df = new DecimalFormat("00");
//        String[] types = {"clubs", "cups", "golds", "swords"};
        for (String type : types) {
            for (int i = 1; i < 13; i++) {
                cardValue.add(getResources().getIdentifier(type + df.format(i), "drawable", getPackageName()));
            }
        }
        for( int i=0;i<22;i++){
            countries.add(new Country(i+"",getResources().ggetPacka))
        }

        try {
            List<Path> list = Files.walk(Paths.get(str)).collect(Collectors.toList());
            for(int i=0; i<list.size();i++){
                String s = list.get(i).getFileName().toString();
                String p[] = s.split(".");
                if(s.contains(".png")){
                    countries.add(new Country(p[1],R.drawable.))
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


//        List<Path> result;
//        try (Stream<Path> walk = Files.walk(path)) {
//            result = walk.filter(Files::isRegularFile)
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}