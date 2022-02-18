package com.example.edt36;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Sport> sports = new ArrayList<>();
    MyAdapter adapter;
    static  String JSON = "https://www.thesportsdb.com/api/v1/json/2/search_all_leagues.php?c=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        recyclerView = findViewById(R.id.recyclerView);
        String pais = getIntent().getStringExtra("pais");
        JSON = JSON +pais;
        getSports();



    }

    private void getSports() {

        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                JSON ,
                null,
                (Response.Listener<JSONObject>) response -> {

                    try {
                        JSONArray jsonArray =  response.getJSONArray("countrys");
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Sport sport = new Sport();
                            sport.setFlag(jsonObject.getString("strBadge"));
                            sport.setTextTitle(jsonObject.getString("strLeague"));
                            sport.setTextDescription(jsonObject.getString("strDescriptionEN"));
                            sport.setWebUrl(jsonObject.getString("strWebsite"));
                            ArrayList<String> images = new ArrayList<>();
                            images.add(jsonObject.getString("strFanart1"));
                            images.add(jsonObject.getString("strFanart2"));
                            images.add(jsonObject.getString("strFanart3"));
                            images.add(jsonObject.getString("strFanart4"));
                            sport.setImages(images);
                            sports.add(sport);
                        }


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    recyclerView.setLayoutManager(new
                            LinearLayoutManager(getApplicationContext()));
                    adapter = new MyAdapter(sports,getApplicationContext());
                    recyclerView.setAdapter(adapter);
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("tag","onErrorResponse: " + error.getMessage());
                    }
                }

        );

        queue.add(jsonObjectRequest);
    }

}