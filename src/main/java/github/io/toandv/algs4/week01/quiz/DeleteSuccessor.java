package github.io.toandv.algs4.week01.quiz;

/**
 * Created by dovan on 4/9/2017.
 */
public class DeleteSuccessor {

    int id[];

    int count;


    public DeleteSuccessor(int n) {
        this.count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void delete(int i) {
        if (i == id.length - 1) {
            id[i] = -1;
            return;
        }
        union(i, i + 1);
    }

    public int findSuccessor(int i) {
        return find(i);
    }

    void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j;
        count--;
    }

    int find(int i) {
        while (i != id[i]) {
            // path compression
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }
}
