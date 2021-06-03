package com.example.memes;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static Test t = new Test();

    public static void test() {
        System.out.println("123");

    }

    public static void main(String[] args) {
        int c = 2147483646;
        for (int a = 0; a <= Math.sqrt(c); ++a) {
            int b = c - (a * a);
            System.out.println(b);
            int d = (int) Math.sqrt(b);
            if (b == d * d) {
                System.out.println("yes");
                break;
            }
        }

    }

    class Solution {
        public int temp =0;
        public boolean canCross(int[] stones) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < stones.length; i++) {
                map.put(stones[i], i);
            }
            dfs(stones, 0, 1, map);
            if(temp==1) {
                return true;
            } else {
                return false;
            }
        }

        public void dfs(int[] stones, int a, int k, Map<Integer, Integer> map) {


            if (map.containsKey(a)) {
                if ((a+k)==stones[(stones.length)-1]) {
                    temp=1;
                }
                else {
                    dfs(stones,a+k,k+1,map);
                    dfs(stones,a+k,k,map);
                    dfs(stones,a+k,k-1,map);
                }

            }


        }
    }
}
