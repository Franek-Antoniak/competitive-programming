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
        for (int i = 1; i < word.length; i++) {
            powersOfSmallPrime[i] = (powersOfSmallPrime[i - 1] * smallPrimeNumber) % bigPrimeNumber;
        }
    }

    public void createHash() {
        hash[0] = 0;
        for (int i = 1; i <= word.length; i++) {
            hash[i] = (word[i - 1] * powersOfSmallPrime[i - 1] + hash[i - 1]) % bigPrimeNumber;
        }
    }

    public boolean subwordsEquals(HashCreator other, Pair<Integer, Integer> indexOfOther,
                                   Pair<Integer, Integer> indexOfOwn) {
        if(other.smallPrimeNumber != smallPrimeNumber) {
            throw new IllegalArgumentException("The small prime numbers of the two hash creators must be the same");
        }
        int length = indexOfOwn.second() - indexOfOwn.first();
        if (length != indexOfOther.second() - indexOfOther.first()) {
            return false;
        }
        int hashOfOther =
                (other.hash[indexOfOther.second() + 1] - other.hash[indexOfOther.first()] + bigPrimeNumber) % bigPrimeNumber;
        int hashOfOwn =
                (hash[indexOfOwn.second() + 1] - hash[indexOfOwn.first()] + bigPrimeNumber) % bigPrimeNumber;
        hashOfOther = (hashOfOther * powersOfSmallPrime[indexOfOwn.first()]) % bigPrimeNumber;
        hashOfOwn = (hashOfOwn * powersOfSmallPrime[indexOfOther.first()]) % bigPrimeNumber;
        return hashOfOther == hashOfOwn;
    }
}
