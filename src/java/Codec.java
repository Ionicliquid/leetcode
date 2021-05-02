package java;


import javabean.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {

        return serialize(root, "");
    }

    private String serialize(TreeNode root, String s) {
        if (root == null) {
            s += "None,";
        } else {
            s += String.valueOf(root.val) + ",";
            s = serialize(root.left, s);
            s = serialize(root.right, s);
        }
        return s;


    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        LinkedList<String> list = new LinkedList(Arrays.asList(split));
        return deserialize(list);
    }

    private TreeNode deserialize(LinkedList<String> list) {

        if (list.peek() .equals("None")) {

            list.poll();
            return null;

        }
        TreeNode root = new TreeNode(Integer.valueOf(list.poll()));
        root.left = deserialize(list);
        root.right = deserialize(list);
        return root;


    }
}