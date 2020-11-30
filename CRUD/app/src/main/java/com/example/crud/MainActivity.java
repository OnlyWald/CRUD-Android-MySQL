package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.crud.Adapter.adapterData;
import com.example.crud.Model.dataModel;
import com.example.crud.Model.responModel;
import com.example.crud.API.retroServer;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private RecyclerView rvData;
    private RecyclerView.Adapter adData;
    private RecyclerView.LayoutManager lmData;
    private List<dataModel> listData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvData = findViewById(R.id.rv_data);
        lmData = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false);
        rvData.setLayoutManager(lmData);
        getData();
    }

    public void getData(){
        Call<responModel> tampilData = retroServer.getMhsApi().ardGetMahasiswa();
        tampilData.enqueue(new Callback<responModel>() {
            @Override
            public void onResponse(Call<responModel> call, Response<responModel> response) {
                Log.e("Succes", response.body().getMessage());
                listData = response.body().getData();
                adData = new adapterData(MainActivity.this, listData);
                rvData.setAdapter(adData);
                adData.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<responModel> call, Throwable t) {
                Log.e("Failure", t.getLocalizedMessage());
            }
        });
    }
}