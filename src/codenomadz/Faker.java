package codenomadz;

import java.util.Random;

public class Faker {
	public String letterify(String letterString) {
		if (letterString == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder(letterString);
		while(sb.indexOf("?") >  0) {
			int index = sb.indexOf("?");
			replaceLetter(sb, index);
		}
		return sb.toString();
	}

	private int randomInt(int seed) {
		Random random = new Random();
		return random.nextInt(seed);
	}

	private void replaceLetter(StringBuilder sb, int index) {
		char randomChar = (char) (randomInt(26) + 'a');
		sb.deleteCharAt(index);
		sb.insert(index, randomChar);
	}

	private void replaceNumber(StringBuilder sb, int index) {
		int randomInt = randomInt(10);
		sb.deleteCharAt(index);
		sb.insert(index, randomInt);
	}

	public String numerify(String numberString) {
		if (numberString == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder(numberString);
		while(sb.indexOf("#") >  0) {
			int index = sb.indexOf("#");
			replaceNumber(sb, index);
		}
		return sb.toString();
	}

	public String bothify(String string) {
		if (string == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder(string);
		for (int i = 0; i < sb.length(); i++) {
			switch (sb.charAt(i)) {
				case '?': {
					replaceLetter(sb, i);
					break;
				}
				case '#': {
					replaceNumber(sb, i);
					break;
				}
				default:
			}
		}
		return sb.toString();
	}

}
