
// Author: Violette Augustin Similien
// Class: CS342
// Assignement 3
// Subject: Binary Tree
// Due date: 5/7/2019
// Prof: Vic Berry
// DriverTree class
// import Libraries for text reader and regex to downdload and filter the text
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList; // import theArrayList class to count Distinct Words

public class DriverTree {

    public static void main(String[] args) {

        // Instantiate an object of the binary tree.
        BinaryT bt = new BinaryT();

        String words = null;
        int reviewedWordsCounter = 0;  // The counter for the reviewed words.
        int comparison = 1;     // Variable to compare a currently being added word to already added ones.
        int isDuplicate = 1;    // Variable to mark currently added words as duplicates
        ArrayList<String> distinctWords = new ArrayList<String>(); // Create an ArrayList object for Distinct Words
        // Using "try catch" to parse the text. 
        try {
            BufferedReader br = new BufferedReader(new FileReader("Dracula.txt"));
            StringBuilder sb = new StringBuilder();
            String line = null;

            //While loop to read all lines
            while ((line = br.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                Pattern p = Pattern.compile("\\S+");
                Matcher m = p.matcher(line);

                while (m.find()) {
                    words = line.substring(m.start(), m.end());
                    //Using regex to remove Characteres and capital letters
                    words = words.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().replaceAll("^( )+", "");
                    // Add words (except empty strings) to the binary tree.
                    if (words.compareTo("") != 0) {
                        bt.add(words);
                    }

                    /**
                     * Count Distinct Words
                     */
                    // Add the first word to the arrayList for count.
                    if (reviewedWordsCounter == 0) {
                        distinctWords.add(words);
                    }
                    // Identify if the word is not a duplicate before adding to the array.
                    if (reviewedWordsCounter > 0) {
                        comparison = 1;
                        isDuplicate = 1;
                        for (int i = 0; i < distinctWords.size(); i++) {
                            comparison = words.compareTo(distinctWords.get(i)); // if "isDuplicate" = 0 then the duplicate was found in arrayList
                            if (comparison == 0) {
                                isDuplicate = 0;
                            }
                        }
                    }
                    // Increment reviewed amt of words to add to arrayList.
                    reviewedWordsCounter++;
                    // Add the rest of the unique words (except empty strings) to the arrayList.
                    if (words.compareTo("") != 0 && reviewedWordsCounter > 0 && isDuplicate != 0) {
                        distinctWords.add(words);
                    }
                }

            }
            br.close();
        } catch (IOException e) {

            e.printStackTrace();
        }

        // How many total words are in the book?
        System.out.println("Text contains " + bt.getSize() + " Total words.");

        // What word is at the root of the tree?
        System.out.println("Word at root is        : " + bt.wordInRoot());

        // How many time do the following words apear in the text?
        if (bt.search("transylvania")) {
            System.out.println("transylvania occurs    : " + (bt.foundNode.copies + 1) + " times");
        }
        if (bt.search("harker")) {
            System.out.println("harker occurs          : " + (bt.foundNode.copies + 1) + " times");
        }
        if (bt.search("renfield")) {
            System.out.println("renfield occurs        : " + (bt.foundNode.copies + 1) + " times");
        }
        if (bt.search("vampire")) {
            System.out.println("vampire occurs         : " + (bt.foundNode.copies + 1) + " times");
        }
        if (bt.search("expostulate")) {
            System.out.println("expostulate occurs     : " + (bt.foundNode.copies + 1) + " times");
        }

        if (bt.search("fang")) {
            System.out.println("fang occurs            : " + (bt.foundNode.copies + 1) + " times");
        } else {
            System.out.println("fang occurs            : " + 0 + " times");
        }

        // How many different words are there in the book?
        System.out.println("Tree contains          : " + distinctWords.size() + " distinct words");

        // Which word(s) are at the deepest leavs in the tree?
        System.out.println("Deepest word(s) is/are : " + bt.deepestNode());

        // What is the depth of the tree?   
        System.out.println("Tree is                : " + bt.getDepth() + " nodes deep");

        // Which word accurs most frequently.
        System.out.println("Most frequent is       : " + bt.mostFrequent());

        // Display first 20 words in a Pre-Order Traversal of the tree.
        System.out.print("First 20 words pre order word : ");
        bt.preOrder();

        // Display first 20 words in a Post-Order Traversal of the tree.
        System.out.print("First 20 words post order word: ");
        bt.postOrder();

        // Display first 20 words in a In-Order Traversal of the tree.
        System.out.print("First 20 words in order word  : ");
        bt.inOrder();
    }
}
