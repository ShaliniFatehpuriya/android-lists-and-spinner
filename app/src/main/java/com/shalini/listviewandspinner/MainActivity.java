package com.shalini.listviewandspinner;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView citiesListView;
    private Spinner studentsSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        citiesListView=findViewById(R.id.citiesListView);
        studentsSpinner = findViewById(R.id.studentsSpinner);

        ArrayList<String> cities=new ArrayList<>();
        cities.add("Jaipur");
        cities.add("Delhi");
        cities.add("Mumbai");
        cities.add("Kolkata");
        cities.add("Chennai");
        cities.add("Bangalore");
        ArrayList<String> studentsList = new ArrayList<>();
        studentsList.add("Ram");
        studentsList.add("Shyam");
        studentsList.add("Mohan");
        studentsList.add("Sohan");
        studentsList.add("Ramesh");
        studentsList.add("Suresh");



//        this: Refers to the current activity or context where the adapter is being created.
//        android.R.layout.simple_list_item_1: This is a built-in Android layout resource that defines a simple text view for each item in the list.
//        cities: This is your list or array of city names (strings) that you want to display in the list.

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,cities);
        citiesListView.setAdapter(arrayAdapter);
        citiesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, cities.get(position)+" Selected", Toast.LENGTH_SHORT).show();
            }
            
        });
//        ArrayAdapter<String> studentAdapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_spinner_dropdown_item,
//                studentsList
//        );
//        studentsSpinner.setAdapter(studentAdapter);
    }
}