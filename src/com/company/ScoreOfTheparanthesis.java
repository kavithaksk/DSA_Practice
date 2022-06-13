package com.company;

import java.util.Stack;

public class ScoreOfTheparanthesis {
    public static String s = "(()(()))";
    int score = 0;
    Stack<Object> st = new Stack<>();

    public void generateScore() {

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ')') {
                st.pop();
                score++;
                st.push(score);
            } else
                st.push(ch);
        }

        if (st.size() == 1) {
            score *= 2;
        }
        System.out.println(score);
    }
}

