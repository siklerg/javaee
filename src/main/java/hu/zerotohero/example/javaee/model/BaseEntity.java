package hu.zerotohero.example.javaee.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
public abstract class BaseEntity implements Serializable {
	@Id
	@GeneratedValue(generator = "ID_GEN", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "ID_GEN", sequenceName = "ID_SEQ", allocationSize = 10)
	private Long id;

	@Version
	private Long version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) { return true; }
		if (o == null || getClass() != o.getClass()) { return false; }
		BaseEntity that = (BaseEntity) o;
		return Objects.equals(getId(), that.getId()) &&
				Objects.equals(getVersion(), that.getVersion());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getVersion());
	}
}
