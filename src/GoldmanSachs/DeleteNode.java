package GoldmanSachs;

import util.Node;

/*
https://www.geeksforgeeks.org/given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/

Given a pointer to a node to be deleted, delete the node. Note that we don’t have pointer to head node.

solution:
Fast solution is to copy the data from the next node to the node to be deleted and delete the next node. Something like following.

    // Find next node using next pointer
    struct Node *temp  = node_ptr->next;

    // Copy data of next node to this node
    node_ptr->data  = temp->data;

    // Unlink next node
    node_ptr->next  = temp->next;

    // Delete next node
    free(temp);


 */
public class DeleteNode {

    public  void deleteNode(Node Node_ptr)
    {
        Node temp = Node_ptr.next;
        Node_ptr.data = temp.data;
        Node_ptr.next = temp.next;
        temp = null;
    }
}
