import java.io.*;
import java.util.*;

public class BeautifulGraph {

    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        TaskA.InputReader in = new TaskA.InputReader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        TaskA solver = new TaskA();
        int t = in.nextInt();
        while(t-- > 0) {
            solver.solve(in, out);
        }
        out.close();
    }




    static class TaskA {
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

        public static void solve(InputReader in, PrintWriter out) {

            int MOD = 998244353;


            int n = in.nextInt();
            int m = in.nextInt();

            long[] p2 = new long[n + 1];
            p2[0] = 1;
            for(int i = 1; i <= n; ++i)
                p2[i] = (2l * p2[i - 1]) % MOD;


            int[][] B = new int[m][];
            int s = 0;
            while(s < m) {
                int src = in.nextInt();
                int dest = in.nextInt();
                B[s] = new int[]{src - 1, dest - 1};
                s++;
            }

            int[] res = solve(n, B);

            if(res[0] == -1) {
                System.out.println(0);
                return;
            }

            long result = (p2[res[0]] + p2[res[1]] ) % MOD;
            System.out.println(result);

        }


        private static boolean isBiPartiteUtil(List<Set<Integer>> adjList, int[] colorArr, int src) {

            colorArr[src] = 1;

            Queue<Integer> q = new LinkedList();
            q.add(src);


            while(!q.isEmpty()) {
                int node  = q.poll();
                Set<Integer> neighbors = adjList.get(node);
                for(int i : neighbors) {
                    if(colorArr[i] == -1) {
                        colorArr[i] = 1 - colorArr[node];
                        q.add(i);
                    } else if(colorArr[i] == colorArr[node])
                        return false;

                }
            }
            return true;
        }

        public static int[] solve(int A, int[][] B) {

            List<Set<Integer>> adjList = new ArrayList();

            for(int i=0; i<A;i++) {
                adjList.add(new HashSet());
            }

            for(int[] edge : B) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }

            int[] colorArr = new int[A];
            Arrays.fill(colorArr, -1);

            for(int i=0; i<A; i++) {
                if(colorArr[i] == - 1) {
                    boolean isBipartite = isBiPartiteUtil(adjList, colorArr, i);
                    if (!isBipartite)
                        return new int[]{-1, -1};
                }
            }

            int a = 0, b = 0;
            for(int i=0; i<colorArr.length; i++) {
                if(colorArr[i] == 1)
                    a++;
                else b++;
            }
            return new int[] {a, b};
        }


    }
}