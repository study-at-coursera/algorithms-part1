package github.io.toandv.algs4.week01.quiz;

import github.io.toandv.algs4.week01.UF;
import github.io.toandv.algs4.week01.WeightedQuickUnionUF;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dovan on 4/9/2017.
 */
public class Connectivity {

    static class Connection {

        static int count = 1;

        int a;

        int b;

        int time;

        public Connection(int a, int b) {
            this.a = a;
            this.b = b;
            this.time = count++;
        }

        @Override
        public String toString() {
            return "Connection{" +
                    "a=" + a +
                    ", b=" + b +
                    ", time=" + time +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Connection> cons = new ArrayList<>();

        int n = 4;  cons.add(new Connection(0, 1));
        cons.add(new Connection(0, 2));
        cons.add(new Connection(0, 3));
        cons.add(new Connection(1, 2));
        cons.add(new Connection(1, 3));
        cons.add(new Connection(2, 3));
        cons.add(new Connection(2, 3));
        Connection earliest = null;
        UF uf = new WeightedQuickUnionUF(n);
        for (Connection con : cons) {
            uf.union(con.a, con.b);
            if (uf.count() == 1) {
                earliest = con;
                break;
            }
        }
    }

}
