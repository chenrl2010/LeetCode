package zigzagconversion;

public class ZigZagConvert {

	public String convert(String s, int numRows) {

		if (s == null) {
			return null;
		}
		if (numRows == 1) {
			return s;
		}

		StringBuilder result = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			int j = 0;
			int preStep = numRows - 1 - i;
			int postStep = i;
			while (true) {
				if (preStep == 0 || postStep == 0) {
					int index = i + j * (preStep == 0 ? postStep : preStep) * 2;
					if (index < s.length()) {
						result.append(s.charAt(index));
						j++;
						continue;
					} else {
						break;
					}
				}

				int pos = 0;
				if (j % 2 == 1) {
					pos = i + (j / 2) * (numRows - 1) * 2 + preStep * 2;
				} else {
					pos = i + (j / 2) * (numRows - 1) * 2;
				}
				if (pos < s.length()) {
					result.append(s.charAt(pos));
				} else {
					break;
				}
				j++;
			}
		}
		return result.toString();
	}

	public static void main(String[] args) {
		String s = "ABCDEF";
		int numRows = 4;
		System.out.println(new ZigZagConvert().convert(s, numRows));

	}
}
