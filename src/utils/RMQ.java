package utils;

import java.util.ArrayList;
import java.util.List;

public class RMQ {

    int st[];

    int minVal(int x, int y) {
        return (x < y) ? x : y;
    }

    int getMid(int s, int e) {
        return s + (e - s) / 2;
    }

    int RMQUtil(int ss, int se, int qs, int qe, int index) {
        if (qs <= ss && qe >= se)
            return st[index];

        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;

        int mid = getMid(ss, se);
        return minVal(RMQUtil(ss, mid, qs, qe, 2 * index + 1),
                RMQUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

    int RMQ(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            return -1;
        }

        return RMQUtil(0, n - 1, qs, qe, 0);
    }

    int constructSTUtil(int arr[], int ss, int se, int si) {
        if (ss == se) {
            st[si] = arr[ss];
            return arr[ss];
        }

        int mid = getMid(ss, se);
        st[si] = minVal(constructSTUtil(arr, ss, mid, si * 2 + 1),
                constructSTUtil(arr, mid + 1, se, si * 2 + 2));
        return st[si];
    }

    void constructST(int arr[], int n) {
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];

        constructSTUtil(arr, 0, n - 1, 0);
    }

    void updateValue(int node,int start,int end,int idx,int val, int a[]) {
        if(start == end) {
            a[idx] = val;
            st[node] = val;
        }
        else {
            int mid = (start+end)/2;
            if(idx >= start && idx <= mid) {
                updateValue(2*node+1,start,mid,idx,val,a);
            }
            else{
                updateValue(2*node+2,mid+1,end,idx,val,a);
            }
            st[node]=Math.min(st[2*node+1],st[2*node+2]);
        }
    }

    public int[] solve(int[] A, int[][] B) {
        int n = A.length;
        constructST(A, A.length);

        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < B.length; i++) {
            if(B[i][0] == 0) {
                updateValue(0, 0, n - 1, B[i][1] - 1, B[i][2], A);
            } else {
                list.add(RMQ(n, B[i][1] - 1, B[i][2] - 1));
            }
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}

