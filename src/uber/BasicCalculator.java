package uber;

import java.util.*;

/*
Given a string "3+4", evalaute and output the result.
operators allowed are: +, *, (, )

same as Leetcode problem : https://leetcode.com/problems/basic-calculator/

第二题
Write a function that computes basic arithmetic operations given input as a string separated by spaces. Numbers are positive integers.
i.e. "10 * 2 + 3 / 4" => 20

Easy question with similar problems: see evaluate reverse polish notation and all the basic calculator question

Very similar to this: https://leetcode.com/problems/basic-calculator-ii


@solved
@headtailqueue,  双向链表 stack 不能完全解决

 */
public class BasicCalculator {

	public static void main(String[] args) {
		System.out.println(calculator1("3 + 4"));
		System.out.println(calculator1("3 + 4 * 5"));
		System.out.println(calculator1("3 + 4 * 5 * ( 3 + 2 )"));
		System.out.println(calculator1("3 + 4 * 5 * ( 3 / 2 * 2 * ( 10 + 2 ) )"));
		System.out.println(calculator1("3 + 4 * 5 * ( 3 / 2 * 2 * ( 10 + 2 ) ) - 3")); // bug了
		System.out.println(calculator1("3 + 4 * 5 - ( 3 / 2 + 2 * ( 10 + 2 ) ) - 3"));

		System.out.println(calculate2("0-2147483647"));
	}

	// 1. *, / next is number, directly caculate, put into stack, +/- put into ops
	// 2. ( put into ops,  same as 1, until ),  start to finish pop op and number, until (
	public static double calculator1(String str) {
		Stack<Double> nums = new Stack<>();
		Stack<String> ops = new Stack<>();
		String[] split = str.split(" ");

		for (String s : split) {
			if (s.equals("+") || s.equals("-") || s.equals("(") || s.equals("*") || s.equals("/")) {
				ops.push(s);
			}
			else if (s.equals(")")) {
				while(!ops.peek().equals("(")) {
					double t = nums.pop();
					double t1 = nums.pop();
					nums.push(calculate(t1, t, ops.pop()));
				}
				ops.pop();
				while (ops.peek().equals("*") || ops.peek().equals("/")) {
					double t = nums.pop();
					double t1 = nums.pop();
					nums.push(calculate(t1, t, ops.pop()));
				}
			}
			else {
				// number
				if (ops.isEmpty()) nums.push(Double.valueOf(s));
				else {
					String op = ops.peek();
					if (op.equals("*") || op.equals("/")) {
						ops.pop();
						double t = nums.pop();
						nums.push(calculate(t, Double.valueOf(s), op));
					} else {
						nums.push(Double.valueOf(s));
					}
				}
			}
		}

		if (ops.isEmpty()) return nums.pop();
		while(!ops.isEmpty()) {
			double t = nums.pop();
			double t1 = nums.pop();
			nums.push(calculate(t1, t, ops.pop()));
		}
		return nums.pop();
	}

	public static double calculate(Double a, Double b, String s) {
		switch (s) {
			case "*":
				return a * b;
			case "/":
				return a / b;
			case "-":
				return a - b;
			case "+":
				return a + b;
		}
		return 0;
	}

	public static int calculate(int a, int b, String s) {
		switch (s) {
			case "*":
				return a * b;
			case "/":
				return a / b;
			case "-":
				return a - b;
			case "+":
				return a + b;
		}
		return 0;
	}

