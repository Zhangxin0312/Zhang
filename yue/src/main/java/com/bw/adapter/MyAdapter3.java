package com.bw.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.bean.User;
import com.example.yue.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

public class MyAdapter3 extends BaseAdapter {
    Context context;
    List<User.AAA> list2;
    public MyAdapter3(Context context, List<User.AAA> list2) {
        this.context=context;
        this.list2=list2;
    }

    @Override
    public int getCount() {
        return list2.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view1 = View.inflate(context, R.layout.aaa, null);
        ImageView  aa_iv= view1.findViewById(R.id.aa_iv);
        TextView title= view1.findViewById(R.id.title);
        TextView datea=  view1.findViewById(R.id.datea);
        ImageLoader.getInstance().displayImage(list2.get(i).url,aa_iv);
        title.setText(list2.get(i).title);
        datea.setText(list2.get(i).author_name);
        return view1;
    }
}
