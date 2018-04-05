package com.domain.masterx.abnd_musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Activity showing all added artists
 */
public class ArtistActivity extends AppCompatActivity {

    private ArrayList<Artist> artists;
    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.artist_grid);

        Bundle bundle = getIntent().getExtras();
        artists = bundle.getParcelableArrayList("Artists");
        songs = bundle.getParcelableArrayList("Songs");

        sortArtists(artists);       //for showing all artists in alphabetic order

        ImageView addArtist = findViewById(R.id.add_artist);
        addArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ArtistActivity.this, R.string.no_adding_artists_toast, Toast.LENGTH_SHORT).show();
            }
        });

        ArtistAdapter adapter = new ArtistAdapter(this, artists);
        GridView gridView = findViewById(R.id.gridview);
        gridView.setAdapter(adapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Artist clickedArtist = artists.get(position);
                if (clickedArtist.hasSongs()) {
                    ArrayList<Song> artistsSongs = new ArrayList<>();
                    //adding all songs of the selected artist to artistsSongs
                    //TODO: improvable by not scanning all songs.
                    for (Song song : songs) {
                        if (song.getArtist().getArtistName().equals(clickedArtist.getArtistName())) {
                            artistsSongs.add(song);
                        }
                    }
                    Intent intent = new Intent(ArtistActivity.this, SongsActivity.class);
                    intent.putExtra("Songs", artistsSongs);
                    startActivity(intent);
                } else {
                    Toast.makeText(ArtistActivity.this, R.string.no_songs_available_toast, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList("Artists", artists);
        outState.putParcelableArrayList("Songs", songs);
        super.onSaveInstanceState(outState);
    }

    /**
     * Sorting the Artist objects by artist's name
     *
     * @param artists is the ArrayList containing the Artist objects
     */
    private void sortArtists(ArrayList<Artist> artists) {
        Collections.sort(artists, new Comparator<Artist>() {
            @Override
            public int compare(Artist a1, Artist a2) {
                return a1.getArtistName().compareTo(a2.getArtistName());
            }
        });
    }
}
