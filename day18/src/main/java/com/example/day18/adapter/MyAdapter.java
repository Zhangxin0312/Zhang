package com.example.day18.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.day18.R;
import com.example.day18.bean.Product;
import com.example.day18.v.MainActivity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder> {
    Context  context;
    List<Product.DataBean> mlist;
    private TwoAdapter adapter1;
    MainActivity activity;

    public MyAdapter(Context  context, List<Product.DataBean> mlist) {
        this.context=context;
        this.mlist=mlist;
        activity= (MainActivity) context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.my_item, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, final int i) {
         holder.name.setText(mlist.get(i).getSellerName());

        LinearLayoutManager layoutManager=new LinearLayoutManager(context);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
         holder.recycler.setLayoutManager(layoutManager);
         holder.cb.setChecked(mlist.get(i).isFlag());
        adapter1 = new TwoAdapter(context,mlist.get(i).getList());
         holder.recycler.setAdapter(adapter1);
         holder.cb.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 activity.CheckWai(i,-1,holder.cb.isChecked());
             }
         });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public  class Holder extends  RecyclerView.ViewHolder{
        TextView name;
        CheckBox cb;
        RecyclerView recycler;
        public Holder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            cb=itemView.findViewById(R.id.cb);
            recycler=itemView.findViewById(R.id.recycler);
        }
    }
}
