package com.domain.masterx.abnd_musicalstructure;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Custom Adapter to populate a grid layout with views based on instances of the Artist class.
 */

public class ArtistAdapter extends ArrayAdapter<Artist> {

    private Context context;

    public ArtistAdapter(Context context, ArrayList<Artist> artists) {
        super(context, 0, artists);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(R.layout.artist_grid_item, parent, false);
        }

        Artist currentArtist = getItem(position);

        TextView tv = gridItemView.findViewById(R.id.artist);
        tv.setText(currentArtist.getArtistName());
        //Setting artist name color depending on songs availability
        if (currentArtist.hasSongs()) {
            tv.setTextColor(context.getResources().getColor(R.color.colorBlack));
        } else {
            tv.setTextColor(context.getResources().getColor(R.color.colorGray));
        }

        ImageView imageView = gridItemView.findViewById(R.id.artist_image);
        imageView.setImageResource(currentArtist.getImageResourceId());

        return gridItemView;
    }

}
