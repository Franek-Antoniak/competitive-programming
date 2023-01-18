package com.leetcode;

public class ImplementTrie {
	class Trie {
		char prefix;
		Trie[] nodes = new Trie[26];
		boolean isWord = false;

		public Trie(char prefix) {
			this.prefix = prefix;
		}

		public Trie() {

		}

		public void insert(String word) {
			Trie node = this;
			for (int i = 0; i < word.length(); i++) {
				node = node.addNode(word.charAt(i));
			}
			node.isWord = true;
		}

		Trie addNode(char x) {
			if (nodes[x - 'a'] == null) {
				nodes[x - 'a'] = new Trie(x);
			}
			return nodes[x - 'a'];
		}

		public boolean search(String word) {
			Trie node = this;
			for (int i = 0; i < word.length(); i++) {
				node = node.nodes[word.charAt(i) - 'a'];
				if (node == null) {
					return false;
				}
			}
			return node.isWord;
		}

		public boolean startsWith(String prefix) {
			Trie node = this;
			for (int i = 0; i < prefix.length(); i++) {
				node = node.nodes[prefix.charAt(i) - 'a'];
				if (node == null) {
					return false;
				}
			}
			return true;
		}
	}
}

