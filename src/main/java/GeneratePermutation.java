import de.javagl.utils.math.combinatorics.MixedRangeCombinationIterable;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutation {

    public static void main(String [] args) {

        // Provider
        Plan plan = new Plan("plan0");

        // GROUP
        Group group0 = new Group("group0");

        Kernel kernel0 = new Kernel("kernel0");

        Clazz clazz0 = new Clazz("clazz0");
        Node node0 = new Node("node0");
        Node node1 = new Node("node1");
        clazz0.nodeList.add(node0);
        clazz0.nodeList.add(node1);
        kernel0.clazzList.add(clazz0);

        Kernel kernel1 = new Kernel("kernel1");

        Clazz clazz1 = new Clazz("clazz1");
        Node node2 = new Node("node2");
        clazz1.nodeList.add(node2);
        Clazz clazz2 = new Clazz("clazz2");
        Node node3 = new Node("node3");
        clazz2.nodeList.add(node3);
        kernel1.clazzList.add(clazz1);
        kernel1.clazzList.add(clazz2);

        // GROUP
        Group group1 = new Group("group1");

        Kernel kernel2 = new Kernel("kernel2");

        Clazz clazz3 = new Clazz("clazz3");
        Node node4 = new Node("node4");
        Node node5 = new Node("node5");
        Node node6 = new Node("node6");
        clazz3.nodeList.add(node4);
        clazz3.nodeList.add(node5);
        clazz3.nodeList.add(node6);
        Clazz clazz4 = new Clazz("clazz4");
        Node node7 = new Node("node7");
        clazz4.nodeList.add(node7);
        kernel2.clazzList.add(clazz3);
        kernel2.clazzList.add(clazz4);

        Kernel kernel3 = new Kernel("kernel3");

        Clazz clazz5 = new Clazz("clazz5");
        Node node8 = new Node("node8");
        Node node9 = new Node("node9");
        clazz5.nodeList.add(node8);
        clazz5.nodeList.add(node9);
        kernel3.clazzList.add(clazz5);

        Kernel kernel4 = new Kernel("kernel4");

        Clazz clazz6 = new Clazz("clazz6");
        Node node10 = new Node("node10");
        clazz6.nodeList.add(node10);
        Clazz clazz7 = new Clazz("clazz7");
        Node node11 = new Node("node11");
        Node node12 = new Node("node12");
        Node node13 = new Node("node13");
        clazz7.nodeList.add(node11);
        clazz7.nodeList.add(node12);
        clazz7.nodeList.add(node13);
        kernel4.clazzList.add(clazz6);
        kernel4.clazzList.add(clazz7);

        // GROUP
        Group group2 = new Group("group2");

        Kernel kernel5 = new Kernel("kernel5");

        Clazz clazz8 = new Clazz("clazz8");
        Node node14 = new Node("node14");
        clazz8.nodeList.add(node14);
        kernel5.clazzList.add(clazz8);

        plan.groupList.add(group0);
        plan.groupList.add(group1);
        plan.groupList.add(group2);

        group0.kernelList.add(kernel0);
        group0.kernelList.add(kernel1);

        group1.kernelList.add(kernel2);
        group1.kernelList.add(kernel3);
        group1.kernelList.add(kernel4);

        group2.kernelList.add(kernel5);

        // 1. Create permutation lists from plan provider
        List<List<Branch>> permutationsList = new ArrayList();
        for(Group group : plan.groupList){

            for(Kernel kernel : group.kernelList) {

                for(Clazz clazz : kernel.clazzList) {

                    List<Branch> clazzList = new ArrayList();

                    for(Node node : clazz.nodeList) {

                        Branch branch = new Branch(plan, group, kernel, clazz, node);

                        // TODO: first filtering based on host, type, clazz nodes
                        clazzList.add(branch);
                    }
                    permutationsList.add(clazzList);
                }
            }
        }

        for(List<Branch> branchList : permutationsList) {
            for(Branch branch : branchList) {
                System.out.printf("Plan: %s, Group: %s, Kernel: %s, Class: %s, Node: %s%n",
                        branch.plan.name, branch.group.name, branch.kernel.name, branch.clazz.name, branch.node.name);
            }
            System.out.printf("%n");
        }

        // 2. Permutation
        //Count permutations:
        int permutationsCounter = 1;
        for(List<Branch> branchList : permutationsList) {
            permutationsCounter *= branchList.size();
        }
        System.out.printf("Permutation count: %d%n", permutationsCounter);
        MixedRangeCombinationIterable<Branch> iterable = new MixedRangeCombinationIterable(permutationsList);
        int permutationCounter = 0;
        for(List<Branch> list : iterable){
            permutationCounter += 1;
            for(Branch branch : list) {
                System.out.printf("Plan: %s, Group: %s, Kernel: %s, Class: %s, Node: %s%n",
                        branch.plan.name, branch.group.name, branch.kernel.name, branch.clazz.name, branch.node.name);
            }
            System.out.printf("%n");
        }

        System.out.printf("Permutation list size: %d%n", permutationCounter);

        // 3. create plan list from branch permutations.
        // during this operation filter plans based on same host on one group.


    }

    private static class Branch {

        public String id = "";
        public Plan plan;
        public Group group;
        public Kernel kernel;
        public Clazz clazz;
        public Node node;

        public Branch(Plan plan, Group group, Kernel kernel, Clazz clazz, Node node) {
            this.plan = plan;
            this.group = group;
            this.kernel = kernel;
            this.clazz = clazz;
            this.node = node;
        }

    }

    private static class Element {
        protected String name;
        protected Element(String name){
            this.name = name;
        }
    }

    private static class Plan extends  Element{
        List<Group> groupList = new ArrayList();
        public Plan(String name) {
            super(name);
        }
    }

    private static class Group extends  Element{
        List<Kernel> kernelList = new ArrayList();
        public Group(String name) {
            super(name);
        }
    }

    private static class Kernel extends  Element{
        List<Clazz> clazzList = new ArrayList();
        public Kernel(String name) {
            super(name);
        }
    }

    private static class Clazz extends  Element{
        List<Node> nodeList = new ArrayList();
        public Clazz(String name) {
            super(name);
        }
    }

    private static class Node extends  Element{
        public Node(String name) {
            super(name);
        }
    }

}
