package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hitApi();

    }

    public void hitApi()
    {
        Auth apiInterface = tempclient.getInstance();
        Call<Pojo> call=apiInterface.getRandom("Karan is best");
        call.enqueue(
                new Callback<Pojo>() {
                    @Override
                    public void onResponse(Call<Pojo> call, Response<Pojo> response) {
                        if(response.isSuccessful())
                        {
                            if(response!=null)
                            {
                                Log.d(TAG, "onResponse: "+ response.body().getPrediction());
                            }
                        }

                    }

                    @Override
                    public void onFailure(Call<Pojo> call, Throwable t) {
                        Log.d(TAG, "onFailure: "+t.getMessage());

                    }
                }
        );


    }
}
