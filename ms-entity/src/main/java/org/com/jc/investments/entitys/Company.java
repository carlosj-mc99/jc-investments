package org.com.jc.investments.entitys;

import org.hibernate.annotations.ColumnDefault;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
	
	@Column(name = "name", length = 55)
	private String name;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_address",nullable = false,foreignKey = @ForeignKey(name = "FK_COMPANY_ADDRESS"))
	private Address address;
	
	@Column(name = "phone", length = 15)
	private Integer phone;
	
	@Column(name = "email",length = 55)
	private String email;
	
	@Column(name = "enabled")
	@ColumnDefault(value = "false")
	private boolean enabled;
}
