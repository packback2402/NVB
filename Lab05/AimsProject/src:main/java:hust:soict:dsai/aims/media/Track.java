package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class Track {
    private final String title;
    private final int length;

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length + " minutes");
        } else {
            System.err.println("Error: Track length is non-positive!");
            throw new PlayerException("ERROR: Track Length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        // Just a reminder that equals might already exist; if you need it, implement similarly to Media
        return super.equals(obj);
    }
}
