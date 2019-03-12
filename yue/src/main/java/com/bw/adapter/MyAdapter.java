package com.bw.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bw.bean.Per;
import com.example.yue.MainActivity;
import com.example.yue.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Per> list;
    public MyAdapter(Context context, List<Per> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
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
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        int type = getItemViewType(i);
        if(convertView==null){
            switch (type){
                case 0:
                    convertView=  View.inflate(context,R.layout.first_item,null);
                    ImageView first_iv= convertView.findViewById(R.id.first_iv);
                    TextView  first_tv= convertView.findViewById(R.id.first_tv);
                    first_iv.setImageResource(list.get(i).getImg());
                    first_tv.setText(list.get(i).getName());
                    break;
                case 1:
                    convertView=  View.inflate(context,R.layout.two_item,null);
                    TextView  two_tv= convertView.findViewById(R.id.two_tv);
                    two_tv.setText(list.get(i).getName());
                    break;
            }
        }
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return list.get(position).getType();
    }
}
