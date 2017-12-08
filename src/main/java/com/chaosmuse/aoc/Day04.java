package com.chaosmuse.aoc;

import java.util.*;

public class Day04 {

    public int partOne(String input) {

        int validCount = 0;
        String[] phrases = input.split("\n");

        for (String words : phrases) {
            Set<String> wordMap = new HashSet<>();
            boolean match = true;
            for (String word : words.split(" ")) {
                if (wordMap.contains(word)) {
                    // duplicate found! abort
                    match = false;
                    break;
                } else {
                    wordMap.add(word);
                }
            }

            if (match) {
                validCount++;
            }
        }

        return validCount;
    }

    public int partTwo(String input) {
        int validCount = 0;

        String[] phrases = input.split("\n");

        for(String words : phrases) {
            boolean match = false;
            Map<Integer, String> wordHashes = new HashMap<>();
            for(String word : words.split(" ")) {
                int wordHash = calculateWordHash(word);
                if(wordHashes.containsKey(wordHash)) {
                    System.out.println("Already found matching word hash for " + word + " (" + wordHash + "/" + wordHashes.get(wordHash) + ")");
                    match = true;
                    break;
                } else {
                    wordHashes.put(wordHash, word);
                }
            }
            if(!match) {
                validCount++;
            } else {
                System.out.println("\t\tDuplicate word-variations found in phrase: " + words);
            }
        }

        return validCount;
    }

    private int calculateWordHash(String word) {
        int hash = 1;
        for(char letter : word.toCharArray()) {
            hash = hash * Character.getNumericValue(letter);
        }
        return hash;
    }
}
