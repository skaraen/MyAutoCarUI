package com.example.karaens.myautocarui;


import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CollisionListAdapter extends ArrayAdapter<CollisionStats> {
    public CollisionListAdapter(Context context, ArrayList<CollisionStats> collisions) {
        super(context, 0, collisions);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

            CollisionStats lastCollision = getItem(position);

        TextView date = (TextView) listItemView.findViewById(R.id.datecollision);
        date.setText(lastCollision.getDate());

        TextView day = (TextView) listItemView.findViewById(R.id.daycollision);
        day.setText(lastCollision.getDay());

        TextView time = (TextView) listItemView.findViewById(R.id.timecollision);
        time.setText(lastCollision.getTime());

        switch (lastCollision.getType()) {
            case "bad":
                listItemView.setBackgroundColor(Color.parseColor("#F44336"));
                break;
            case "average":
                listItemView.setBackgroundColor(Color.parseColor("#5C6BC0"));
                break;
            default:
                listItemView.setBackgroundColor(Color.parseColor("#43A047"));
                break;
        }

        return listItemView;
    }
}
