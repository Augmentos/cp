import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Sharoon Babu on 21/06/22
 */

public class EncodingLength {
    public int minimumLengthEncoding(String[] words) {
        if (words == null || words.length == 0)
            return 0;

        List<String> wordList = new ArrayList<>();
        for(String word: words) {
            wordList.add(new StringBuilder(word).reverse().toString());
        }

        Collections.sort(wordList);

        int charCount = 0;
        int wordCount = 0;
        for(int i = 0; i < wordList.size(); i++) {
            if(i < wordList.size() && i + 1 < wordList.size()) {
                if (!wordList.get(i + 1).startsWith(wordList.get(i))) {
                    charCount += wordList.get(i).length();
                    wordCount++;
                }
            }

            if(i == wordList.size() - 1) {
                charCount += wordList.get(i).length();
                wordCount++;
            }
        }

        return charCount + wordCount;
    }


    public static void main(String[] args) {
        EncodingLength encodingLength = new EncodingLength();
        System.out.println(encodingLength.minimumLengthEncoding(new String[]{"feipyxx","e"}));
        //em, emit, lebb
    }
}
