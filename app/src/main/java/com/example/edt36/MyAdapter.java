package com.example.edt36;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder> {
    private Context context;
    private List<Sport> sports;

    public MyAdapter(List<Sport> sports, Context context) {
        this.context = context;
        this.sports = sports;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {
        private ImageView flag;
        private TextView textTitle;
        private TextView textDescription;
        private Button button;
        private TextView button2;


        RelativeLayout relativeLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            flag= itemView.findViewById(R.id.flag);
            textTitle= itemView.findViewById(R.id.textTitle);
            textDescription= itemView.findViewById(R.id.textDescription);
            button= itemView.findViewById(R.id.button);
            button2= itemView.findViewById(R.id.button2);


            relativeLayout = itemView.findViewById(R.id.relativeRow);
        }
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Picasso.get().load(sports.get(position).getFlag())
                .fit()
                .centerCrop()
                .into(holder.flag);
        holder.textTitle.setText(sports.get(position).getTextTitle());
        holder.textDescription.setText(sports.get(position).getTextDescription());
        int count=0;
        for (String a : sports.get(position).getImages()){
            if (a.equals("null")){
                count++;
            }
        }
        if (count !=4){
            holder.button2.setVisibility(View.VISIBLE);
            holder.button2.setOnClickListener(v -> {
                Intent intent2 = new Intent(context,PagerActivity.class);
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent2.putStringArrayListExtra("images", sports.get(holder.getAdapterPosition()).getImages());
                context.startActivity(intent2);
            });
        }else{
            holder.button2.setVisibility(View.INVISIBLE);

        }
        holder.button.setOnClickListener(v -> {
            Uri uri = Uri.parse("https://" + sports.get(holder.getAdapterPosition()).getWebUrl());
            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }





}
