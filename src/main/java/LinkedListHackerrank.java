import java.util.*;

public class LinkedListHackerrank {
    public static void main(String [] args) {
        LinkedList<Node> list = new LinkedList<>();
        Node head = new Node();
        head.data = 1;
        Node node = new Node();
        node.data = 2;
        head.next = node;
        Node head2 = insert(head, 3, 2);
//        print(head2);
//        System.out.println("After delete: ");
//        Node head3 = delete(head2, 2);
//        print(head3);

//        Node head3 = reverse(head2);
//        print(head3);
//        System.out.println();
        Node headB = new Node();
        headB.data = 1;
        Node nodeB = new Node();
        nodeB.data = 2;
        headB.next = nodeB;
        Node head2B = insert(headB, 3, 2);
//        System.out.println(compare(head2, headB));
//        print(head2B);
        Node head3 = mergeLists(head2, head2B);
//        print(head3);

//          System.out.println(getNode(head2, 0));
        System.out.println();
        Node head4 = removeDuplicates(head3);

        Node headCycle = new Node();
        headCycle.data = 1;
        Node node1Cycle = new Node();
        node1Cycle.data = 2;
        headCycle.next = node1Cycle;
        Node node2Cycle = new Node();
        node2Cycle.data = 3;
        node1Cycle.next = node2Cycle;
        node2Cycle.next = node1Cycle;
        System.out.println(hasCycle(headCycle));


    }

    static boolean hasCycle(Node head) {
        if(head != null) {
            Node node = head;
            for(int i=0; i <= 100; i++){
                if (node.next == null){
                    return false;
                } else {
                    node = node.next;
                }
            }
            return true;
        } else { return false; }
    }

    static Node removeDuplicates(Node head) {
        if(head != null) {

            List<Integer> list = new ArrayList();
            Node node = head;
            while (true) {
                if(!list.contains(node.data))
                    list.add(node.data);
                if (node.next == null){
                    break;
                } else {
                    node = node.next;
                }
            }
            Node newHead = new Node();
            Node current = newHead;
            int position = 0;
            while (true){
                if (position < list.size()) {
                    int data = list.get(position);
                    Node newNode = new Node();
                    current.data = data;
                    position += 1;
                    if (position < list.size()) {
                        current.next = newNode;
                    } else {
                        current.next = null;
                    }
                    current = current.next;
                } else {
                    break;
                }
            }
            return newHead;
        } else { return null; }
    }

    static int getNode(Node head, int positionFromTail) {

        if(head != null) {

            List<Node> list = new ArrayList();
            Node node = head;
            while (true) {
                list.add(node);
                if (node.next == null){
                    break;
                } else {
                    node = node.next;
                }
            }
            Collections.reverse(list);

            for (int i=0; i < list.size(); i++) {
                if(i == positionFromTail) {
                    return list.get(i).data;
                }
            }
            return 0;
        } else { return 0; }

    }

    static Node mergeLists(Node headA, Node headB) {
        Node currentA = headA;
        Node currentB = headB;
        Node newHead = new Node();
        Node newNode = newHead;
        while (true) {
            if(currentA == null) {
                newNode.data = currentB.data;
                currentB = currentB.next;
                newNode.next = currentB;
                if(currentB == null) {
                    break;
                }
                newNode = newNode.next;
            } else if (currentB == null) {
                newNode.data = currentA.data;
                currentA = currentA.next;
                newNode.next = currentA;
                if(currentA == null) {
                    break;
                }

                newNode = newNode.next;
            } else {
                if(currentA.data < currentB.data || currentA.data == currentB.data) {
                    newNode.data = currentA.data;
                    currentA = currentA.next;
                } else {
                    newNode.data = currentB.data;
                    currentB = currentB.next;
                }

                if(currentA == null) {
                    if(newNode.data < currentB.data || newNode.data == currentB.data) {

                    } else {
                        newNode.data = currentB.data;
                        currentB = currentB.next;
                    }
                    if(currentB == null) {
                        break;
                    }
                    newNode.next = currentB;
                    newNode = newNode.next;

                } else if (currentB == null) {
                    if(newNode.data < currentA.data || newNode.data == currentA.data) {

                    } else {
                        newNode.data = currentA.data;
                        currentA = currentB.next;
                    }
                    if(currentA == null) {
                        break;
                    }
                    newNode.next = currentA;
                    newNode = newNode.next;
                } else {
                    if (currentA.data < currentB.data || currentA.data == currentB.data) {
                        newNode.next = currentA;
                    } else {
                        newNode.next = currentB;
                    }
                    newNode = newNode.next;
                }
            }
        }
        return newHead;
    }

