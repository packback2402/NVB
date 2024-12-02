package hust.soict.globalict.garbage;

import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
    public static void main(String[] args) throws Exception {
        String filename = "hust/soict/globalict/garbage/largefile.txt"; // File văn bản lớn
        byte[] inputBytes = Files.readAllBytes(Paths.get(filename));
        long startTime = System.currentTimeMillis();

        StringBuilder outputBuilder = new StringBuilder();
        for (byte b : inputBytes) {
            outputBuilder.append((char) b);
        }
        @SuppressWarnings("unused")
        String outputString = outputBuilder.toString();

        long endTime = System.currentTimeMillis();
        System.out.println("Time taken with StringBuilder: " + (endTime - startTime) + " ms");
    }
}
