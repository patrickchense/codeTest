package daily2019;

import java.util.Iterator;

/*
Given an iterator with methods next() and hasNext(), create a wrapper iterator, PeekableInterface, which also implements peek(). peek shows the next element that would be returned on next().

Here is the interface:

class PeekableInterface(object):
    def __init__(self, iterator):
        pass

    def peek(self):
        pass

    def next(self):
        pass

    def hasNext(self):
        pass

@Google
@answered
@design

https://blog.csdn.net/u010002184/article/details/77879288

 */
public class D20190220 {

    class PeekableInterface <T> {
        Iterator<T> it;
        T next;
        public T peek() {
            return next;
        }

        public boolean hasNext() {
            return it.hasNext();
        }

        public T next() {
            T res = next;
            next = it.hasNext() ? it.next() : null;
            return res;
        }

    }
}
