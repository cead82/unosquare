package com.unosquare.test;

import java.util.HashSet;
import java.util.Set;

public class Smallest {
    static int[] A = {1,2,3};
    public static void main(String[] args) {
        System.out.println(solution(A));
    }

    static int solution(int[] A){
        int small = 0;
        int N = A.length;
        Set<Integer> setArray = new HashSet<Integer>();
        for (int a:A) {
            if(a>0){
                setArray.add(a);
            }
        }

        for (int i = 1; i<=N + 1; i++){
            if (!setArray.contains(i)){
                small =  i;
            }
        }
        return small;
    }


}
