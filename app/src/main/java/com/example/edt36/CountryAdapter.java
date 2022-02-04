package com.example.edt36;

import android.content.Context;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {

    public CountryAdapter(@NonNull Context context, ArrayList<Country> countryList) {
        super(context, resource);
    }
}
