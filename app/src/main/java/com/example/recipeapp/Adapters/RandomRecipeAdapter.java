package com.example.recipeapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recipeapp.Models.Recipe;
import com.example.recipeapp.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RandomRecipeAdapter extends RecyclerView.Adapter<RandomRecipeViewHolder>{

Context context;
List<Recipe> list;

    public RandomRecipeAdapter(Context context, List<Recipe> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RandomRecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RandomRecipeViewHolder(LayoutInflater.from(context).inflate(R.layout.list_random_recipes,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RandomRecipeViewHolder holder, int position) {
        holder.text_view_title.setText(list.get(position).title);
        holder.text_view_title.setSelected(true);
holder.textview_like.setText(list.get(position).aggregateLikes+"likes");
        holder.textview_persons.setText(list.get(position).servings+"servings");
        holder.textview_time.setText(list.get(position).readyInMinutes+"minutes");
        Picasso.get().load(list.get(position).image).into(holder.image_view_food);




    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
class RandomRecipeViewHolder extends RecyclerView.ViewHolder {

CardView random_recipe_container;
TextView text_view_title, textview_like, textview_persons, textview_time;
ImageView image_view_food;
    public RandomRecipeViewHolder(@NonNull View itemView) {
        super(itemView);
        random_recipe_container=itemView.findViewById(R.id.random_recipe_container);
        text_view_title=itemView.findViewById(R.id.text_view_title);
        textview_like=itemView.findViewById(R.id.textview_like);
        textview_persons=itemView.findViewById(R.id.textview_persons);
        textview_time=itemView.findViewById(R.id.textview_time);
        image_view_food=itemView.findViewById(R.id.image_view_food);
    }
}











