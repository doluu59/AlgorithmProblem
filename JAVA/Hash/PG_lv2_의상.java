package JAVA.Hash;

import java.util.*;

/**
 * @from Programmers
 * @index 알고리즘 고득점 Kit
 * @title 의상
 * @grade Level 2
 * @classification Map
 * @solve 카테고리 별로 의상의 가지수를 구한 후 가능한 조합 개수 구하기
 *        1. 카테고리 (상의, 하의 등) 별로 ID를 주는 Map
 *        2. 각 카테고리마다 List를 만들어서 해당 카테고리의 의상 개수 세기
 *        3. 조합 개수 구하기 - 카테고리별 의상 수 + 1을 곱함 (해당 카테고리 안입은 경우) - 1 (아무것도 안입은 경우)
 */
public class PG_lv2_의상 {
    class Solution {
        public int solution(String[][] clothes) {
            int answer = 1;

            // 카테고리 id 매핑
            int idx = 0;
            Map<String, Integer> category = new HashMap<>();
            for (int i=0; i<clothes.length; i++) {
                if (category.get(clothes[i][1]) == null) {
                    category.put(clothes[i][1], idx++);
                }
            }

            // 카테고리별 아이템 리스트
            List<String>[] list = new ArrayList[idx];
            for (int i=0; i<idx; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i=0; i<clothes.length; i++) {
                // 카테고리별로 의상 추가
                list[category.get(clothes[i][1])].add(clothes[i][0]);
            }

            // 가능한 조합 개수 구하기
            for (int i=0; i<idx; i++) {
                answer *= list[i].size()+1;
            }
            answer-=1; // 모든 카테고리에서 안입은 경우 제외

            return answer;
        }
    }
}
