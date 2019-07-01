package BFS;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 */
public class WordLadder127 {

    // 每个单词看成一个节点，如果单词Ａ仅仅需要改变一个字母就可以变成单词Ｂ，那么单词ＡＢ之间存在边
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> nodesForTraversal = new LinkedList<>();
        int level = 0;
        boolean []hasMarked = new boolean[wordList.size() + 1]; // 为了尽可能提升速度

        nodesForTraversal.add(beginWord);
        // hasMarked.put(beginWord, true);

        while (!nodesForTraversal.isEmpty()) {
            level++;
            int size = nodesForTraversal.size();
            while (size > 0) {
                String currentWord = nodesForTraversal.poll();
                int index = -1;
                for (String word : wordList) {
                    index++;
                    if (hasMarked[index]|| !isConnected(word, currentWord)) {
                        continue;
                    }
                    if (word.equals(endWord)) {
                        return level + 1;
                    }
                    hasMarked[index] = true;
                    nodesForTraversal.add(word);
                }
                size--;
            }
        }
        return 0;
    }

    // 判断两个单词能不能通过仅仅改变一次字母来互相转换
    // 此时假定wordList中每个单词都是等长度的
    public boolean isConnected(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount <= 1;
    }


    public static void main(String[] args) {
        WordLadder127 wordLadder127 = new WordLadder127();
        String []s = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(s);

        System.out.println(wordLadder127.ladderLength("hit", "cog", wordList));
    }
}
