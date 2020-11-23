package backend.core.frame.jpa;

public class Filter {

	private final String field;

	private final Object value;

	public Filter(String field, Object value) {

		this.field = field;
		this.value = value;
	}

	public String getField() {

		return field;
	}

	public Object getValue() {

		return value;
	}

	public static Filter f(String field, Object value) {

		return new Filter(field, value);
	}
	
	public static NavFilter f(String navigation, String field, Object value) {

		return new NavFilter(navigation, field, value);
	}
}
