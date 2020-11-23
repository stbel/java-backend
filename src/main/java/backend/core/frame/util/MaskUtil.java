package backend.core.frame.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MaskUtil {

	public static String unmaskThousend(String text) {

		return text.replace(".", "");
	}

	public static String maskThousend(String text) {

		String masked = "";
		if (text.length() > 2) {

			text = unmaskMoney(text);

			List<String> unitsParts = new ArrayList<>();
			while (text.length() > 3) {
				unitsParts.add(0, text.substring(text.length() - 3, text.length()));
				text = text.substring(0, text.length() - 3);
			}

			if (text.length() > 0) {
				unitsParts.add(0, text);
			}

			for (String string : unitsParts) {
				masked += string + ".";
			}
			masked = masked.substring(0, masked.length() - 1);

		} else {
			masked = text;
		}
		return masked;
	}

	public static String unmaskMoney(BigDecimal bigDecimal) {
		return unmaskMoney(bigDecimal.toString());
	}

	public static String maskMoney(BigDecimal bigDecimal) {
		return maskMoney(bigDecimal.toString());
	}

	public static String unmaskMoney(String text) {

		return text.replace(".", "").replace(",", "");
	}

	public static String maskMoney(String text) {

		String masked = "";
		if (text.length() > 2) {

			text = unmaskMoney(text);

			String cents = text.substring(text.length() - 2, text.length());
			String units = text.substring(0, text.length() - 2);
			List<String> unitsParts = new ArrayList<>();
			while (units.length() > 3) {
				unitsParts.add(0, units.substring(units.length() - 3, units.length()));
				units = units.substring(0, units.length() - 3);
			}

			if (units.length() > 0) {
				unitsParts.add(0, units);
			}

			for (String string : unitsParts) {
				masked += string + ".";
			}
			masked = masked.substring(0, masked.length() - 1);
			masked += "," + cents;
		} else {
			masked = text;
		}
		return masked;
	}
	// public static void main(String[] args) {
	//
	// BigDecimalTextField field = new BigDecimalTextField();
	//
	// test(field, "1");
	// test(field, "12");
	// test(field, "123");
	// test(field, "1234");
	// test(field, "12345");
	// test(field, "123456");
	// test(field, "1234567");
	// test(field, "12345678");
	// test(field, "123456789");
	// test(field, "1234567890");
	// test(field, "12345678901");
	// test(field, "123456789012");
	// test(field, "1234567890123");
	// test(field, "12345678901234");
	// test(field, "123456789012345");
	// test(field, "1234567890123456");
	//
	// }
	//
	// private static void test(BigDecimalTextField field, String val) {
	//
	// String mask = field.mask(val);
	// String unmask = field.unmask(mask);
	// System.out.println(mask);
	// System.out.println(unmask);
	// System.out.println(val.equals(unmask));
	// }
}
