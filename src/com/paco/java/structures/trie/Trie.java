package com.paco.java.structures.trie;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, k -> new TrieNode());
        }
        current.setIsWord(true);
    }

    public boolean isWord(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.getChildren().get(c);
            if (current == null) {
                return false;
            }
        }
        return current.isWord();
    }

    public boolean search(String word) {
        TrieNode current = root;
        for (char c : word.toCharArray()) {
            current = current.getChildren().get(c);
            if (current == null) {
                return false;
            }
        }
        return true;
    }
}
