package com.example.huynh.retrofit2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.huynh.retrofit2demo.Retrofit2.APIUtils;
import com.example.huynh.retrofit2demo.Retrofit2.DataClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text2);
        editText = findViewById(R.id.edit1);
        button = findViewById(R.id.button1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataClient dataClient = APIUtils.getData();
                Call<User> callback = dataClient.listRepos(editText.getText().toString());
                callback.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        Log.d("ABC", response.body().getName());
                        textView.setText(response.body().getName());
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.d("ABC", t.getMessage());
                    }
                });
            }
        });


    }
}
