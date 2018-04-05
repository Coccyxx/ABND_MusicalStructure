package com.domain.masterx.abnd_musicalstructure;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Activity showing the current selected song
 */

public class PlayingActivity extends AppCompatActivity implements View.OnClickListener {

    private Song currentSong;
    private Artist currentArtist;
    private ArrayList<Song> artistsSongs;
    private int position;
    private int songsNumber;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        Bundle bundle = getIntent().getExtras();
        artistsSongs =bundle.getParcelableArrayList("Songs");
        position = bundle.getInt("SONG_POSITION");
        songsNumber = artistsSongs.size();
        currentSong = artistsSongs.get(position);
        currentArtist = currentSong.getArtist();
        updateSong();

        ImageButton nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(this);
        ImageButton previousButton = findViewById(R.id.previous_button);
        previousButton.setOnClickListener(this);
        ImageButton playButton = findViewById(R.id.play_button);
        playButton.setOnClickListener(this);
        ImageButton restartButton = findViewById(R.id.restart_button);
        restartButton.setOnClickListener(this);
        ImageButton stopButton = findViewById(R.id.stop_button);
        stopButton.setOnClickListener(this);
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(this);
        ImageView home = findViewById(R.id.home);
        home.setOnClickListener(this);

        SeekBar seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(PlayingActivity.this, R.string.not_implemented, Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * Update all displayed data of the current song
     */
    private void updateSong() {
        TextView tv;
        tv = findViewById(R.id.artist_playing);
        tv.setText(currentArtist.getArtistName());
        tv = findViewById(R.id.song_playing);
        tv.setText(getString(R.string.playing_song_number, (position + 1), songsNumber));
        tv = findViewById(R.id.song);
        tv.setText(currentSong.getTitle());
        tv = findViewById(R.id.album);
        tv.setText(currentSong.getAlbum());
        tv = findViewById(R.id.artist);
        tv.setText(currentArtist.getArtistName());
        tv = findViewById(R.id.current_time);
        tv.setText(R.string.start_time);
        tv = findViewById(R.id.total_time);
        tv.setText(currentSong.getDuration());

        ImageView titleImage = findViewById(R.id.album_image);
        titleImage.setImageResource(currentSong.getImageResourceID());
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.next_button:
                nextSong();
                break;
            case R.id.previous_button:
                previousSong();
                break;
            case R.id.play_button:
                playSong();
                break;
            case R.id.restart_button:
                restartSong();
                break;
            case R.id.stop_button:
                stopSong();
                break;
            case R.id.back:
                intent = new Intent(PlayingActivity.this, SongsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                break;
            case R.id.home:
                intent = new Intent(PlayingActivity.this, ArtistActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
        }
    }

/* OnClick methods:*/

    private void nextSong() {
        position = (position < songsNumber - 1) ? position + 1 : 0;
        currentSong = artistsSongs.get(position);
        updateSong();
    }

    private void previousSong() {
        position = (position > 0) ? position - 1 : songsNumber - 1;
        currentSong = artistsSongs.get(position);
        updateSong();
    }

    private void playSong() {
        Toast.makeText(PlayingActivity.this, R.string.not_implemented, Toast.LENGTH_SHORT).show();
    }

    private void restartSong() {
        Toast.makeText(PlayingActivity.this, R.string.not_implemented, Toast.LENGTH_SHORT).show();
    }

    private void stopSong() {
        Toast.makeText(PlayingActivity.this, R.string.not_implemented, Toast.LENGTH_SHORT).show();
    }
}
