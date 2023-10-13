package ch.heig.dai.lab.fileio.Istomine;

import java.util.Arrays;
import java.util.stream.Stream;
import java.util.Iterator;

public class Transformer {

    private final String newName;
    private final int numWordsPerLine;

    /**
     * Constructor
     * Initialize the Transformer with the name to replace "Chuck Norris" with 
     * and the number of words per line to use when wrapping the text.
     * @param newName the name to replace "Chuck Norris" with
     * @param numWordsPerLine the number of words per line to use when wrapping the text
     */
    public Transformer(String newName, int numWordsPerLine) {
        this.newName = newName;
        this.numWordsPerLine = numWordsPerLine;
    }

    /**
     * Replace all occurrences of "Chuck Norris" with the name given in the constructor.
     * @param source the string to transform
     * @return the transformed string
     */
    public String replaceChuck(String source) {
        return  source.replace("Chuck Norris",newName);
    }

    /**
     * Capitalize the first letter of each word in the string.
     * @param source the string to transform
     * @return the transformed string
     */
    public String capitalizeWords(String source) {

        String[] words = source.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = Character.toUpperCase(word.charAt(0));
                String restOfWord = word.substring(1);
                result.append(firstChar).append(restOfWord).append(" ");
            }
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }

        return result.toString();
    }

    /**
     * Wrap the text so that there are at most numWordsPerLine words per line.
     * Number the lines starting at 1.
     * @param source the string to transform
     * @return the transformed string
     */
    public String wrapAndNumberLines(String source) {
        // Use the StringBuilder class to build the result string.

        String[] words = source.split(" ");
        StringBuilder result = new StringBuilder();
        int i = 1, y = 0, counter;

        while(true){
            result.append(i++).append(". ");
            counter = 0;
            for(;y < words.length;++y, ++counter){
                if (counter == numWordsPerLine){break;}
                result.append(words[y]).append(" ");
            }
            result.deleteCharAt(result.length()-1);
            result.append("\n");
            if(y == words.length){break;}
        }


        return result.toString();
    }
}   