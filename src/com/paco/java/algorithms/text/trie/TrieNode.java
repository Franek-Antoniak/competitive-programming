package com.paco.java.algorithms.text.trie;

import java.util.HashMap;

public class TrieNode {
    private final HashMap<Character, TrieNode> children;
    private boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
    }

    public HashMap<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isWord() {
        return isWord;
    }

    public void setIsWord(boolean isWord) {
        this.isWord = isWord;
    }
}
