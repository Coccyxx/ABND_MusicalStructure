package com.domain.masterx.abnd_musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Custom class for storing song data
 */

public class Song implements Parcelable {         //Implementing Parcelable for passing between activities

    public static final Creator<Song> CREATOR = new Creator<Song>() {
        @Override
        public Song createFromParcel(Parcel in) {
            return new Song(in);
        }

        @Override
        public Song[] newArray(int size) {
            return new Song[size];
        }
    };
    private Artist artist;
    private String title;
    private String album;
    private int imageResourceID;
    private int duration;           //in seconds

    public Song(Artist artist, String title, String album, int imageResourceID, int duration) {
        artist.setHasSongs();
        this.artist = artist;
        this.title = title;
        this.album = album;
        this.imageResourceID = imageResourceID;
        this.duration = duration;
    }

    protected Song(Parcel in) {
        artist = in.readParcelable(Artist.class.getClassLoader());
        title = in.readString();
        album = in.readString();
        imageResourceID = in.readInt();
        duration = in.readInt();
    }


    public Artist getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getDuration() {
        int min = duration / 60;
        int secs = duration - min * 60;
        String str = String.format("%d:%02d", min, secs);
        return str;
    }

    //Parcelable interface methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(artist, flags);
        dest.writeString(title);
        dest.writeString(album);
        dest.writeInt(imageResourceID);
        dest.writeInt(duration);
    }
}
