public class NumberStringEasierMethod {

	public static void main(String[] args) {
		String number1 = "1";
		String number2 = "9999999999999999999999999999999999999999999999999999999999999999999999";
		System.out.println(addNumberString(number1, number2));
	}

	public static String addNumberString(String s1, String s2) {

		boolean leadingOne = false;
		String finalResult = "";

		int stringLength = (s1.length() > s2.length()) ? s1.length() : s2.length();

		if (s1.length() < stringLength) {
			int loopLength = stringLength - s1.length();
			for (int i = 0; i < loopLength; i++)
				s1 = "0" + s1;
		} else {
			int loopLength = stringLength - s2.length();
			for (int i = 0; i < loopLength; i++)
				s2 = "0" + s2;
		}

		for (int i = stringLength - 1; i >= 0; i--) {

			char a = '0', b = '0';
			int rv = 0;
			String rvString = "";

			a = s1.charAt(i);
			b = s2.charAt(i);

			rv = (a - '0') + (b - '0');

			if (leadingOne) {
				rv++;
				leadingOne = false;
			}
			if (rv >= 10)
				leadingOne = true;

			rvString = "" + rv;
			if (leadingOne)
				finalResult = rvString.charAt(1) + finalResult;
			else
				finalResult = rvString.charAt(0) + finalResult;
		}

		if (leadingOne)
			finalResult = "1" + finalResult;
		return finalResult;
	}
}
