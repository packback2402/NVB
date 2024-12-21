package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import java.util.Iterator;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private final String artist;
    private final ArrayList<Track> tracks;

    // Constructor
    public CompactDisc(String title, String category, String artist, String director, double cost) {
        super(0, title, category, cost, director, 0);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getters
    public String getArtist() {
        return artist;
    }

    // Methods to manage tracks
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }
    
    @Override
    public void displayInfo() throws PlayerException {
        System.out.println("CD - Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Artist: " + getArtist());
        System.out.println("Director: " + getDirector());
        System.out.println("Cost: $" + getCost());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            System.err.println("Error: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        } else {
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("Artist: " + this.getArtist());

            Iterator<Track> iter = tracks.iterator();
            while (iter.hasNext()) {
                Track nextTrack = iter.next();
                try {
                    nextTrack.play(); // This may throw PlayerException if track length <=0
                } catch (PlayerException e) {
                    // If any track can't play, rethrow the exception so it can be handled outside
                    throw e;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "CD - Title: " + getTitle() +
               ", Category: " + getCategory() +
               ", Artist: " + artist +
               ", Director: " + getDirector() +
               ", Total Length: " + getLength() + " minutes" +
               ", Cost: $" + getCost();
    }
}
