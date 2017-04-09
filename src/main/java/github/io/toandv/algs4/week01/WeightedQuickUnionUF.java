package github.io.toandv.algs4.week01;

/**
 * Created by dovan on 4/2/2017.
 */
public class WeightedQuickUnionUF implements UF {

    int id[];

    int sz[];

    // store max value to root
    int max[];

    int count;

    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        sz = new int[n];
        max = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            max[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        // Make smaller root point to larger one.
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;

        if (max[i] < max[j]) {
            max[i] = max[j];
        } else {
            max[j] = max[i];
        }
    }

    @Override
    // lgn
    public int find(int i) {
        while (i != id[i]) {
            // path compression, point current node to its grandparent, halving path length
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    public int findMax(int i) {
        return max[find(i)];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }

    public static void main(String[] args) {
        UF uf = new WeightedQuickUnionUF(10);
        uf.union(1, 2);
        uf.union(2, 3);
        uf.union(2, 9);
        System.out.println(uf.connected(1, 9));
        System.out.println(uf.count());
    }
}
