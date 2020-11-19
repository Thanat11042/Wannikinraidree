package com.csutcc.wannikinaraidee.A08_BookTable;

import android.graphics.Color;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.csutcc.wannikinaraidee.A07_RestaurantDetail.RestaurantDetailListview;
import com.csutcc.wannikinaraidee.R;


import org.angmarch.views.NiceSpinner;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BookTable extends AppCompatActivity  implements View.OnClickListener {
TextView date1,date2,date3,date4,date5,date6,date7,date8;
Button button1,button2,button3,button4,button5;

    ListView list;
    RestaurantDetailListview adapter;
    String[] name,message;

    int[] image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a08_book_table);


        date1=findViewById(R.id.date1);
        date2=findViewById(R.id.date2);
        date3=findViewById(R.id.date3);
        date4=findViewById(R.id.date4);
        date5=findViewById(R.id.date5);
        date6=findViewById(R.id.date6);
        date7=findViewById(R.id.date7);
        date8=findViewById(R.id.date8);


        button1=findViewById(R.id.time1);
        button2=findViewById(R.id.time2);
        button3=findViewById(R.id.time3);
        button4=findViewById(R.id.time4);
        button5=findViewById(R.id.time5);


        date1.setOnClickListener(this);
        date2.setOnClickListener(this);
        date3.setOnClickListener(this);
        date4.setOnClickListener(this);
        date5.setOnClickListener(this);
        date6.setOnClickListener(this);
        date7.setOnClickListener(this);
        date8.setOnClickListener(this);


        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);


        NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.spinner_adult);
        List<String> dataset = new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5","6"));
        niceSpinner.attachDataSource(dataset);


        NiceSpinner niceSpinner2 = (NiceSpinner) findViewById(R.id.spinner_children);
        List<String> dataset2 = new LinkedList<>(Arrays.asList("1", "2", "3", "4", "5","6"));
        niceSpinner2.attachDataSource(dataset2);

        name = new String[]{ "Spicy Fried Rice &amp; Bacon Amet", "Shrimp Curry Burger Ipsam dolor Sit", "Masala Spiced Chickpeas Dolor Amet", "Kung Pao Pastrami ad Minima Sit", "Chicken Doro Wat Nisi Commodo Amet","Mango Cile Chutney Et Dolore Sit"};

        message = new String[]{ "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet", "Lorem ipsum dolor sit amet","Lorem ipsum dolor sit amet","Lorem ipsum dolor sit amet"};


        image = new int[] { R.drawable.listimg1,R.drawable.listimg2,
                R.drawable.listimg3,R.drawable.listimg4,
                R.drawable.listimg5,R.drawable.listimg6};
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

                Toast.makeText(BookTable.this,"You have selected :"+name[position], Toast.LENGTH_SHORT).show();


            }

        });



    }


   // @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.date1:
               date1.setBackgroundResource(R.drawable.ic_round_color);
                date2.setBackgroundResource(R.drawable.ic_round_nocolor);
                date3.setBackgroundResource(R.drawable.ic_round_nocolor);
                date4.setBackgroundResource(R.drawable.ic_round_nocolor);
                date5.setBackgroundResource(R.drawable.ic_round_nocolor);
                date6.setBackgroundResource(R.drawable.ic_round_nocolor);
                date7.setBackgroundResource(R.drawable.ic_round_nocolor);
                date8.setBackgroundResource(R.drawable.ic_round_nocolor);
                break;

            case R.id.date2:
                date1.setBackgroundResource(R.drawable.ic_round_nocolor);
                date2.setBackgroundResource(R.drawable.ic_round_color);
                date3.setBackgroundResource(R.drawable.ic_round_nocolor);
                date4.setBackgroundResource(R.drawable.ic_round_nocolor);
                date5.setBackgroundResource(R.drawable.ic_round_nocolor);
                date6.setBackgroundResource(R.drawable.ic_round_nocolor);
                date7.setBackgroundResource(R.drawable.ic_round_nocolor);
                date8.setBackgroundResource(R.drawable.ic_round_nocolor);



                break;
            case R.id.date3:
                date1.setBackgroundResource(R.drawable.ic_round_nocolor);
                date2.setBackgroundResource(R.drawable.ic_round_nocolor);
                date3.setBackgroundResource(R.drawable.ic_round_color);
                date4.setBackgroundResource(R.drawable.ic_round_nocolor);
                date5.setBackgroundResource(R.drawable.ic_round_nocolor);
                date6.setBackgroundResource(R.drawable.ic_round_nocolor);
                date7.setBackgroundResource(R.drawable.ic_round_nocolor);
                date8.setBackgroundResource(R.drawable.ic_round_nocolor);

                break;
            case R.id.date4:
                date1.setBackgroundResource(R.drawable.ic_round_nocolor);
                date2.setBackgroundResource(R.drawable.ic_round_nocolor);
                date3.setBackgroundResource(R.drawable.ic_round_nocolor);
                date4.setBackgroundResource(R.drawable.ic_round_color);
                date5.setBackgroundResource(R.drawable.ic_round_nocolor);
                date6.setBackgroundResource(R.drawable.ic_round_nocolor);
                date7.setBackgroundResource(R.drawable.ic_round_nocolor);
                date8.setBackgroundResource(R.drawable.ic_round_nocolor);

                break;
            case R.id.date5:
                date1.setBackgroundResource(R.drawable.ic_round_nocolor);
                date2.setBackgroundResource(R.drawable.ic_round_nocolor);
                date3.setBackgroundResource(R.drawable.ic_round_nocolor);
                date4.setBackgroundResource(R.drawable.ic_round_nocolor);
                date5.setBackgroundResource(R.drawable.ic_round_color);
                date6.setBackgroundResource(R.drawable.ic_round_nocolor);
                date7.setBackgroundResource(R.drawable.ic_round_nocolor);
                date8.setBackgroundResource(R.drawable.ic_round_nocolor);

                break;

            case R.id.date6:
                date1.setBackgroundResource(R.drawable.ic_round_nocolor);
                date2.setBackgroundResource(R.drawable.ic_round_nocolor);
                date3.setBackgroundResource(R.drawable.ic_round_nocolor);
                date4.setBackgroundResource(R.drawable.ic_round_nocolor);
                date5.setBackgroundResource(R.drawable.ic_round_nocolor);
                date6.setBackgroundResource(R.drawable.ic_round_color);
                date7.setBackgroundResource(R.drawable.ic_round_nocolor);
                date8.setBackgroundResource(R.drawable.ic_round_nocolor);

                break;


            case R.id.date7:
                date1.setBackgroundResource(R.drawable.ic_round_nocolor);
                date2.setBackgroundResource(R.drawable.ic_round_nocolor);
                date3.setBackgroundResource(R.drawable.ic_round_nocolor);
                date4.setBackgroundResource(R.drawable.ic_round_nocolor);
                date5.setBackgroundResource(R.drawable.ic_round_nocolor);
                date6.setBackgroundResource(R.drawable.ic_round_nocolor);
                date7.setBackgroundResource(R.drawable.ic_round_color);
                date8.setBackgroundResource(R.drawable.ic_round_nocolor);

                break;

            case R.id.date8:
                date1.setBackgroundResource(R.drawable.ic_round_nocolor);
                date2.setBackgroundResource(R.drawable.ic_round_nocolor);
                date3.setBackgroundResource(R.drawable.ic_round_nocolor);
                date4.setBackgroundResource(R.drawable.ic_round_nocolor);
                date5.setBackgroundResource(R.drawable.ic_round_nocolor);
                date6.setBackgroundResource(R.drawable.ic_round_nocolor);
                date7.setBackgroundResource(R.drawable.ic_round_nocolor);
                date8.setBackgroundResource(R.drawable.ic_round_color);

                break;


            case R.id.time1:
                button1.setBackgroundResource(R.drawable.roundcorner);
                button2.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button3.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button4.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button5.setBackgroundResource(R.drawable.roundcorner_nocolor);


                break;


            case R.id.time2:
                button1.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button2.setBackgroundResource(R.drawable.roundcorner);
                button3.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button4.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button5.setBackgroundResource(R.drawable.roundcorner_nocolor);


                break;


            case R.id.time3:
                button1.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button2.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button3.setBackgroundResource(R.drawable.roundcorner);
                button4.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button5.setBackgroundResource(R.drawable.roundcorner_nocolor);


                break;


            case R.id.time4:
                button1.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button2.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button3.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button4.setBackgroundResource(R.drawable.roundcorner);
                button5.setBackgroundResource(R.drawable.roundcorner_nocolor);


                break;


            case R.id.time5:
                button1.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button2.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button3.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button4.setBackgroundResource(R.drawable.roundcorner_nocolor);
                button5.setBackgroundResource(R.drawable.roundcorner);


                break;
        }
    }
}
