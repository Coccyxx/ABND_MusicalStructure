package com.domain.masterx.abnd_musicalstructure;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Activity showing all songs of the selected artist
 */
public class SongsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);

        final ArrayList<Song> artistsSongs=getIntent().getExtras().getParcelableArrayList("Songs");

        TextView titleBar=findViewById(R.id.title);
        titleBar.setText(artistsSongs.get(0).getArtist().getArtistName());
        ImageView titleImage=findViewById(R.id.title_image);
        titleImage.setImageResource(artistsSongs.get(0).getArtist().getImageResourceId());
        ImageView homeButton=findViewById(R.id.home);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        SongAdapter adapter=new SongAdapter(this, artistsSongs);
        ListView listView=findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(SongsActivity.this, PlayingActivity.class);
                intent.putExtra("Songs", artistsSongs);
                intent.putExtra("SONG_POSITION", position);
                startActivity(intent);
            }
        });
    }
}
