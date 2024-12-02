package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private String title;
    private int length;

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
    
    @Override
    public void play() {
        System.out.println("Playing Track: " + title);
        System.out.println("Track length: " + length + " mins");
    }
    @Override
    public String toString() {
        return "Track: " + title + " - Length: " + length + " mins";
    }
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Track) {
            Track other = (Track) obj;
            return this.title.equalsIgnoreCase(other.getTitle()) && this.length == other.getLength();
        }
        return false;
    }
}