package com.domain.masterx.abnd_musicalstructure;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Custom class for storing artist data
 */

public class Artist implements Parcelable {   //Implementing Parcelable for passing between activities

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };
    private String artist;
    private int imageResourceId;
    private boolean songsAvailable;

    public Artist(String artist, int imageResourceId) {
        this.artist = artist;
        this.imageResourceId = imageResourceId;
    }

    protected Artist(Parcel in) {
        artist = in.readString();
        imageResourceId = in.readInt();
        songsAvailable = in.readByte() != 0;
    }

    public String getArtistName() {
        return artist;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public boolean hasSongs() {
        return songsAvailable;
    }

    public void setHasSongs() {
        songsAvailable = true;
    }


    //Parcelable interface methods
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(artist);
        dest.writeInt(imageResourceId);
        dest.writeByte((byte) (songsAvailable ? 1 : 0));
    }
}
