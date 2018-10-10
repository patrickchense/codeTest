package dailyproblem;
/*
An XOR linked list is a more memory efficient doubly linked list.
Instead of each node holding next and prev fields, it holds a field named both,
 which is an XOR of the next node and the previous node. Implement an XOR linked list;
 it has an add(element) which adds the element to the end, and a get(index) which returns the node at index.

If using a language that has no pointers (such as Python), you can assume you have access to get_pointer
and dereference_pointer functions that converts between nodes and memory addresses.


https://www.geeksforgeeks.org/xor-linked-list-a-memory-efficient-doubly-linked-list-set-1/

normal:
Node A:
npx = 0 XOR add(B) // bitwise XOR of zero and address of B

Node B:
npx = add(A) XOR add(C) // bitwise XOR of address of A and address of C

Node C:
npx = add(B) XOR add(D) // bitwise XOR of address of B and address of D

Node D:
npx = add(C) XOR 0 // bitwise XOR of address of C and 0

XOR:
A        B         C         D         E  ...
   <–>  A⊕C  <->  B⊕D  <->  C⊕E  <->
link(B) = addr(A)⊕addr(C), link(C) = addr(B)⊕addr(D), ...

 i.e.  addr(D) = link(C) ⊕ addr(B)
    where
          link(C) = addr(B)⊕addr(D)
     so
          addr(D) = addr(B)⊕addr(D) ⊕ addr(B)

          addr(D) = addr(B)⊕addr(B) ⊕ addr(D)
    since
           X⊕X = 0
           => addr(D) = 0 ⊕ addr(D)
    since
           X⊕0 = x
           => addr(D) = addr(D)
    The XOR operation cancels addr(B) appearing twice in the equation and all we are left with is the addr(D).

    TODO
 */
public class Daily20181010 {

    class XORNode {
        int val;
        XORNode both;


    }


}
