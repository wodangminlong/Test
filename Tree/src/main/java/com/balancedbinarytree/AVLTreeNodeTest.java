package com.balancedbinarytree;

import java.util.ArrayList;
import java.util.List;

public class AVLTreeNodeTest {

    List<Integer> preorderResultList = new ArrayList<>();

    /**
     * 更新树的深度
     *
     * @param avlTreeNode   avlTreeNode
     */
    private void updateDepth(AVLTreeNode avlTreeNode) {
        if (avlTreeNode != null) {
            int depthLeftNode = getDepth(avlTreeNode.leftNode);
            int depthRightNode = getDepth(avlTreeNode.rightNode);
            avlTreeNode.depth = Math.max(depthLeftNode, depthRightNode) + 1;
        }
    }

    /**
     * 获取树的深度
     *
     * @param avlTreeNode   avlTreeNode
     * @return  int
     */
    private int getDepth(AVLTreeNode avlTreeNode) {
        if (avlTreeNode == null) {
            return 0;
        }
        return avlTreeNode.depth;
    }

    /**
     * 左旋
     * 1.父结点的右子结点变更为父结点
     * 2.右子结点的左子结点变更为父结点的右子结点
     * 3.父结点变更为右子结点的左子结点
     *
     * @param avlTreeNode   avlTreeNode
     * @return  AVLTreeNode
     */
    private AVLTreeNode leftRotation(AVLTreeNode avlTreeNode) {
        AVLTreeNode parentNode = avlTreeNode.parentNode;
        AVLTreeNode childNode = avlTreeNode.rightNode;
        if (childNode.leftNode != null) {
            childNode.leftNode.parentNode = avlTreeNode;
        }
        avlTreeNode.rightNode = childNode.leftNode;
        updateDepth(avlTreeNode);
        childNode.leftNode = avlTreeNode;
        return getNewNode(parentNode, childNode, avlTreeNode);
    }

    /**
     * 右旋
     * 1.父结点的左子结点变更为父结点
     * 2.左子结点的右子结点变更为父结点的左子结点
     * 3.父结点变更为左子结点的右子结点
     *
     * @param avlTreeNode   avlTreeNode
     * @return  AVLTreeNode
     */
    private AVLTreeNode rightRotation(AVLTreeNode avlTreeNode) {
        AVLTreeNode parentNode = avlTreeNode.parentNode;
        AVLTreeNode childNode = avlTreeNode.leftNode;
        if (childNode.rightNode != null) {
            childNode.rightNode.parentNode = avlTreeNode;
        }
        avlTreeNode.leftNode = childNode.rightNode;
        updateDepth(avlTreeNode);
        childNode.rightNode = avlTreeNode;
        return getNewNode(parentNode, childNode, avlTreeNode);
    }

    /**
     * 先左旋,再右旋
     *
     * @param avlTreeNode   avlTreeNode
     * @return  AVLTreeNode
     */
    private AVLTreeNode leftRightRotation(AVLTreeNode avlTreeNode) {
        leftRotation(avlTreeNode.leftNode);
        return rightRotation(avlTreeNode);
    }

    /**
     * 先右旋,再左旋
     *
     * @param avlTreeNode   avlTreeNode
     * @return  AVLTreeNode
     */
    private AVLTreeNode rightLeftRotation(AVLTreeNode avlTreeNode) {
        rightRotation(avlTreeNode.rightNode);
        return leftRotation(avlTreeNode);
    }

    /**
     * 获取最小的结点
     *
     * @param parentNode    parentNode
     * @param childNode childNode
     * @param avlTreeNode   avlTreeNode
     * @return  AVLTreeNode
     */
    private AVLTreeNode getNewNode(AVLTreeNode parentNode, AVLTreeNode childNode, AVLTreeNode avlTreeNode) {
        childNode.parentNode = parentNode;
        if (parentNode != null) {
            if (parentNode.leftNode == avlTreeNode) {
                parentNode.leftNode = childNode;
            } else {
                parentNode.rightNode = childNode;
            }
        }
        avlTreeNode.parentNode = childNode;
        updateDepth(childNode);
        return childNode;
    }

    /**
     * 获取平衡因子
     * 平衡因子：0:左右子结点相同 1:左子结点高 -1:右子结点高
     *
     * @param avlTreeNode   avlTreeNode
     * @return  int
     */
    private int getBalance(AVLTreeNode avlTreeNode) {
        if (avlTreeNode == null) {
            return 0;
        }
        return getDepth(avlTreeNode.leftNode) - getDepth(avlTreeNode.rightNode);
    }

    /**
     * 前序递归
     * 先查询根节点,再查询左子结点,最后查询右子结点
     *
     * @param avlTreeNode  avlTreeNode
     */
    private void preorderRecursion(AVLTreeNode avlTreeNode) {
        preorderResultList.add(avlTreeNode.value);
        if (avlTreeNode.leftNode != null) {
            preorderRecursion(avlTreeNode.leftNode);
        }
        if (avlTreeNode.rightNode != null) {
            preorderRecursion(avlTreeNode.rightNode);
        }
    }

    private void print() {
        preorderResultList.forEach(System.out::println);
    }

    private AVLTreeNode addAvlTreeNode(AVLTreeNode avlTreeNode, AVLTreeNode childTreeNode) {
        int balance = getBalance(avlTreeNode);
        updateDepth(childTreeNode);
        childTreeNode.parentNode = avlTreeNode;
        switch (balance) {
            case 0:
                // 同高时默认从左侧开始添加
                avlTreeNode.leftNode = childTreeNode;
                updateDepth(avlTreeNode);
                return avlTreeNode;
            case 1:
                // 左子结点高,需要右旋
                avlTreeNode.rightNode = childTreeNode;
                return rightRotation(avlTreeNode);
            case -1:
                // 右子结点高,需要左旋
                avlTreeNode.leftNode = childTreeNode;
                return leftRotation(avlTreeNode);
            default:
                return null;
        }
    }

    public static void main(String[] args) {
        AVLTreeNode rootNode = new AVLTreeNode(1);
        AVLTreeNode aNode = new AVLTreeNode(2);
        AVLTreeNode bNode = new AVLTreeNode(3);
        AVLTreeNode cNode = new AVLTreeNode(4);

        AVLTreeNodeTest avlTreeNodeTest = new AVLTreeNodeTest();
        AVLTreeNode result;

        rootNode.leftNode = aNode;
        rootNode.rightNode = bNode;

        avlTreeNodeTest.updateDepth(rootNode);

        result = avlTreeNodeTest.addAvlTreeNode(aNode, cNode);
        avlTreeNodeTest.updateDepth(rootNode);

        assert result != null;

        avlTreeNodeTest.preorderRecursion(result);
        avlTreeNodeTest.print();

    }

}
