package github.io.toandv.algs4.week01.tree;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Created by toan on 5/16/17.
 * https://en.wikipedia.org/wiki/Tree_traversal
 */
public class DirectoryTraversal {

    public static void postOrderRecur(File file) {
        File[] subFiles = file.listFiles();
        if (subFiles == null) return;
        for (File f : subFiles) {
            postOrderRecur(f);
            System.out.println(f);
        }
    }

    public static void preOrderRecur(File file) {
        System.out.println(file);
        File[] subFiles = file.listFiles();
        if (subFiles == null) return;
        for (File f : subFiles) {
            preOrderRecur(f);
        }
    }

    public static void postOrderIter(File file, Consumer<File> fileOperator) {
        class Item {
            File file;
            boolean subsRecorded;

            public Item(File file) {
                this.file = file;
            }
        }
        ArrayDeque<Item> stack = new ArrayDeque<>();
        stack.push(new Item(file));
        while (!stack.isEmpty()) {
            Item top = stack.peek();
            File[] subs = top.file.listFiles();
            if (subs != null && !top.subsRecorded) {
                top.subsRecorded = true;
                for (int i = subs.length - 1; i >= 0; i--) {
                    stack.push(new Item(subs[i]));
                }
            } else {
                fileOperator.accept(top.file);
                stack.pop();
            }
        }
    }

    public static void delete(String deletingDir) {
        File file = new File(deletingDir);
        File[] subs = file.listFiles();
        if (subs != null) {
            Stream.of(subs).parallel().forEach(sub -> {
                postOrderIter(sub, f -> {
                    System.out.println("Deleting " + f);
                    f.delete();
                    System.out.println("Deleted " + f);
                });
            });
        }
        file.delete();
    }
}
