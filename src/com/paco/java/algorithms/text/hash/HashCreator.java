package com.paco.java.algorithms.text.hash;

import com.paco.java.structures.Pair;

public class HashCreator {
    private final char[] word;
    private final int[] hash;
    private int smallPrimeNumber;
    private final int bigPrimeNumber = 1000000007;
    private int[] powersOfSmallPrime;

    public HashCreator(String word) {
        this.word = word.toCharArray();
        this.hash = new int[word.length() + 1];
        this.smallPrimeNumber = 29;
        fillPowersOfSmallPrime();
        createHash();
    }

    public HashCreator(String word, int smallPrimeNumber) {
        this.word = word.toCharArray();
        this.hash = new int[word.length() + 1];
        this.smallPrimeNumber = smallPrimeNumber;
        fillPowersOfSmallPrime();
        createHash();
    }

    public void setSmallPrimeNumber(int smallPrimeNumber) {
        this.smallPrimeNumber = smallPrimeNumber;
        fillPowersOfSmallPrime();
    }

    public void fillPowersOfSmallPrime() {
        powersOfSmallPrime = new int[word.length + 1];
        powersOfSmallPrime[0] = 1;
        for (int i = 1; i <= word.length; i++) {
            powersOfSmallPrime[i] = (powersOfSmallPrime[i - 1] * smallPrimeNumber) % bigPrimeNumber;
        }
    }

    public void createHash() {
        hash[0] = 0;
        for (int i = 1; i <= word.length; i++) {
            hash[i] = (word[i - 1] * powersOfSmallPrime[i]) % bigPrimeNumber;
        }
    }

    public int getSmallPrimeNumber() {
        return smallPrimeNumber;
    }


    public boolean isSubwordsEqual(HashCreator other, Pair<Integer> indexOfOther, Pair<Integer> indexOfOwn) {
        int length = indexOfOwn.getSecond() - indexOfOwn.getFirst();
        if (length != indexOfOther.getSecond() - indexOfOther.getFirst()) {
            return false;
        }
        int hashOfOther =
                (other.hash[indexOfOther.getSecond()] - other.hash[indexOfOther.getFirst() - 1] + other.bigPrimeNumber) % other.bigPrimeNumber;
        int hashOfOwn =
                (hash[indexOfOwn.getSecond()] - hash[indexOfOwn.getFirst() - 1] + bigPrimeNumber) % bigPrimeNumber;
        hashOfOther = (hashOfOther * powersOfSmallPrime[indexOfOwn.getFirst()]) % bigPrimeNumber;
        hashOfOwn = (hashOfOwn * other.powersOfSmallPrime[indexOfOther.getFirst()]) % bigPrimeNumber;
        return hashOfOther == hashOfOwn;
    }
}
