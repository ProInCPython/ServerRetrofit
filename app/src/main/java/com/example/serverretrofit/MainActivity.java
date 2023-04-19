package com.example.serverretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.serverretrofit.model.response.Character;
import com.example.serverretrofit.provider.ApiController;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ApiController controller = new ApiController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        new Thread(() -> {
            controller.incPage();
            List<Character> data = controller.GetAllCharacters();
            runOnUiThread(() -> {
                recyclerView.setAdapter(new MyAdapter(data));
            });
        }).start();

    }
}