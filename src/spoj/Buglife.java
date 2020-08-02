//package spoj;

import java.io.*;
import java.util.*;


class Buglife {

    public static void main(String[] args) {
       /* InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        InputReader in = new InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        */
        TaskA solver = new TaskA();
       Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int r = t;
        while(t-- > 0) {
            solver.solve(in, t, r);
        }
//        out.close();
    }


    static class TaskA {
        public static void solve(Scanner in, int t, int s) {

            int scNo = s - t;

            int n = in.nextInt();
            int edges = in.nextInt();

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
            colorArr[1] = 1;

            Queue<Integer> q = new LinkedList<>();
            q.add(1);

            while (!q.isEmpty()) {
                int bug = q.poll();

                List<Integer> neighbors = adjList.get(bug);

                for (int neighbor : neighbors) {
                    if(colorArr[neighbor] == -1) {
                        colorArr[neighbor] = 1 - colorArr[bug];
                        q.add(neighbor);
                    }
                    if(colorArr[neighbor] == colorArr[bug]) {
                        System.out.println("Scenario #" + scNo + ":");
                        System.out.println("Suspicious bugs found!");
                        return;
                    }

                }
            }

            System.out.println("Scenario #" + scNo + ":");
            System.out.println("No suspicious bugs found!");
        }
    }
}