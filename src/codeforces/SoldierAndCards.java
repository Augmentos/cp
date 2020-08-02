//package codeforces;

import java.io.*;
import java.util.*;



public class SoldierAndCards {

    static class State {
        Queue q;
        Queue b;
        State(Queue q, Queue b) {
           this.q = q;
           this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Objects.equals(q, state.q) &&
                    Objects.equals(b, state.b);
        }

        @Override
        public int hashCode() {
            return Objects.hash(q, b);
        }
    }

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
            int a = in.nextInt();
            Queue<Integer> queueA = new LinkedList<>();
            Queue<Integer> queueB = new LinkedList<>();

            while (a-- > 0)
                ((LinkedList<Integer>) queueA).add(in.nextInt());

            int b = in.nextInt();
            while (b-- > 0)
                ((LinkedList<Integer>) queueB).add(in.nextInt());

            HashSet<State> set = new HashSet<>();

            int fights = 0;
            while (!queueA.isEmpty() && !queueB.isEmpty()) {
                int r = queueA.poll();
                int s = queueB.poll();

                State state = new State(queueA, queueB);
                if(!set.add(state)) {
                    out.println(-1);
                    return;
                }

                if (r > s) {
                    queueA.add(s);
                    queueA.add(r);
                } else {
                    queueB.add(r);
                    queueB.add(s);
                }
                fights++;
            }

            if(queueA.isEmpty())
                out.println(fights + " " + 2);
            else out.println(fights + " " + 1);


        }


    }
}