package com.petpals.persistence.entities

import jakarta.persistence.*
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

@Entity
@Table(name="owners")
class Owners() {
	constructor(reference: String, device: String, location: String, email: String) : this() {
		this.reference = reference
		this.device = device
		this.location = location
		this.email = email
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owners_generator")
	@SequenceGenerator(name = "owners_generator", sequenceName = "owners_seq", allocationSize = 1 )
	@Column(name="id")
	var id : Long? = null
	
	@NotBlank
	@Column(name = "reference",columnDefinition = "bpchar(36)")
	lateinit var reference : String
	
	@NotBlank
	@Column(name = "device")
	lateinit var  device : String
	
	@NotBlank
	@Column(name="location")
	lateinit var location: String
	
	@Email
	@Column(name="email")
	lateinit var email: String
	
	@OneToMany(cascade = arrayOf(CascadeType.ALL))
	private val pals : MutableList<Pals> = ArrayList()
}
