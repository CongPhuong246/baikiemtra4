package com.example.foldingcellwithcell;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_item);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        Adapter adapter=new Adapter();
        adapter.setData(getListItem());
        recyclerView.setAdapter(adapter);
    }

    private List<Model> getListItem(){
        List<Model> list = new ArrayList<>();
        for (int i =0; i < 20; i++){
            list.add(new Model("Title"+i,"Content"+i));
        }
        return list;
    }
}