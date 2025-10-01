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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_address")
	private Integer idAddress;
	
	@Column(name = "street", length = 255)
	private String street;
	
	@Column(name = "internal_number", length = 30)
	private String internalNumber;
	
	@Column(name = "external_number", length = 30)
	private String externalNumber;
	
	@Column(name = "suburb", length = 255)
	private String suburb;

	@Column(name = "enabled")
	@ColumnDefault(value = "false")
	private boolean enabled;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_state",nullable = false,foreignKey = @ForeignKey(name="FK_ADDRESS_STATE"))
	private State state;
	
	@Column(name = "postal_code", length = 30)
	private String postalCode;
	
}
