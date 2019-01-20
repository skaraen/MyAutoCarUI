package com.example.karaens.myautocarui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {
    CollisionListAdapter listAdapter;
    ArrayList<CollisionStats> collisionStats;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        collisionStats= new ArrayList<>();
        ListView listView = (ListView) findViewById(R.id.list);
        collisionStats.add(new CollisionStats(13.0827,80.2707,"12 AM","bad","1/02/2003","Idkday", "50", "IDK", "20"));
        collisionStats.add(new CollisionStats(13.0827,80.2707,"12 AM","average","1/02/2003","Idkday", "50", "IDK", "10"));
        collisionStats.add(new CollisionStats(13.0827,80.2707,"12 AM","good","1/02/2003","Idkday", "50", "IDK", "10"));
        listAdapter = new CollisionListAdapter(this, collisionStats);
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                CollisionStats currentcollision = collisionStats.get(position);
                Intent intent = new Intent(ListActivity.this,CollisionStatsActivity.class);
                startActivity(intent);
            }
        });
    }


}
