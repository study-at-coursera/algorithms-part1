package github.io.toandv.algs4.week01.quiz;

import github.io.toandv.algs4.week01.WeightedQuickUnionUF;

/**
 * Created by dovan on 4/9/2017.
 */
public class FindSuccessor {

    public static void main(String[] args) {
        DeleteSuccessor ds = new DeleteSuccessor(5);
        ds.delete(1);
        System.out.println(ds.findSuccessor(1));
        System.out.println(ds.findSuccessor(2));
        ds.delete(3);
        System.out.println(ds.findSuccessor(3));
    }
}
