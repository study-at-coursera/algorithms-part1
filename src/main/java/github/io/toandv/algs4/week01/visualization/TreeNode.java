package github.io.toandv.algs4.week01.visualization;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.*;

/**
 * Created by dovan on 4/2/2017.
 */
public class TreeNode {

    final Text text;

    final Circle circle;

    TreeNode parent;

    Group group;

    boolean addedToGroup = false;

    Map<TreeNode, Line> pathByChild = new HashMap<>();

    List<TreeNode> children = new ArrayList<>();

    public TreeNode(String label, double x, double y) {
        text = new Text(x - 12, y, label);
        text.setFont(new Font(15));
        circle = new Circle(x, y, 20, Color.GREY);
    }

    // http://stackoverflow.com/questions/5987867/traversing-a-n-ary-tree-without-using-recurrsion
    // Depth-first traversal ???
    public void show() {
        // group.getChildren().addAll(circle, text);
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(this);
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            for (TreeNode child : top.children) {
                stack.push(child);
            }
            if (!addedToGroup) {
                group.getChildren().addAll(top.circle, top.text);
                addedToGroup = true;
            }
        }
    }


    // Breadth-first traversal
    public void show1() {
        // group.getChildren().addAll(circle, text);
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(this);
        while (!queue.isEmpty()) {
            TreeNode top = queue.removeFirst();
            for (TreeNode child : top.children) {
                queue.addLast(child);
            }
            if (!top.addedToGroup) {
                group.getChildren().addAll(top.circle, top.text);
                if (top.parent != null) {
                    Line path = pathByChild.get(top);
                    if (path != null) {
                        group.getChildren().add(path);
                    }
                }
                top.addedToGroup = true;
            }
        }

    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void addChild(TreeNode child) {
        children.add(child);
        child.parent = this;
        // connect
        Line path = new Line(this.circle.getCenterX(), this.circle.getCenterY(), child.circle.getCenterX(), child.circle.getCenterY());
        path.setFill(Color.GREY);
        pathByChild.put(child, path);
    }
}
