package backend.core.frame.jpa;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class NamedBean extends Bean {

	private String name;

	@Column(name = "nome")
	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name=name;
	}
}
