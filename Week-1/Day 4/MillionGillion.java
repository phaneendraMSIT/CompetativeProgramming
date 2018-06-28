import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class MillionGillion {

    // implement a trie and use it to efficiently store string
    static ArrayList<String> WordList = new ArrayList<>();
    static class Trie {
    	
        public boolean addWord(String word) {
        	if(WordList.contains(word))
        	{
        		return false;
        	}
        	else {
        		WordList.add(word);
        		return true;
        	}
            
        }
    }


















    // tests

    @Test
    public void trieTest() {
        final Trie trie = new Trie();

        boolean result = trie.addWord("catch");
        assertTrue(result);

        result = trie.addWord("cakes");
        assertTrue(result);

        result = trie.addWord("cake");
        assertTrue(result);

        result = trie.addWord("cake");
        assertFalse(result);

        result = trie.addWord("caked");
        assertTrue(result);

        result = trie.addWord("catch");
        assertFalse(result);

        result = trie.addWord("");
        assertTrue(result);

        result = trie.addWord("");
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MillionGillion.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}