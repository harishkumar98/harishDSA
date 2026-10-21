
import java.util.stream.IntStream;
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        int max = Math.max(word1.length(), word2.length());

        StringBuilder merged = new StringBuilder();

        IntStream.range(0, max).forEach(i -> {
            if(i < word1.length())
                merged.append(word1.charAt(i));
            if(i < word2.length())
                merged.append(word2.charAt(i));
        });
        return merged.toString();
    }
}