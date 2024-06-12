package com.petpals.persistence.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name="breeds")
public class Species {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "species_generator")
	@SequenceGenerator(name = "species_generator", sequenceName = "species_id_seq", allocationSize = 1 )
	@Column(name="id")
	private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToOne(mappedBy = "species")
	private Breeds breed;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Breeds getBreed() {
		return breed;
	}
	
	public void setBreed(Breeds breed) {
		this.breed = breed;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Species species = (Species) o;
		return Objects.equals(id, species.id) && Objects.equals(name, species.name) && Objects.equals(breed, species.breed);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, breed);
	}
}
