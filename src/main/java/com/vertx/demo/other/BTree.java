package com.vertx.demo.other;

import java.util.ArrayList;
import java.util.List;

/**
 * Binary Tree
 *  https://zhuanlan.zhihu.com/p/25417965?utm_medium=social&utm_source=qq
 */
public class BTree {

    public static void main(String[] args) {
        int[] as = {1,2,3,4,5,6,7,8,9};
        BTree b = new BTree();
        List<TreeNode> nodes = b.initTree(as);
        TreeNode root = nodes.get(0);
        for (TreeNode node:nodes){
            System.out.print(node.data+" ");
        }
        System.out.println();
        System.out.println("----------------- 前序遍历: --------------------");
        b.preOrderTravese(root);
        System.out.println();
        System.out.println("----------------- 中序遍历: --------------------");
        b.midOrderTravese(root);
        System.out.println();
        System.out.println("----------------- 后序遍历: --------------------");
        b.afterOrderTravese(root);
    }

    public List<TreeNode> initTree(int[] arrs){
        List<TreeNode> nodes = new ArrayList<>(2);
        for (int data:arrs){
            nodes.add(new TreeNode(data));
        }
        //每个父节点的index<arrs.length/2-1 确保每个父节点的左右子树节点都存在
        for (int parentIndex = 0;parentIndex<arrs.length/2-1;parentIndex++){
            nodes.get(parentIndex).leftNode = nodes.get(parentIndex*2+1);
            nodes.get(parentIndex).rightNode = nodes.get(parentIndex*2+2);
        }
        int lastParentIndex = arrs.length/2-1;
        nodes.get(lastParentIndex).leftNode = nodes.get(lastParentIndex*2+1);
        //arrs.length%2 !=0 作为判断最后一个父节点的右子树是否存在的判断条件
        if (arrs.length %2 != 0){
            nodes.get(lastParentIndex).rightNode = nodes.get(lastParentIndex*2+2);
        }
        return nodes;
    }


    public void preOrderTravese(TreeNode node){
        if (node == null){
            return;
        }
        System.out.print(node.data + " ");
        preOrderTravese(node.leftNode);
        preOrderTravese(node.rightNode);
    }

    public void midOrderTravese(TreeNode node){
        if (node == null)
            return;
        midOrderTravese(node.leftNode);
        System.out.print(node.data+" ");
        midOrderTravese(node.rightNode);
    }

    public void afterOrderTravese(TreeNode node){
        if (node == null)
            return;
        afterOrderTravese(node.leftNode);
        afterOrderTravese(node.rightNode);
        System.out.print(node.data + " ");
    }
}
