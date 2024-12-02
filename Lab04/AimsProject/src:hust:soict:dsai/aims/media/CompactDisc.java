package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    public CompactDisc(String title, String category, float cost, String artist, int length, String director) {
        super(title, category, cost, length, director);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
            System.out.println("Added: " + track.getTitle());
        } else {
            System.out.println("Track " + track.getTitle() + " already exists in the CD.");
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track " + track.getTitle() + " is not in the CD.");
        }
    }

    public int getTotalLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    @Override
    public void play() {
        System.out.println("Playing CompactDisc: " + getTitle());
        System.out.println("Artist: " + getArtist());
        System.out.println("CD length: " + getTotalLength() + " mins");
        
        for (Track track : tracks) {
            track.play();
        }
    }
    @Override
    public String toString() {
        return "CompactDisc - " + getTitle() + " - " + getCategory() + " - Artist: " + getArtist() +
                " - Director: " + getDirector() + " - Total Length: " + getTotalLength() + " mins - Cost: $"
                + getCost();
    }
    @Override
    public void displayInfo() {
        System.out.println("CompactDisc - " + getTitle() + " - " + getCategory() + " - Artist: " + artist
                + " - Director: " + getDirector() + " - Total Length: " + getTotalLength() + " mins - Cost: $"
                + getCost());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            System.out.println("\t" + track.toString());
        }
    }
}