package edu.sharif.ce.ood.taghi.namayeshgah.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "role")
public class RoleEntity extends BaseEntity<Integer> {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "constRole")
	private ConstRoleEntity constRoleEntity;

	@ManyToOne
	@JoinColumn(name = "showPlace")
	private ShowPlaceEntity showPlace;

	@ManyToOne
	@JoinColumn(name = "user")
	private UserEntity user;

	public ConstRoleEntity getConstRoleEntity() {
		return constRoleEntity;
	}

	public void setConstRoleEntity(ConstRoleEntity constRoleEntity) {
		this.constRoleEntity = constRoleEntity;
	}

	public ShowPlaceEntity getShowPlace() {
		return showPlace;
	}

	public void setShowPlace(ShowPlaceEntity showPlace) {
		this.showPlace = showPlace;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;

	}

}
