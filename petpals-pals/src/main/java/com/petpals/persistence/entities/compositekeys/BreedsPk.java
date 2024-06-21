package com.petpals.persistence.entities.compositekeys;

import com.petpals.persistence.entities.Species;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BreedsPk implements Serializable {
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "breeds_generator")
	@SequenceGenerator(name = "breeds_generator", sequenceName = "breeds_seq", allocationSize = 1 )
	@Column(name = "id")
	public Short id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "specie_id", insertable=false, updatable=false,foreignKey = @ForeignKey(name = "breeds_species_id_fk", value = ConstraintMode.PROVIDER_DEFAULT))
	private Species specie;
	
	public BreedsPk() {
	}
	
	public Short getId() {
		return id;
	}
	
	public void setId(Short id) {
		this.id = id;
	}
	
	public Species getSpecie() {
		return specie;
	}
	
	public void setSpecie(Species specie) {
		this.specie = specie;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BreedsPk breedsPk = (BreedsPk) o;
		return Objects.equals(id, breedsPk.id) && Objects.equals(specie, breedsPk.specie);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, specie);
	}
	
	@Override
	public String toString() {
		return "BreedsPk{" +
					   "id=" + id +
					   ", specie=" + specie +
					   '}';
	}
}
