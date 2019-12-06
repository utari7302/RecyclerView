package com.samt.recyclerviewimplementation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    //Describe how the data is present.Perform Vertically or Horizontally Scrolling on Recycler View
    RecyclerView.LayoutManager layoutManager;
    //To give access of MyAdapter Class to perform
    RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView) findViewById(R.id.recyclerView);

        //Means Your App is not Dynamically Updated mostly used in Offline apps.
        recyclerView.setHasFixedSize(true);
        //Create Layout Manager Object
        layoutManager=new LinearLayoutManager(getApplicationContext());
        //To set scrolling in Recycler View
        recyclerView.setLayoutManager(layoutManager);

        //Create data to show in the Recycler View List
        //Create Dummy Data list
        List<String> input=new ArrayList<>();
        for (int i=0;i<50;i++)
        {
            //To Add data in list use add()
            input.add("SAMT PRACTICE" +i);
        }
        //Imporatant thing is that all the data is transfer to Adapter(Play the role of middle man/Bridge)
        //Make the class of Adapter

        //In this statement the parametrized constructor
        //of MyAdapter class in which, pass the list of data and assing the objecct of MyAdapter class
        mAdapter=new MyAdapter(input);
        //Used to set the data in Recycler list
        recyclerView.setAdapter(mAdapter);
    }
}
