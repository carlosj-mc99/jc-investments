package org.com.jc.investments.entitys;

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
@Table(name="company")
public class Company {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_company")
	private Integer idCompany;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "id_address")//TODO crear relacion con la clase
	private Integer idAddres;
	
	@Column(name = "phone")
	private Integer phone;
	
	@Column(name = "email")
	private String email;
}
