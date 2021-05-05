package com.example.firebaseilkuygulamas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecylerAdapdor extends RecyclerView.Adapter<RecylerAdapdor.gönriHolder>
{
    private ArrayList<String> email;
    private ArrayList<String> dowloadUrl;
    private ArrayList<String> comment;

    public RecylerAdapdor(ArrayList<String> email ,ArrayList<String> dowloadURL ,ArrayList<String> yorum)
    {
        this.email = email;
        this.dowloadUrl = dowloadURL;
        this.comment = yorum;
    }



    @NonNull
    @Override
    public gönriHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {//asıl bağlama işi burada oluyor recykle_row.xml ile
        //menüler nasıl inflater ile bğlanıyorsa bu ile o xml doysanı da o matıkla bağlanır LayoutInflater

        LayoutInflater layoutBağlayıcı = LayoutInflater.from(parent.getContext());//paranet nerede ise onun contexsini al
        View view =layoutBağlayıcı.inflate(R.layout.recykle_row,parent,false);//normal parenta bağlam için false denildi
        //eğer oyrı bir roota bağlamak isteniyora true deniliyor

        return new gönriHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull gönriHolder holder, int position)
    {//porgram çalışrıken örneğin TexView da ne olacak
        holder.userComment.setText(comment.get(position));
        holder.userEmail.setText(email.get(position));
        Picasso.get().load(dowloadUrl.get(position)).into(holder.görsel);

    }

    @Override
    public int getItemCount() //kaçtane row olacağını
    {
        return email.size();
    }

    class gönriHolder extends RecyclerView.ViewHolder//görünümlerin tutlduğu yer
    {
        ImageView görsel;
        TextView userEmail;
        TextView userComment;

        public gönriHolder(@NonNull View itemView)
        {
            super(itemView);

            görsel = itemView.findViewById(R.id.imageView);
            userEmail = itemView.findViewById(R.id.userEmailText);
            userComment = itemView.findViewById(R.id.userCommentText);
            //böylelik muhatap belirledi "recykle_row.xml" yani bağlatı kuruldu
        }
    }

}
