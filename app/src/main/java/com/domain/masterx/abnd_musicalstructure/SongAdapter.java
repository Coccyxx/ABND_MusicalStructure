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
 * Custom Adapter to populate a list layout with views based on instances of the Song class.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.song_list_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView tv;
        tv = listItemView.findViewById(R.id.album);
        tv.setText(currentSong.getAlbum());
        tv = listItemView.findViewById(R.id.title);
        tv.setText(currentSong.getTitle());
        tv = listItemView.findViewById(R.id.duration);
        tv.setText(currentSong.getDuration());

        ImageView imageView = listItemView.findViewById(R.id.image_view);
        imageView.setImageResource(currentSong.getImageResourceID());

        return listItemView;
    }

}
