package com.creative.myspinner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by kelvin_lim on 21/3/18.
 */

public class CustomAdapter extends BaseAdapter{

    Context context;
    int[] categoryIcons;
    String[] categoryNames;
    LayoutInflater inflater;

    public CustomAdapter(Context context, int[] categoryIcons, String[] categoryNames) {
        this.context = context;
        this.categoryIcons = categoryIcons;
        this.categoryNames = categoryNames;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return categoryIcons.length;
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
    public View getView(int pos, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.custom_spinner_items, null);
        ImageView icon = view.findViewById(R.id.imageView);
        TextView name = view.findViewById(R.id.textView);
        icon.setImageResource(categoryIcons[pos]);
        name.setText(categoryNames[pos]);
        return view;
    }
}
