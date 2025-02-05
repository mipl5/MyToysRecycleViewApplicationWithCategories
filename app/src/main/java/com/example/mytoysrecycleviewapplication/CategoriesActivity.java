package com.example.mytoysrecycleviewapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Categories;
import com.example.model.Category;

public class CategoriesActivity extends AppCompatActivity {
    private RecyclerView rvCategories;
    private CategoriesAdapter adapter;
    private Categories categories;
    private Toolbar toolbar;
    private EditText etSearchCategory;
    private ImageButton ivV;
    private ImageButton ivX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_categories);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializeViews();
        getAllCategories();
        setRecyclerView();
    }

    private void setRecyclerView() {
        adapter = new CategoriesAdapter(this, categories, R.layout.category_single_layout);
        rvCategories.setAdapter(adapter);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
    }

    private void getAllCategories() {
        categories = new Categories();
        categories.add(new Category("cars", "9+"));
        categories.add(new Category("dolls", "0+"));
    }

    private void initializeViews() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvCategories = (RecyclerView)findViewById(R.id.rvCategories);
        etSearchCategory = (EditText)findViewById(R.id.etSearchCategory);
        ivV = (ImageButton)findViewById(R.id.ivV);
        ivX = (ImageButton)findViewById(R.id.ivX);
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        ivV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // finds if it exists by name, not asked to do so.
            }
        });
        ivX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                etSearchCategory.setText("");
            }
        });
    }
}