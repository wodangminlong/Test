package com.balancedbinarytree;

public class AVLTreeNode {

    int value;

    int depth;

    AVLTreeNode parentNode;

    AVLTreeNode leftNode;

    AVLTreeNode rightNode;

    AVLTreeNode(int value) {
        this.value = value;
        this.depth = 0;
        this.parentNode = null;
        this.leftNode = null;
        this.rightNode = null;
    }

}
