package com.tecavi.ejemplorecycler;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tecavi.clases.Mago;
import com.tecavi.clases.WrapperMago;
import com.tecavi.net.MagoAPI;
import com.tecavi.net.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    MagoListAdapter magoListAdapter;
    List<WrapperMago> magoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        final MagoAPI magoAPI = RetrofitClient.getClient("http://hp-api.herokuapp.com/api/").create(MagoAPI.class);
        Call<ArrayList<WrapperMago>> listCall = magoAPI.loadMago();

        listCall.enqueue(new Callback<ArrayList<WrapperMago>>() {
            @Override
            public void onResponse(Call<ArrayList<WrapperMago>> call, Response<ArrayList<WrapperMago>> response) {
                if (response.isSuccessful()) {
                    Log.d("MAGO_API", "Correcto");
                    magoList = response.body();
                    drawRecycler();
                } else {
                    Log.d("MAGO_API", "Error RESPONSE: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<WrapperMago>> call, Throwable t) {
                Log.d("MAGO_API", "Error FAILURE: " + t.getMessage());
            }
        });
    }

    public void drawRecycler() {
        magoListAdapter = new MagoListAdapter(this, magoList);
        recyclerView.setAdapter(magoListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}
