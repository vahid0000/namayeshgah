package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity<T extends Serializable> {

	abstract T getId();

	abstract void setId(T id);

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!obj.getClass().getName().equals(this.getClass().getName()))
			return false;
		BaseEntity<?> baseEntity = (BaseEntity<?>) obj;
		if (baseEntity.getId().equals(this.getId()))
			return true;
		return false;
	}

}
