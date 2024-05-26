package com.touristguide;

import static com.touristguide.TouristSiteDetail.filterByCategory;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class SiteList extends AppCompatActivity {
    private ListView listView,catView;
    private ImageButton backButton;
    private TextView placeFilter,hotelFilter,resturautFilter,filterCancel;
    ArrayList<TouristSiteDetail> touristSites = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.site_list_layout);
        listView = findViewById(R.id.site_list);
        placeFilter = findViewById(R.id.place_filter);
        hotelFilter = findViewById(R.id.hotel_filter);
        resturautFilter= findViewById(R.id.resturaut_filter);
        filterCancel= findViewById(R.id.filter_cancel);

        touristSites.add(new TouristSiteDetail(
                "Merina",
                "One of the best Hotel in the cities",
                R.drawable.hotel1,
                "Hotel"
        ));
        touristSites.add(new TouristSiteDetail(
                "place 1",
                "One of the best Hotel in the cities",
                R.drawable.place1,
                "Place"
        ));
        touristSites.add(new TouristSiteDetail(
                "place 2",
                "One of the best Hotel in the cities",
                R.drawable.place2,
                "Place"
        ));
        touristSites.add(new TouristSiteDetail(
                "Hilton",
                "One of the best Hotel in the cities",
                R.drawable.hotel2,
                "Hotel"
        ));
        touristSites.add(new TouristSiteDetail(
                "place 3",
                "One of the best Resturant in the cities",
                R.drawable.place3,
                "Place"
        ));
        touristSites.add(new TouristSiteDetail(
                "Resturant 1",
                "One of the best Resturant in the cities",
                R.drawable.r1,
                "Resturant"
        ));
        touristSites.add(new TouristSiteDetail(
                "Resturant 2",
                "One of the best Resturant in the cities",
                R.drawable.r2,
                "Resturant"
        ));
        touristSites.add(new TouristSiteDetail(
                "Suita",
                "One of the best Hotel in the cities",
                R.drawable.hotel3,
                "Hotel"
        ));
        touristSites.add(new TouristSiteDetail(
                "Resturant 3",
                "One of the best Resturant in the cities",
                R.drawable.r3,
                "Resturant"
        ));

        placeFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ArrayList<TouristSiteDetail> data = filterByCategory("Place",touristSites);
                MyAdapterSiteList adapter = new MyAdapterSiteList(SiteList.this, data);
                listView.setAdapter(adapter);
            }
        });
        resturautFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ArrayList<TouristSiteDetail> data = filterByCategory("Resturant",touristSites);
                MyAdapterSiteList adapter = new MyAdapterSiteList(SiteList.this, data);
                listView.setAdapter(adapter);
            }
        });
        hotelFilter.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                ArrayList<TouristSiteDetail> data = filterByCategory("Hotel",touristSites);
                MyAdapterSiteList adapter = new MyAdapterSiteList(SiteList.this, data);
                listView.setAdapter(adapter);
            }
        });
        filterCancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MyAdapterSiteList adapter = new MyAdapterSiteList(SiteList.this, touristSites);
                listView.setAdapter(adapter);
            }
        });
        MyAdapterSiteList adapter = new MyAdapterSiteList(this, touristSites);
        listView.setAdapter(adapter);
    }

}
