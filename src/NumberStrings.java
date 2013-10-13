public class NumberStrings {

	public static void main(String[] args) {
		String number1 = "1";
		String number2 = "1200";

		System.out.println(addNumberString(number1, number2));
	}

	public static String addNumberString(String s1, String s2) {

		boolean leadingOne = false;
		String finalResult = "";

		for (int i = s1.length() - 1, j = s2.length() - 1; i >= 0 || j >= 0; i--, j--) {
			char a = '0', b = '0';
			int rv = 0;
			String rvString = "";
			boolean aSet = false, bSet = false;

			if (i >= 0) {
				aSet = true;
				a = s1.charAt(i);
			}

			if (j >= 0) {
				bSet = true;
				b = s2.charAt(j);
			}

			if (aSet && bSet) {
				rv = (a - '0') + (b - '0');
				if (leadingOne) {
					rv++;
					leadingOne = false;
				}
				if (rv >= 10)
					leadingOne = true;
			} else if (aSet)
				rv = (a - '0');
			else if (bSet)
				rv = (b - '0');

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
