package com.domain.masterx.abnd_musicalstructure;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Intent intent;
    private ArrayList<Artist> artists;
    private ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        artists=new ArrayList();
        songs=new ArrayList();

        introAnimation();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                intent=new Intent(MainActivity.this, ArtistActivity.class);
                intent.putExtra("Artists", artists);
                intent.putExtra("Songs", songs);
                startActivity(intent);
                finish();   //by this the MainActivity is destroyed and cannot be reached by the back button anymore
            }
        }, 4000);   //ArtistActivity is started after a delay of 4 seconds

        fetchData();
    }

    /**
     * Shows an intro animation while fetching the data
     */
    private void introAnimation() {
        ImageView startImage = findViewById(R.id.start_image);
        Animation myFadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fadein);
        startImage.startAnimation(myFadeInAnimation);
    }

    /**
     * Fetching the data
     *
     * Atm the data are generated in place, but method can be revised to get data from another data
     * source such as database or from scanning the device.
     * (As these data are rather for demonstration than for real usage extracting to strings.xml was not done)
     *
     */
    private void fetchData() {
        artists.add(new Artist("Annen May Kantereit",R.drawable.amk));
        songs.add(new Song(artists.get(0), "Oft gefragt","Alles nix konkretes", R.drawable.amk_alles_nix_konkretes, 192));
        songs.add(new Song(artists.get(0), "Pocahontas","Alles nix konkretes", R.drawable.amk_alles_nix_konkretes, 185));
        songs.add(new Song(artists.get(0), "Es geht mir gut","Alles nix konkretes", R.drawable.amk_alles_nix_konkretes, 161));
        songs.add(new Song(artists.get(0), "Mir wär' lieber, du weinst","Alles nix konkretes", R.drawable.amk_alles_nix_konkretes, 197));
        songs.add(new Song(artists.get(0), "What He Wanted The Most (Live)","AnnenMayKantereit & Freunde (Live In Berlin)", R.drawable.amk_berlin, 233));

        artists.add(new Artist("Eminen", R.drawable.eminem));
        artists.add(new Artist("And You Will Know Us by the Trail of Dead",R.drawable.atwnubtdot));
        artists.add(new Artist("Ed Sheeran", R.drawable.ed_sheeran));
        artists.add(new Artist("John Lennon",R.drawable.john_lennon));
        artists.add(new Artist("David Bowie",R.drawable.david_bowie));
        artists.add(new Artist("Ill Twin",R.drawable.ill_twin));

        songs.add(new Song(artists.get(6), "Charlies","Made By Devil", R.drawable.ill_twin_made_by_devil, 172));
        songs.add(new Song(artists.get(6), "Poor Me","Made By Devil", R.drawable.ill_twin_made_by_devil, 227));
        songs.add(new Song(artists.get(6), "Charlies","Made By Devil", R.drawable.ill_twin_made_by_devil, 172));
        songs.add(new Song(artists.get(6), "Poor Me","Made By Devil", R.drawable.ill_twin_made_by_devil, 227));
        songs.add(new Song(artists.get(6), "Here It Comes","Made By Devil", R.drawable.ill_twin_made_by_devil, 143));
        songs.add(new Song(artists.get(6), "Big Change","Made By Devil", R.drawable.ill_twin_made_by_devil, 231));
        songs.add(new Song(artists.get(6), "Out There","Made By Devil", R.drawable.ill_twin_made_by_devil, 159));
        songs.add(new Song(artists.get(6), "Stay Cool","Made By Devil", R.drawable.ill_twin_made_by_devil, 259));
        songs.add(new Song(artists.get(6), "Hear Me","Made By Devil", R.drawable.ill_twin_made_by_devil, 243));
        songs.add(new Song(artists.get(6), "Better Without You","Made By Devil", R.drawable.ill_twin_made_by_devil, 179));
        songs.add(new Song(artists.get(6), "Made By Devil","Made By Devil", R.drawable.ill_twin_made_by_devil, 161));
        songs.add(new Song(artists.get(6), "White Labor Rat","Made By Devil", R.drawable.ill_twin_made_by_devil, 241));
        songs.add(new Song(artists.get(6), "Don't Need Much","Made By Devil", R.drawable.ill_twin_made_by_devil, 302));
        songs.add(new Song(artists.get(6), "Sms","Made By Devil", R.drawable.ill_twin_made_by_devil, 202));
        songs.add(new Song(artists.get(6), "Whiskey","Made By Devil", R.drawable.ill_twin_made_by_devil, 146));
        songs.add(new Song(artists.get(6), "My Addiction","Made By Devil", R.drawable.ill_twin_made_by_devil, 198));
        songs.add(new Song(artists.get(6), "I Want You Maybe","Made By Devil", R.drawable.ill_twin_made_by_devil, 189));
        songs.add(new Song(artists.get(6), "Bad For You","Made By Devil", R.drawable.ill_twin_made_by_devil, 216));

        artists.add(new Artist("Beirut",R.drawable.beirut));
        songs.add(new Song(artists.get(7), "The Gulag Orkestar", "The Gulag Orkestar", R.drawable.beirut_gulagorkestar, 278));
        songs.add(new Song(artists.get(7), "Prenzlauerberg", "The Gulag Orkestar", R.drawable.beirut_gulagorkestar, 226));
        songs.add(new Song(artists.get(7), "A Candle’s Fire", "The Rip Tide", R.drawable.beirut_gulagorkestar, 198));
        songs.add(new Song(artists.get(7), "Santa Fe",  "The Rip Tide", R.drawable.beirut_riptide, 233));
        songs.add(new Song(artists.get(7), "East Harlem", "The Rip Tide", R.drawable.beirut_riptide, 188));
    }
}
