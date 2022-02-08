package com.example.edt36;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CountryAdapter extends ArrayAdapter<Country> {

    public CountryAdapter(@NonNull Context context, ArrayList<Country> countryList) {
        super(context, 0, countryList);
    }

    private View initView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.spinner_row, parent, false);
        }
        ImageView imageView = convertView.findViewById(R.id.imageSpinner);
        TextView textView = convertView.findViewById(R.id.nameSpinner);
        Country currentItem = getItem(position);
        if (currentItem != null) {
            imageView.setImageResource(currentItem.getImage());
            textView.setText(currentItem.getName());
        }
        return convertView;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        return initView(position,convertView,parent);
    }
}
