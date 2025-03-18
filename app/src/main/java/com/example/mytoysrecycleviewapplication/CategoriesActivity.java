package com.example.mytoysrecycleviewapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Categories;
import com.example.model.Category;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import michael.co.viewmodel.ToyCategoryViewModel;

public class CategoriesActivity extends AppCompatActivity {
    private RecyclerView rvCategories;
    private CategoriesAdapter adapter;
    private ToyCategoryViewModel toyCategoryViewModel;
    private Toolbar toolbar;
    private EditText etSearchCategory;
    private ImageButton ivV;
    private ImageButton ivX;
    private FloatingActionButton fabAddCategory;

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
        setupViewModel();

        setRecyclerView();
    }

    private void setRecyclerView() {
        adapter = new CategoriesAdapter(this, null, R.layout.category_single_layout);
        rvCategories.setAdapter(adapter);
        rvCategories.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupViewModel(){
        toyCategoryViewModel = new ViewModelProvider(this).get(ToyCategoryViewModel.class);
        toyCategoryViewModel.getToyCategoriesLiveData().observe(
                this, categories -> {
                    adapter.setToyCategories(categories);
                }
        );
    }

    private void initializeViews() {
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        rvCategories = (RecyclerView)findViewById(R.id.rvCategories);
        etSearchCategory = (EditText)findViewById(R.id.etSearchCategory);
        etSearchCategory.setVisibility(ConstraintLayout.GONE);
        ivV = (ImageButton)findViewById(R.id.ivV);
        ivV.setVisibility(ConstraintLayout.GONE);
        ivX = (ImageButton)findViewById(R.id.ivX);
        ivX.setVisibility(ConstraintLayout.GONE);
        fabAddCategory = (FloatingActionButton)findViewById(R.id.fabAddCategory);
        setOnClickListeners();
    }

    private void setOnClickListeners() {
        ivV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toyCategoryViewModel.add(new Category(etSearchCategory.getText().toString()));
                etSearchCategory.setText("");
            }
        });
        ivX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toyCategoryViewModel.remove(etSearchCategory.getText().toString());
            }
        });
        fabAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ivV.setVisibility(ConstraintLayout.VISIBLE);
                ivX.setVisibility(ConstraintLayout.VISIBLE);
                etSearchCategory.setVisibility(ConstraintLayout.VISIBLE);
            }
        });
    }
}
