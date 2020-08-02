//package codeforces;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Hamburgers {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        solver.solve(in, out);

        out.close();
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }

    static class TaskA {
        public static void solve(InputReader in, PrintWriter out) {


            String recipe = in.next();
            int[] kitchen = new int[3];
            for (int i = 0; i<3; i++)
                kitchen[i] = in.nextInt();

            int[] cost = new int[3];
            for (int i = 0; i<3; i++)
                cost[i] = in.nextInt();

            long rubles = Long.valueOf(in.next());

            Map<Character, Integer> map = new HashMap<>();

            for (int i=0; i<recipe.length(); i++)
                map.put(recipe.charAt(i), map.getOrDefault(recipe.charAt(i), 0) + 1);

            long breadAvailForNBurger = map.get('B') == null ? 0 : kitchen[0] / map.get('B');
            long saugeAvailFOrNBurger = map.get('S') == null ? 0 :  kitchen[1] / map.get('S');
            long cheeseAvailForBurger = map.get('C') == null ? 0 : kitchen[2] / map.get('C');

            long low = Math.min(breadAvailForNBurger, Math.min(saugeAvailFOrNBurger, cheeseAvailForBurger));
            long high = (long)1e12 + 100;


            while(low <= high) {
                long mid = (low + high)/2;

                long breadRequired = Math.max(0, (mid * map.getOrDefault('B', 0)) - kitchen[0]);
                long sausageRequired = Math.max(0, (mid * map.getOrDefault('S', 0)) - kitchen[1]);
                long cheeseRequired = Math.max(0, (mid * map.getOrDefault('C', 0)) - kitchen[2]);

                long rublesNeeded = breadRequired * cost[0] + sausageRequired * cost[1] + cheeseRequired * cost[2];

                if(rubles >= rublesNeeded)
                    low = mid + 1;
                else high = mid - 1;
            }

            out.println(high);

        }


    }
}