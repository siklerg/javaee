package hu.zerotohero.example.javaee;

import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class PersonBean implements Serializable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
