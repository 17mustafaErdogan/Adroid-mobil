package com.example.frebaseinsklon;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyleViewKullanma extends RecyclerView.Adapter<RecyleViewKullanma.PostHolder>
{
    @NonNull
    @Override
    public PostHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull PostHolder holder, int position) {

    }

    @Override
    public int getItemCount() //recyleView kaçta row olacak
    {//row birkişine paylaşımlarına ait resim yazı isim vs
        return 0;
    }

    class PostHolder extends RecyclerView.ViewHolder
    {

        public PostHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
