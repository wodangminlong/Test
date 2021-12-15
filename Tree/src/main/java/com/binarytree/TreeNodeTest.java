package com.binarytree;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeTest {

    List<Integer> preorderResultList = new ArrayList<>();
    List<Integer> mediumOrderResultList = new ArrayList<>();
    List<Integer> postorderResultList = new ArrayList<>();

    /**
     * 前序递归
     * 先查询根节点,再查询左子结点,最后查询右子结点
     *
     * @param treeNode  treeNode
     */
    private void preorderRecursion(TreeNode treeNode) {
        preorderResultList.add(treeNode.value);
        if (treeNode.leftNode != null) {
            preorderRecursion(treeNode.leftNode);
        }
        if (treeNode.rightNode != null) {
            preorderRecursion(treeNode.rightNode);
        }
    }

    /**
     * 中序递归
     * 先访问左子结点,再访问根结点,再访问右子结点
     *
     * @param treeNode  treeNode
     */
    private void mediumOrderRecursion(TreeNode treeNode) {
        if (treeNode.leftNode != null) {
            mediumOrderRecursion(treeNode.leftNode);
        }
        mediumOrderResultList.add(treeNode.value);
        if (treeNode.rightNode != null) {
            mediumOrderRecursion(treeNode.rightNode);
        }
    }

    /**
     * 后序递归
     * 先访问左子结点,再访问右子结点,再访问根结点
     *
     * @param treeNode  treeNode
     */
    private void postorderRecursion(TreeNode treeNode) {
        if (treeNode.leftNode != null) {
            postorderRecursion(treeNode.leftNode);
        }
        if (treeNode.rightNode != null) {
            postorderRecursion(treeNode.rightNode);
        }
        postorderResultList.add(treeNode.value);
    }

    private void print(int type) {
        switch (type) {
            case 1:
                preorderResultList.forEach(System.out::println);
                break;
            case 2:
                mediumOrderResultList.forEach(System.out::println);
                break;
            default:
                postorderResultList.forEach(System.out::println);
                break;
        }
    }


    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        TreeNode aNode = new TreeNode(2);
        TreeNode bNode = new TreeNode(3);
        TreeNode cNode = new TreeNode(4);
        TreeNode dNode = new TreeNode(5);
        TreeNode eNode = new TreeNode(6);
        TreeNode fNode = new TreeNode(7);
        TreeNode gNode = new TreeNode(8);

        rootNode.leftNode = aNode;
        rootNode.rightNode = bNode;

        aNode.leftNode = cNode;

        cNode.rightNode = fNode;

        bNode.leftNode = dNode;
        bNode.rightNode = eNode;

        eNode.leftNode = gNode;

        TreeNodeTest test = new TreeNodeTest();

        // 前序递归
        test.preorderRecursion(rootNode);
        test.print(1);

        // 中序递归
        test.mediumOrderRecursion(rootNode);
        test.print(2);

        // 后序递归
        test.postorderRecursion(rootNode);
        test.print(3);
    }

}
