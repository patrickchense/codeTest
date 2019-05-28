package daily2019;

/*
A Collatz sequence in mathematics can be defined as follows. Starting with any positive integer:

if n is even, the next number in the sequence is n / 2
if n is odd, the next number in the sequence is 3n + 1
It is conjectured that every such sequence eventually reaches the number 1. Test this conjecture.

Bonus: What input n <= 1000000 gives the longest sequence?

@Apple
@easy
@solved
@math
因为每个even 不停的/2 最后肯定1
每个odd，3n+1 == even 所以最后肯定1
所以对的

然后最长的，应该是 1000000 然后那个 odd 3n + 1 = 1000000,  999999/ 3 = 333333 最长

 */
public class D20190501 {

    public static void main(String[] args) {

    }


}
