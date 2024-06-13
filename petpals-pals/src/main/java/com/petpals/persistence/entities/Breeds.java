package com.petpals.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name="breeds")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="specie_id",
		discriminatorType = DiscriminatorType.INTEGER)
public class Breeds {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "breeds_generator")
	@SequenceGenerator(name = "breeds_generator", sequenceName = "breeds_seq", allocationSize = 1 )
	@Column(name="id")
	private Short id;
	
	@NotBlank
	@Column(name = "name",columnDefinition = "varchar(100)")
	private String name;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "specie_id", insertable=false, updatable=false)
	private Species species;
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Breeds breeds = (Breeds) o;
		return Objects.equals(id, breeds.id) && Objects.equals(name, breeds.name) && Objects.equals(species, breeds.species);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, species);
	}
	
	public Short getId() {
		return id;
	}
	
	public void setId(Short id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Species getSpecies() {
		return species;
	}
	
	public void setSpecies(Species species) {
		this.species = species;
	}
	
	@Override
	public String toString() {
		return "Breeds{" +
					   "id=" + id +
					   ", name='" + name + '\'' +
					   ", species=" + species +
					   '}';
	}
}
