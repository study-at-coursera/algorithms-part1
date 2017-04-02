package github.io.toandv.algs4.week01;

/**
 * Created by dovan on 4/2/2017.
 */
public class WeightedQuickUnionUF implements UF {

    int id[];
    int sz[];
    int count;

    public WeightedQuickUnionUF(int n) {
        id = new int[n];
        sz = new int[n];
        count = n;
        for (int i = 0; i < n; i++) {
            id[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int proot = find(p);
        int qroot = find(q);
        if (qroot == proot) return;
        if (sz[p] > sz[q]) {
            id[q] = proot;
            sz[p] = sz[p] + sz[q];
        } else {
            id[p] = qroot;
            sz[q] = sz[q] + sz[p];
        }
        count--;
    }

    @Override
    public int find(int i) {
       while(i != id[i]) {
           // path compression, point current not to its grandparent, halving path length
           id[i] = id[id[i]];
           i = id[i];
       }
       return i;
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
