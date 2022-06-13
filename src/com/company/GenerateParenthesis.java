package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParenthesis {

    static List<String> result = new ArrayList<>();
    static Stack<String> st = new Stack<>();

    public static List<String> generateParenthesis(int n) {

        backtrack(0, 0, n);
        return result;

    }

    public static boolean isValid(String s) {

        /* If the current char is ( or [ or {, then push to stack */
        /* If the current char is ) or ] or }, then pop the element
           and check if it matches with the corresponding open bracket. */
        /* If yes, return true otherwise return false */

        Stack<Character> st = new Stack<Character>();
        boolean valid = true;
        boolean noClosedBracketsAtAll = false;

        if (s.length() == 1)
            valid = false;

        else
        {

            for(int i = 0; i < s.length(); i++)
            {
                char ch = s.charAt(i);


                if (!st.isEmpty())
                {
                    switch(ch)
                    {
                        case ')':
                            noClosedBracketsAtAll = true;
                            if(st.pop() != '(') {

                                valid = false;
                            }
                            break;

                        case ']':
                            noClosedBracketsAtAll = true;
                            if (st.pop() != '[') {
                                valid = false;
                            }

                            break;

                        case '}':
                            noClosedBracketsAtAll = true;
                            if (st.pop() != '{') {
                                valid = false;
                            }
                            break;

                        default:
                            st.push(ch);
                            break;
                    }

                }
                else if ((st.isEmpty()) && (ch == '}' || ch == ')' || ch == ']'))
                {
                    valid = false;
                    break;
                }
                else
                {
                    st.push(ch);
                }
                if (!valid)
                    break;
            }
        }

        if (!st.isEmpty() || !noClosedBracketsAtAll)
            valid = false;

        return valid;

    }

    static void backtrack(int openN, int closedN, int n)
    {
        if ((openN == closedN) && (openN == n) && (closedN == n))
        {
            result.add(String.join("", st));
            return;
        }

        if (openN < n)
        {
            st.push("(");
            backtrack(openN+1, closedN, n);
            st.pop();
        }

        if (closedN < openN)
        {
            st.push(")");
            backtrack(openN, closedN + 1, n);
            st.pop();
        }


    }
}