	public static int calculate2(String str) {
		LinkedList<Integer> nums = new LinkedList<>();
		LinkedList<String> ops = new LinkedList<>();
		String[] split = str.split(" ");

		List<String> all = new ArrayList<>();
		for (String s : split) {
			if (isNumber(s)) all.add(s);
			else {
				if (s.length() == 1) all.add(s);
				else {
					StringBuilder numbuilder = new StringBuilder();
					for (char c : s.toCharArray()) {
						if (c >= '0' && c <= '9') numbuilder.append(c);
						else {
							if (numbuilder.length() != 0) {
								all.add(numbuilder.toString());
								numbuilder.setLength(0);
							}
							all.add(Character.toString(c));
						}
					}
					if (numbuilder.length() != 0) {
						all.add(numbuilder.toString());
					}
				}
			}
		}

		for (String s : all) {

			if (s.equals("+") || s.equals("-") || s.equals("(") || s.equals("*") || s.equals("/")) {
				ops.addLast(s);
			}
			else if (s.equals(")")) {
				while(!ops.peek().equals("(")) {
					int t = nums.removeLast();
					int t1 = nums.removeLast();
					nums.addLast(calculate(t1, t, ops.removeLast()));
				}
				ops.pop();
				while (ops.peek().equals("*") || ops.peek().equals("/")) {
					int t = nums.removeLast();
					int t1 = nums.removeLast();
					nums.addLast(calculate(t1, t, ops.removeLast()));
				}
			}
			else {
				// number
				if (ops.isEmpty()) nums.push(Integer.valueOf(s));
				else {
					String op = ops.getLast();
					if (op.equals("*") || op.equals("/")) {
						ops.removeLast();
						int t = nums.removeLast();
						nums.addLast(calculate(t, Integer.valueOf(s), op));
					} else {
						nums.addLast(Integer.valueOf(s));
					}
				}
			}
		}

		if (ops.isEmpty()) return nums.pop();
		while(!ops.isEmpty()) {
			Integer t = nums.removeFirst();
			Integer t1 = nums.removeFirst();
			nums.addFirst(calculate(t, t1, ops.removeFirst()));
		}
		return nums.pop();
	}

	public static boolean isNumber(String s) {
		try {
			return Integer.valueOf(s) > 0;
		} catch (Exception e) {
			return false;
		}
	}

	// too worse

	// this is better, calculatorII no requirements aboutl (,) , so it's easier
	static Set<Character> set;

	static {
		set = new HashSet<>();
		set.add('+');
		set.add('-');
		set.add('*');
		set.add('/');
	}

	public static int calculate(String s) {

		int num = 0;
		Stack<Integer> stack = new Stack<>();
		char sign = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				num = num * 10 + c - '0';
			}
			if (set.contains(c) || i == s.length() - 1) {
				if (sign == '+') {
					stack.push(num);
				} else if (sign == '-') {
					stack.push(-num);
				} else if (sign == '*') {
					int tmp = stack.pop() * num;
					stack.push(tmp);
				} else if (sign == '/') {
					int tmp = stack.pop() / num;
					stack.push(tmp);
				}
				sign = c;
				num = 0;
			}
		}
		int result = 0;
		while (!stack.isEmpty()) {
			result += stack.pop();
		}
		return result;
	}


	// faster, O(1) no extra memory,
	public static int calculate3(String s) {

		int answer = 0;
		int sign = 1; // indicates the previous sign is + or -
		int curVal = 0;  // the current Sum prior to next plus/minus sign or the end of the string
		String newS = s.replaceAll(" ", "");
		for (int i = 0; i < newS.length(); i++) {
			char cur = newS.charAt(i);
			if (Character.isDigit(cur)) {
				curVal = curVal * 10 + cur - '0';
			} else {
				if (cur == '+' || cur == '-') {  // if there is a + or -, we can do the operation on the previous sum
					answer += sign * curVal;
					sign = cur == '+' ? 1 : -1;
					curVal = 0;
				} else {
					i++;
					int nextNum = 0;
					while (i < newS.length() && Character.isDigit(newS.charAt(i))) {
						nextNum = nextNum * 10 + newS.charAt(i) - '0';
						i++;
					}
					curVal = cur == '/' ? curVal / nextNum : curVal * nextNum;
					i--;
				}
			}
		}
		answer += sign * curVal;  // since the lase sum will not be calculated in our if statement
		return answer;
	}
}
