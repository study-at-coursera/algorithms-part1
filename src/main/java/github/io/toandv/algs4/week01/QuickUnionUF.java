package github.io.toandv.algs4.week01;

/**
 * + id[i] is parent of i
 * + root of i is id[id[id[...id[i]...]]] until it doesn't change, no cycles
 * Created by dovan on 4/2/2017.
 */
public class QuickUnionUF implements UF {

    int id[];

    int count;

    public QuickUnionUF(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        count = n;
    }

    private int root(int p) {
        int child = p;
        int parent = id[child];
        while (parent != child) {
            child = parent;
            parent = id[child];
        }
        return parent;
    }

    public void union(int p, int q) {
        int proot = root(p);
        int qroot = root(q);
        if (proot == qroot) return;
        id[proot] = qroot;
        count--;
    }

    @Override
    public int find(int p) {
        return root(p);
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        // TODO
        // count the roots
        return 0;
    }
}
