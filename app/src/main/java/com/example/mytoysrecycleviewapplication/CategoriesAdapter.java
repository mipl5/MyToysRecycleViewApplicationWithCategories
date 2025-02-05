package com.example.mytoysrecycleviewapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Categories;
import com.example.model.Category;
import com.example.model.Toy;
import com.example.model.Toys;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder>{
    private Context context;
    private Categories categories;
    private int single_layout;
    public CategoriesAdapter(Context context, Categories categories, int single_layout){
        this.context = context;
        this.categories = categories;
        this.single_layout = single_layout;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(single_layout, parent, false);
        return new CategoryViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        Category category = categories.get(position);

        if (category != null){
            holder.bind(category);
        }
    }

    @Override
    public int getItemCount() {
        return (categories == null) ? 0 : categories.size(); //return 0;
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        private TextView tvAgeRange;
        private ImageView ivPicture;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAgeRange = itemView.findViewById(R.id.tvAgeRange);
            ivPicture = itemView.findViewById(R.id.ivPicture);
        }

        public void bind(Category category){
            tvName.setText(String.valueOf(category.getName()));
            tvAgeRange.setText(String.valueOf(category.getAgeRange()));
        }
    }
}
