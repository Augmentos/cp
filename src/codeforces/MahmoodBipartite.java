//package codeforces;

import java.io.*;
import java.util.*;


public class MahmoodBipartite {

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


            int n = in.nextInt();
            int edges = n - 1;

            Map<Integer, List<Integer>> adjList = new HashMap();

            while(edges-- > 0) {
                int first = in.nextInt();
                int second = in.nextInt();

                adjList.putIfAbsent(first, new ArrayList<>());
                adjList.putIfAbsent(second, new ArrayList<>());
                adjList.get(first).add(second);
                adjList.get(second).add(first);
            }

            int[] colorArr = new int[n+1];
            Arrays.fill(colorArr, -1);

            Queue<Integer> q = new LinkedList<>();


            for (int i = 1; i <colorArr.length; i++) {
                if(colorArr[i] == -1) {
                    q.add(i);
                    colorArr[i] = 1;

                }

                while (!q.isEmpty()) {
                    int bug = q.poll();

                    List<Integer> neighbors = adjList.get(bug);

                    for (int neighbor : neighbors) {
                        if(colorArr[neighbor] == -1) {
                            colorArr[neighbor] = 1 - colorArr[bug];
                            q.add(neighbor);
                        }
                    }
                }
            }


            long set1 = 0;
            long set2 = 0;
            for (int i=1; i<colorArr.length; i++) {
                if(colorArr[i] == 0)
                        set1++;
                else set2++;
            }

            System.out.println((set1 * set2) - (n - 1));


        }


    }
}