package com.example.classroom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends Activity implements MyAdapter.OnItemsListener {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<String> myDataset;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        myDataset = new ArrayList<String>();
        myDataset.add("Agustin Krebs");
        myDataset.add("Jose Bennedeto");
        myDataset.add("Juan Perez");
        myDataset.add("Camila Cabello");
        myDataset.add("Ricky Martin");
        myDataset.add("Juan Manuel Astorga");
        myDataset.add("Gary Medel");
        myDataset.add("Alexis Sanchez");
        myDataset.add("Lionel Messi");
        myDataset.add("Steve Jobs");
        myDataset.add("Kendric Lamar");

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //recyclerView.setHasFixedSize(true);

        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(myDataset, this);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onItemClick: clicked");
        //myDataset.get(position);
        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra("selected item", myDataset.get(position));
        startActivity(intent);
    }
    // ...
}
