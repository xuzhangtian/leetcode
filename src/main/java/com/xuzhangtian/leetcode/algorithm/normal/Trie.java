package com.xuzhangtian.leetcode.algorithm.normal;

/**
 * @Author: xzt
 * @Date: 2023-11-20
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 * <p>
 * Implement the Trie class:
 * <p>
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 * <p>
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 * <p>
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 **/
public class Trie {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.search("app");
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        char[] list = word.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < list.length; i++) {
            int index = list[i] - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }

    public boolean search(String word) {
        return find(word, false);
    }

    public boolean startsWith(String prefix) {
        return find(prefix, true);
    }

    public boolean find(String word, Boolean isStartWith) {
        if (word == null || word.isEmpty()) {
            return false;
        }
        char[] list = word.toCharArray();
        TrieNode current = root;
        for (int i = 0; i < list.length; i++) {
            int index = list[i] - 'a';
            current = current.children[index];
            if (current == null) {
                return false;
            }
        }
        if (isStartWith) {
            return true;
        } else {
            return current.isEnd;
        }
    }

    public static class TrieNode {
        public boolean isEnd;
        public TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

}
