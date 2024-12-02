package hust.soict.dsai.aims.media;

import java.util.Comparator;

public class CompareByTitleThenCost implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int titleComparison = media1.getTitle().compareToIgnoreCase(media2.getTitle());
        if (titleComparison != 0) {
            return titleComparison;
        }
        return Float.compare(media1.getCost(), media2.getCost());
    }
}