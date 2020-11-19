package com.csutcc.wannikinaraidee.A07_RestaurantDetail;

import android.graphics.Point;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.ahmadrosid.lib.drawroutemap.DrawMarker;
import com.ahmadrosid.lib.drawroutemap.DrawRouteMaps;
import com.csutcc.wannikinaraidee.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;


public class RestaurantDetailView extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    ListView list,list2;
    RestaurantDetailListview adapter;
    RestaurantDetailListview2 adapter2;
    String[] name,message,title,time,content;

    int[] image,images;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a07_restaurant_detail_view);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        name = new String[]{ "Spicy Fried Rice &amp; Bacon Amet", "Shrimp Curry Burger Ipsam dolor Sit", "Masala Spiced Chickpeas Dolor Amet", "Kung Pao Pastrami ad Minima Sit", "Chicken Doro Wat Nisi Commodo Amet","Mango Cile Chutney Et Dolore Sit"};

        message = new String[]{ "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet","Lorem ipsum dolor sit amet","Lorem ipsum dolor sit amet"};


        image = new int[] { R.drawable.listimg1,R.drawable.listimg2,
                R.drawable.listimg3,R.drawable.listimg4,
                R.drawable.listimg5,R.drawable.listimg6};

        title = new String[]{ "Shagor Doe","Zahid Doe","Rakib Smith"};

        content = new String[]{ "Amorim ipsum dolor sit amet, consectetur adipiscing elit. Cras vitae nibh nisl. Cras etitikis mauris eget lorem ultricies ferme ntum a inti diam. ","Amorim ipsum dolor sit amet, consectetur adipiscing elit. Cras vitae nibh nisl. Cras etitikis mauris eget lorem ultricies ferme ntum a inti diam. ","Amorim ipsum dolor sit amet, consectetur adipiscing elit. Cras vitae nibh nisl. Cras etitikis mauris eget lorem ultricies ferme ntum a inti diam. "};

        time = new String[]{ "2  hours ago","3 hours ago","4 hours ago"};

        images = new int[] { R.drawable.pic2,R.drawable.pic3,
                R.drawable.pic4};



        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.mylist);

        // Pass results to ListViewAdapter Class
        adapter = new RestaurantDetailListview(this, name,message,image);
        // Binds the Adapter to the ListView
        list.setAdapter(adapter);
        // Capture ListView item click
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(RestaurantDetailView.this,"You have selected :"+name[position], Toast.LENGTH_SHORT).show();


            }

        });


        list2 = (ListView) findViewById(R.id.mylist2);

        // Pass results to ListViewAdapter Class
        adapter2 = new RestaurantDetailListview2(this, title,time,content,image);
        // Binds the Adapter to the ListView
        list2.setAdapter(adapter2);
        // Capture ListView item click
        list2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Toast.makeText(RestaurantDetailView.this,"You have selected :"+title[position], Toast.LENGTH_SHORT).show();


            }

        });

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng origin = new LatLng(-7.788969, 110.338382);
        LatLng destination = new LatLng(-7.781200, 110.349709);
        DrawRouteMaps.getInstance(this)
                .draw(origin, destination, mMap);
        DrawMarker.getInstance(this).draw(mMap, origin, R.drawable.marker_a, "Origin Location");
        DrawMarker.getInstance(this).draw(mMap, destination, R.drawable.marker_b, "Destination Location");

        LatLngBounds bounds = new LatLngBounds.Builder()
                .include(origin)
                .include(destination).build();
        Point displaySize = new Point();
        getWindowManager().getDefaultDisplay().getSize(displaySize);
        mMap.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, displaySize.x, 250, 30));
    }
}