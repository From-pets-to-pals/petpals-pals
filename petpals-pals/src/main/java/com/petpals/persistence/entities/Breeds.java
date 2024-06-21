package com.petpals.persistence.entities;

import com.petpals.persistence.entities.compositekeys.BreedsPk;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name="breeds")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="specie_id",
		discriminatorType = DiscriminatorType.INTEGER)
public class Breeds {
	@NotBlank
	@Column(name = "name",columnDefinition = "varchar(100)")
	private String name;
	
	@EmbeddedId
	public BreedsPk ido;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public BreedsPk getKey() {
		return ido;
	}
	
	public void setIdo(BreedsPk id) {
		this.ido = id;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Breeds breeds = (Breeds) o;
		return Objects.equals(name, breeds.name) && Objects.equals(ido, breeds.ido);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name, ido);
	}
	
	@Override
	public String toString() {
		return "Breeds{" +
					   "name='" + name + '\'' +
					   ", id=" + ido.id +
					   '}';
	}
}
