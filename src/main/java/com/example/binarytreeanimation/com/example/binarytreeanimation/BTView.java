package com.example.binarytreeanimation;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView extends Pane {
    private BST<Integer> tree = new BST<Integer>();
    private double radius = 15; // Tree node radius
    private double vGap = 50; // Gap between two levels in a tree

    public BTView(BST<Integer> tree) {
        this.tree = tree;
        setStatus("Tree is empty");
    }

    public void setStatus(String msg) {
        getChildren().add(new Text(20, 20, msg));
    }

    public void displayTree() {
        this.getChildren().clear(); // Clear the pane
        if (tree.getRoot() != null) {
// Display tree recursively
            displayTree(tree.getRoot(), getWidth() / 2, vGap, getWidth() / 4);
        }
    }

    /**
     * Display a subtree rooted at position (x, y)
     */
    private void displayTree(BST.TreeNode<Integer> current,
                             double x, double y, double hGap) {
        if (current.left != null) {
// Draw a line to the left node
            getChildren().add(new Line(x - hGap, y + vGap, x, y));
// Draw the left subtree recursively
            displayTree(current.left, x - hGap, y + vGap, hGap / 2);
        }
        if (current.right != null) {
// Draw a line to the right node
            getChildren().add(new Line(x + hGap, y + vGap, x, y));
// Draw the right subtree recursively
            displayTree(current.right, x + hGap, y + vGap, hGap / 2);
        }
// Display the current node
        Circle circle = new Circle(x, y, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        getChildren().addAll(circle,
                new Text(x - 4, y + 4, current.element + ""));
    }
}


