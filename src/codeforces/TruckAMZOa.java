package codeforces;


import java.util.*;

/**
 * @author Sharoon Babu
 * Package: codeforces
 * Date: 3/7/20
 */

class PairInt {
    int first;
    int second;
    PairInt(int x, int y) {
        this.first = x;
        this.second = y;
    }
}

public class TruckAMZOa {

    public static void main(String[] args) {
        List<Character> inputList= new ArrayList();
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < inputList.size(); i++) {
            char ch = inputList.get(i);
            map.put(ch, i);
        }

        List<Integer> result = new ArrayList();

        int left = 0, right = 0;
        for(int i = 0; i<inputList.size(); i++) {
            char ch = inputList.get(i);
            right = Math.max(right, map.get(ch));
            if(right == i) {
                result.add(right - left + 1);
                left = right + 1;
            }
        }

    }

}
