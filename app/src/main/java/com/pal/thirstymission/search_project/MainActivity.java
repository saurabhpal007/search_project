package com.pal.thirstymission.search_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText searchedit;
    Button searchbtn;
    ApiInterface apiInterface;
    private List<Projects> projects;

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchedit=findViewById(R.id.searchedit);
        searchbtn=findViewById(R.id.searchbtn);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Search Pressed", Toast.LENGTH_LONG).show();
                fetchpro(searchedit.getText().toString());


            }
        });
    }

    public void fetchpro(String key) {


        apiInterface = ApiClient.getApiClient().create(ApiInterface.class);

        Call<List<Projects>> call = apiInterface.getPro(key);
        call.enqueue(new Callback<List<Projects>>() {
            @Override
            public void onResponse(Call<List<Projects>> call, Response<List<Projects>> response) {
                Log.i("zzz","working");
                projects=response.body();
               adapter = new Adapter(projects, MainActivity.this);
               recyclerView.setAdapter(adapter);
               adapter.notifyDataSetChanged();
               //Log.i("zzz",""+projects.get(0).getTime());

            }
            @Override
            public void onFailure(Call<List<Projects>> call, Throwable t) {

                Toast.makeText(MainActivity.this, "NO RESULT FOUND"+t, Toast.LENGTH_LONG).show();

            }
        });


    }
}
