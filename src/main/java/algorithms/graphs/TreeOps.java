package algorithms.graphs;

public class TreeOps {

    public static void main(String[] args) {


        // tworzenie drzewa niezrównoważonego
        TreeNode treeNode = exampleUnbalancedTree();

        System.out.println(isBalanced(treeNode));

        TreeNode btreeNode = exampleBalancedTree();

        System.out.println(isBalanced(btreeNode));
    }

    private static TreeNode exampleBalancedTree() {
        TreeNode root = new TreeNode();
        root.data = 5;

        TreeNode three = new TreeNode();
        three.data = 3;
        TreeNode six = new TreeNode();
        six.data = 6;

        root.left = three;
        root.right = six;

        TreeNode two = new TreeNode();
        two.data = 2;

        TreeNode four = new TreeNode();
        four.data = 4;

        three.left = two;
        three.right = four;

        TreeNode one = new TreeNode();
        one.data = 1;
        TreeNode seven = new TreeNode();
        seven.data = 7;

        six.left = one;
        six.right = seven;

        TreeNode eight = new TreeNode();
        eight.data = 8;

        seven.right = eight;

        return root;
    }

    private static TreeNode exampleUnbalancedTree (){

        TreeNode root = new TreeNode();
        root.data = 5;

        TreeNode three = new TreeNode();
        three.data = 3;
        TreeNode six = new TreeNode();
        six.data = 6;

        root.left = three;
        root.right = six;

        TreeNode two = new TreeNode();
        two.data = 2;

        three.left = two;

        TreeNode one = new TreeNode();
        one.data = 1;

        two.left = one;

        TreeNode four = new TreeNode();
        four.data = 4;

        six.left = four;

        TreeNode seven =  new TreeNode();
        seven.data = 7;

        six.right = seven;

        TreeNode eight = new TreeNode();
        eight.data = 8;

        seven.right = eight;

//        TreeNode nine = new TreeNode();
//        nine.data = 9;
//
//        eight.right = nine;

        return root;
    }

    private static boolean isBalanced(TreeNode treeNode) {

        if(treeNode.left != null && treeNode.right != null) {

            boolean isLeftBalanced = isBalanced(treeNode.left);
            boolean isRightBalanced = isBalanced(treeNode.right);
            if(!isLeftBalanced || !isRightBalanced){
                return false;
            }

        } else if(treeNode.left != null && treeNode.right == null) {

            if(treeNode.left.left != null || treeNode.left.right != null) {
                return false;
            }

        } else if ( treeNode.left == null && treeNode.right != null) {

            if(treeNode.right.left != null || treeNode.right.right != null) {
                return false;
            }

        } else if (treeNode.left == null && treeNode.right == null) {
            return true;
        }



        return true;
    }



    private static class TreeNode {
        private int data;
        private TreeNode left;
        private TreeNode right;
    }
}
