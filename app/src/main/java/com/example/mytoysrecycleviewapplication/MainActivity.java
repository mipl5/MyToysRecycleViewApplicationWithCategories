package com.example.mytoysrecycleviewapplication;

import static android.app.PendingIntent.getActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Toy;
import com.example.model.Toys;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvToys;
    private Toys toys;
    private ToyAdapter adapter;
    private Toolbar toolbar;

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

        initializeViews();
        getAllToys();
        setRecyclerView();
    }

    private void setRecyclerView() {
        ToyAdapter.OnItemClickListener listener = new ToyAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(Toy toy) {
                Toast.makeText(MainActivity.this, "Name: " + toy.getName(),
                        Toast.LENGTH_LONG).show();
            }
        };
        ToyAdapter.OnItemLongClickListener longListener = new ToyAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClicked(Toy toy) {
                Toast.makeText(MainActivity.this,
                        "Price: $" + String.valueOf(toy.getPrice()),
                        Toast.LENGTH_LONG).show();
                return true;
            }
        };
        adapter = new ToyAdapter(this, toys, R.layout.toy_single_layout, listener, longListener);
        rvToys.setAdapter(adapter);
        rvToys.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getAllToys() {
        toys = new Toys();
        toys.add(new Toy("Car", 50));
        toys.add(new Toy("Doll", 100));
        toys.add(new Toy("Robot", 150));
        toys.add(new Toy("Monopoly", 75));
        toys.add(new Toy("Chess", 100));
        toys.add(new Toy("Taki", 90));
    }

    private void initializeViews() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvToys = (RecyclerView)findViewById(R.id.rvToys);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (id == R.id.mnu_categories){
            Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.mnu_exit){
            finish();
            System.exit(0);
        }
        return super.onOptionsItemSelected(item);
    }
}