package github.io.toandv.algs4.week01;

/**
 * two elements are connected if they have the same id
 * Created by dovan on 4/2/2017.
 */
public class QuickFindUF implements UF {

    int[] ids;

    int count;

    /**
     * Initialize n sites with integers names (0 to n - 1)
     *
     * @param n
     */
    public QuickFindUF(int n) {
        ids = new int[n];
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        count = n;
    }

    /**
     * Add connection between p and q
     *
     * @param p
     * @param q
     */
    @Override
    public void union(int p, int q) {
        // 1. if p and q are connected => do nothing
        // 2. if p and q are not connected => set p's and its connected members's ids to q's ids
        if (connected(p, q)) return;

        int qid = find(q);
        int pid = find(p);
        // O(n)
        for (int i = 0; i < ids.length; i++) {
            if (find(i) == pid) {
                setId(i, qid);
            }
        }
        count--;
    }

    /**
     * @param p
     * @return component identifier for p (0, n - 1)
     */
    @Override
    public int find(int p) {
        return ids[p];
    }

    public void setId(int p, int id) {
        ids[p] = id;
    }

    /**
     * @param p
     * @param q
     * @return true if p and q are in the same component
     */
    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * @return number of components
     */
    @Override
    public int count() {
        // 1 1 2 1 2 3 3 1 2
//        int buf[] = new int[ids.length];
//        int count = 0;
//
//        // O(n^2)
//        for (int i = 0; i < ids.length; i++) {
//            boolean inBuf = false;
//            for (int j = 0; j < count; j++) {
//                if (ids[i] == buf[j]) {
//                    inBuf = true;
//                    // already in the buf
//                    break;
//                }
//            }
//            if (!inBuf) {
//                buf[count++] = ids[i];
//            }
//        }
        return count;
    }

    public static void main(String[] args) {
        QuickFindUF uf = new QuickFindUF(10);
        uf.union(1, 2);
        uf.union(2, 3);
        System.out.println(uf.count());
    }

}
