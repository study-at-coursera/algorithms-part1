package github.io.toandv.algs4.week01;

/**
 * Created by dovan on 4/2/2017.
 */
public interface UF {

    void union(int p, int q);

    int find(int p);

    boolean connected(int p, int q);

    int count();

}
