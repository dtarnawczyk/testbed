public class TreeHackerrank {

    public static void main(String[] args) {

        Node root = new Node();
        root.data = 3;

        Node left = new Node();
        left.data = 5;

        root.left = left;

        Node leftleft = new Node();
        leftleft.data = 1;

        left.left = leftleft;

        Node leftright = new Node();
        leftright.data = 4;

        left.right = leftright;

        Node right = new Node();
        right.data = 2;

        root.right = right;

        Node rightleft = new Node();
        rightleft.data = 6;

        right.left = rightleft;

//        preOrder(root);
        postOrder(root);
    }

    static void postOrder (Node root) {
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    static void preOrder(Node root) {

        if (root != null){
            System.out.print(root.data+" ");
        }

        if(root.left != null)
            traverseLeftPreOrder(root.left);

        if(root.right != null)
            traverseRightPreOrder(root.right);

    }

    static void traverseLeftPreOrder(Node left) {

        System.out.print(left.data+" ");

        if(left.left != null)
            traverseLeftPreOrder(left.left);

        if(left.right != null)
            traverseRightPreOrder(left.right);

    }

    static void traverseRightPreOrder(Node right) {

        System.out.print(right.data+" ");

        if(right.left != null)
            traverseLeftPreOrder(right.left);

        if(right.right != null)
            traverseRightPreOrder(right.right);

    }

    static class Node {
        int data;
        Node left;
        Node right;
    }

}