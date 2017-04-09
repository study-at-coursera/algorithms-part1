package github.io.toandv.algs4.week01.quiz;

import github.io.toandv.algs4.week01.UF;
import github.io.toandv.algs4.week01.WeightedQuickUnionUF;

/**
 * Created by dovan on 4/9/2017.
 */
public class FindMax {

    public static void main(String[] args) {
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(5);

        uf.union(1, 2);
        uf.union(1, 3);
        uf.union(1, 0);
        uf.union(3, 3);
        System.out.println(uf.findMax(1));

    }

}
