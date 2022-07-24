//Time : O(n)
//Space : O(1)

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Node curr = head;
        // first pass create new nodes
        while (curr != null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = curr.next.next;
        }

        curr = head;
        // change random pointers
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        curr = head;
        Node copycurr = head.next;
        Node copynew = copycurr;
        // third change back pointers
        while (curr != null) {
            curr.next = curr.next.next;
            if (copycurr.next != null) {
                copycurr.next = copycurr.next.next;
            }
            curr = curr.next;
            copycurr = copycurr.next;
        }
        return copynew;

    }
}