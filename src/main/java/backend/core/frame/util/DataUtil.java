package backend.core.frame.util;

import java.math.BigDecimal;
import java.util.List;

import backend.core.frame.jpa.NamedBean;

public class DataUtil {

	public static String getEnumStringOrEmpty(Enum<?> e) {

		return e == null ? "" : e.toString();
	}

	public static BigDecimal getBigDecimalOrZero(BigDecimal bigDecimal) {

		return bigDecimal == null ? BigDecimal.ZERO : bigDecimal;
	}

	public static Integer getIntegerOrZero(Integer number) {

		return number == null ? 0 : number;
	}
	
	public static Number getNumberOrZero(Number number) {

		return number == null ? 0 : number;
	}

	public static String getNameOrEmpty(NamedBean namedBean) {

		return namedBean == null ? "" : namedBean.getName();
	}

	public static Integer toInteger(String string) {

		Integer integer = 0;

		try {
			integer = Integer.valueOf(string);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return integer;

	}

	public static String unfold(List<? extends NamedBean> list) {
		StringBuilder b = new StringBuilder();
		
		if (list != null) {

			for (int i = 0; i < list.size(); i++) {
				if (i == list.size() - 1) {
					b.append(list.get(i).getName());
				} else {
					b.append(list.get(i).getName() + " - ");
				}
			}
		}
		
		return b.toString();
	}
}
