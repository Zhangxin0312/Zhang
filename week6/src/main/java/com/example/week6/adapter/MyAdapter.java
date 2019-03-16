package com.example.week6.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.week6.R;
import com.example.week6.bean.User;
import com.example.week6.v.ShowActivity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    List<User.AAA> mlist;
    Context context;
    public MyAdapter(List<User.AAA> mlist, Context context) {
        this.mlist=mlist;
        this.context=context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.item, null);
        return   new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int i) {
         holder.title.setText(mlist.get(i).news_title);
        Glide.with(context).load(mlist.get(i).pic_url).into(holder.iv);
    }

    @Override
    public int getItemCount() {
      //  Log.e("sss",mlist.size()+"");
        return mlist.size();
    }

    public  class Holder extends  RecyclerView.ViewHolder{
           ImageView iv;
           TextView title;
           public Holder(@NonNull View itemView) {
               super(itemView);
              iv=  itemView.findViewById(R.id.iv);
               title=  itemView.findViewById(R.id.title);
           }
       }
}