    static int compare(Node headA, Node headB) {
        if(headA == null && headB == null) {
            return 1;
        } else if( headA == null || headB == null) {
            return 0;
        } else {
            Node currentA = headA;
            Node currentB = headB;
            while (true) {
                if((currentA.data == currentB.data)){
                    currentA = currentA.next;
                    currentB = currentB.next;
                    if (currentA == null && currentB == null){
                        return 1;
                    } else if (currentA == null || currentB == null) {
                        return 0;
                    } else {
                    }
                } else {
                    return 0;
                }
            }
        }
    }

    static Node reverse(Node head) {
        if(head != null) {
            List<Node> list = new ArrayList();
            Node node = head;
            while (true) {
                list.add(node);
                if (node.next == null){
                    break;
                } else {
                    node = node.next;
                }
            }
            Collections.reverse(list);
            Node newHead = new Node();
            Node current = newHead;
            int position = 0;
            while (true){
                if (position < list.size()) {
                    Node n = list.get(position);
                    current.data = n.data;
                    position += 1;
                    if (position < list.size()) {
                        current.next = list.get(position);
                    } else {
                        current.next = null;
                    }
                    current = current.next;
                } else {
                    break;
                }
            }
            return newHead;
        } else return null;
    }

    static void reversePrint(Node head) {
        if(head != null) {
            List<Integer> list = new ArrayList();
            Node current = head;
            while (true) {
                list.add(current.data);
                if (current.next == null){
                    break;
                } else {
                    current = current.next;
                }
            }
            Collections.reverse(list);
            for(Integer i : list){
                System.out.println(i);
            }
        }
    }

    static Node delete(Node head, int position) {
        Node current = head;
        Node parent = head;
        int positionCounter = 0;
        while(true) {
            if(position == 0) {
                return current.next;
            } else if (positionCounter == position) {
                if(current == null) break;
                Node nextNode = current.next;
                parent.next = nextNode;
                break;
            } else {
                if(current == null) break;
                parent = current;
                current = current.next;
                positionCounter += 1;
            }

        }
        return head;
    }

    static Node insert(Node head, int data, int position) {
        Node newNode = new Node();
        newNode.data = data;
        int positionCounter = 0;
        Node current = head;
        Node parent = head;
        while (true) {
            if (position == 0) {
                newNode.next = head;
                return newNode;
            } else if(positionCounter == position) {
                parent.next = newNode;
                newNode.next = current;
                break;
            } else {
                parent = current;
                if(current == null) break;
                current = current.next;
                positionCounter +=1;
            }
        }
        return head;
    }

    static Node insertHead(Node head, int data) {
        Node newHead = new Node();
        newHead.data = data;
        newHead.next = head;
        return newHead;
    }

    static Node insert(Node head, int data) {
        Node newNode = new Node();
        newNode.data = data;
        if(head == null) {
            return newNode;
        } else {
            Node node = head;
            while (true) {
                if(node.next == null) {
                    node.next = newNode;
                    break;
                } else {
                    node = node.next;
                }
            }
            return head;
        }
    }

    public static void print(Node head) {
        if(head != null) {
            Node current = head;
            while (true) {
                System.out.println(current.data);
                if (current.next == null){
                    break;
                } else {
                    current = current.next;
                }
            }
        }
    }

    static class Node {
        int data;
        Node next;
    }
}
