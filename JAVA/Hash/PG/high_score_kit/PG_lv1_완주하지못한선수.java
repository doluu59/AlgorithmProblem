/**
 * @from Programmers
 * @index
 * @title 완주하지 못한 선수
 * @grade Level 1
 * @classification 해쉬
 */

package JAVA.Hash.PG.high_score_kit;

import java.util.*;

public class PG_lv1_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = null;
        Map<String, Integer> map = new HashMap<>();
        for (String part:participant) {
            if(map.containsKey(part)) {
                map.put(part, map.get(part)+1);
            } else {
                map.put(part, 1);
            }
        }
        for (String comp: completion) {
            map.put(comp, map.get(comp)-1);
        }
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;
            }
        }

//         Set<String> set = new HashSet<>();
//         for (String part : participant) {
//             set.add(part);
//         }
//         for (String comp : completion) {
//             set.remove(comp);
//         }

//         for (String str : set) {
//             answer = str;
//         }
        return answer;
    }
}

