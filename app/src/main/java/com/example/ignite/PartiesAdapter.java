package com.example.ignite;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class PartiesAdapter extends ArrayAdapter<Parties> {

    public PartiesAdapter(Activity context, ArrayList<Parties> parties) {
        super(context, 0, parties);
    }

    @NonNull
    @Override
    public View getView(int position, @NonNull View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_parties, parent, false);
        }

        Parties currentParty = getItem(position);

        ImageView partyIconImageView = (ImageView) listItemView.findViewById(R.id.partyIcon);
        partyIconImageView.setImageResource(currentParty.getImageResourceId());
        partyIconImageView.setVisibility(View.VISIBLE);


        TextView categoryNameTextView = (TextView) listItemView.findViewById(R.id.partyName);
        categoryNameTextView.setText(currentParty.getPartyName());

        return listItemView;
    }
}
