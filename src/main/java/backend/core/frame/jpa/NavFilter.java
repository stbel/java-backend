package backend.core.frame.jpa;

public class NavFilter extends Filter{

	private final String navigation;

	public NavFilter(String navigation, String field, Object value) {

		super(field, value);
		this.navigation = navigation;
	}

	public String getNavigation() {

		return navigation;
	}

}
