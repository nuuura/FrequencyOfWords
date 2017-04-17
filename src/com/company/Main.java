package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringTokenizer st = new StringTokenizer(input);
        HashMap<String, Integer> map = new HashMap<>();
        ValueComparator bvc = new ValueComparator(map);
        TreeMap<String, Integer> sorted_map = new TreeMap<>(bvc);
        while (st.hasMoreTokens()) {
            int coll = 0;
            String t = st.nextToken();
            if (map.containsKey(t)) {
                coll = map.get(t);
            }
            coll++;
            map.put(t, coll);
        }
        sorted_map.putAll(map);
        Set<String> arg = sorted_map.keySet();
        String[] arg1 = arg.toArray(new String[0]);


        int max = arg1[0].length();
        for (int i = 1; i < arg1.length; i++) {
            if (arg1[i].length() > max) {
                max = arg1[i].length();
            }
        }

        for (String x : arg1) {
            int z = max - x.length();
            for (int w = 0; w < z; w++) {
                System.out.print("_");
            }
            System.out.print(x + " ");
            int u = (arg1.length - 1);
            double v = map.get(arg1[u]);
            double f = (v / 10);
            v = map.get(x);
            double n = (v / f);
            int r = (int) Math.round(n);
            for (int g = 0; g < r; g++)
                System.out.print(".");
            System.out.println();
        }
    }


    static class ValueComparator implements Comparator<String> {
        final Map<String, Integer> base;

        public ValueComparator(Map<String, Integer> base) {
            this.base = base;
        }

        public int compare(String a, String b) {
            if (base.get(a) >= base.get(b)) {
                return 1;
            } else {
                return -1;
            }
        }
    }
}
