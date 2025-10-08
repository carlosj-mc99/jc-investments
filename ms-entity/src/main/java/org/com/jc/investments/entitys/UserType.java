package org.com.jc.investments.entitys;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="user_type")
public class UserType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user_type")
	private Integer idUserType;
	
	@Column(name = "name", length = 55)
	private String name;

	@Column(name = "enabled")
	@ColumnDefault(value = "false")
	private boolean enabled;
}
