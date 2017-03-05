package com.ahmad.mustafa.foregivness3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by ahmad on 01/03/17.
 */

public class ForegivnesAdapter extends ArrayAdapter<ForegfivnesMudel> {

    public ForegivnesAdapter(Context context, List<ForegfivnesMudel> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ForegfivnesMudel mudel = getItem(position);
        if ( convertView == null )
        {
          convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items,parent,false);
        }

        TextView forgivText = (TextView)convertView.findViewById(R.id.foregiv_item_list);
        TextView countText = (TextView)convertView.findViewById(R.id.count_item_list);

        forgivText.setText(mudel.getForgivnesType().toString());
        countText.setText(mudel.getCounterType() + "".toString());

        return convertView;
    }

}
