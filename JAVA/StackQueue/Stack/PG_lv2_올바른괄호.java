package JAVA.StackQueue.Stack;

import java.util.*;
import java.io.*;

/**
 * @from Programmers
 * @index High Score Kit
 * @title 올바른 괄호
 * @grade Level 2
 * @classification 스택
 * @solve 여는 괄호를 스택에 넣고 닫는 괄호가 나오면 스택에서 여는 괄호를 뺸다.
 *        스택에 여는 괄호가 없거나, 마지막에 여는 괄호가 남아 있으면 false
 */
public class PG_lv2_올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        int n = s.length();

        char[] str = s.toCharArray();

        for (int i=0; i<n; i++) {
            // '(' 이면 스택에 쌓기
            if(str[i] == '(') {
                stack.add(str[i]);
            }
            // ')' 이면 스택에서 '(' 찾기
            else {
                if (stack.isEmpty()) {
                    answer = false;
                    break;
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) answer = false;

        return answer;
    }
}


