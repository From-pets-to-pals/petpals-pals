package com.petpals.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import java.sql.Date;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "pals")
public class Pals {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "pals_generator")
    @Column(name = "pal_id")
    @SequenceGenerator(name="pals_generator", sequenceName = "pals_seq", allocationSize = 1)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "short_name")
    private String shortname;

    @NotNull
    @Length(min=15, max=15)
    @Column(name = "icadidentifier", nullable = false,columnDefinition = "bpchar(15)")
    private String icadIdentifier;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owners owner;

    @Column(name = "birthdate")
    private Date birthDate;
    @NotNull
    @Column(name="specie", nullable = false)
    private String specie;
    @NotNull
    @Column(name="breed", nullable = false)
    private String breed;

    @Column(name="has_passport")
    private Boolean hasPassport;
    @NotNull
    @Column(name="is_male", nullable = false)
    private boolean isMale;

    @Column(name="is_sterilized")
    private Boolean isSterilized;

    @Column(name="is_vaccinated")
    private Boolean isVaccinated;

    @Column(name="next_vaccine")
    private Date nextVaccine;
    @Column(name="next_planned_app")
    private Date nextPlannedApp;

    @Column(name="reference",columnDefinition = "bpchar(36)")
    private String reference;
    
    @Column(name="weight", nullable = false, columnDefinition = "numeric(5,3)")
    private double weight;
    
    @Column(name="height",nullable = false, columnDefinition = "numeric(5,3)")
    private double height;
    
    public Pals() {
    }
    
    public Pals(String name, String shortname, String icadIdentifier, Owners owner, Date birthDate, String specie, String breed, boolean hasPassport, boolean isMale, boolean isSterilized, boolean isVaccinated, Date nextVaccine, Date nextPlannedApp, String reference) {
        this.name = name;
        this.shortname = shortname;
        this.icadIdentifier = icadIdentifier;
        this.owner = owner;
        this.birthDate = birthDate;
        this.specie = specie;
        this.breed = breed;
        this.hasPassport = hasPassport;
        this.isMale = isMale;
        this.isSterilized = isSterilized;
        this.isVaccinated = isVaccinated;
        this.nextVaccine = nextVaccine;
        this.nextPlannedApp = nextPlannedApp;
        this.reference = reference;
    }
    
   
    
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

    public String getICADIdentifier() {
        return icadIdentifier;
    }

    public void setICADIdentifier(String ICADIdentifier) {
        this.icadIdentifier = ICADIdentifier;
    }

    public void setOwner(Owners owner) {
        this.owner = owner;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSpecie() {
        return specie;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Boolean isHasPassport() {
        return hasPassport;
    }

    public void setHasPassport(Boolean hasPassport) {
        this.hasPassport = hasPassport;
    }

    public boolean isMale() {
        return isMale;
    }
    
    public void setIsMale(boolean male) {
        isMale = male;
    }
    
    public void setIsSterilized(Boolean sterilized) {
        isSterilized = sterilized;
    }
    
    public void setIsVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
    }
    
    public boolean isSterilized() {
        return isSterilized;
    }


    public boolean isVaccinated() {
        return isVaccinated;
    }


    public Date getNextVaccine() {
        return nextVaccine;
    }

    public void setNextVaccine(Date nextVaccine) {
        this.nextVaccine = nextVaccine;
    }

    public Date getNextPlannedApp() {
        return nextPlannedApp;
    }

    public void setNextPlannedApp(Date nextPlannedApp) {
        this.nextPlannedApp = nextPlannedApp;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Owners getOwner() {
        return owner;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String palReference) {
        this.reference = palReference;
    }
    
    public String getIcadIdentifier() {
        return icadIdentifier;
    }
    
    public void setIcadIdentifier(String icadidentifier) {
        this.icadIdentifier = icadidentifier;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public double getHeight() {
        return height;
    }
    
    public void setHeight(double height) {
        this.height = height;
    }
    
    @Override
    public String toString() {
        return "Pals{" +
                       "id=" + id +
                       ", name='" + name + '\'' +
                       ", shortname='" + shortname + '\'' +
                       ", icadidentifier='" + icadIdentifier + '\'' +
                       ", owner=" + owner +
                       ", birthDate=" + birthDate +
                       ", specie='" + specie + '\'' +
                       ", breed='" + breed + '\'' +
                       ", hasPassport=" + hasPassport +
                       ", isMale=" + isMale +
                       ", isSterilized=" + isSterilized +
                       ", isVaccinated=" + isVaccinated +
                       ", nextVaccine=" + nextVaccine +
                       ", nextPlannedApp=" + nextPlannedApp +
                       ", reference='" + reference + '\'' +
                       ", weight=" + weight +
                       ", height=" + height +
                       '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pals pals = (Pals) o;
        return hasPassport == pals.hasPassport && isMale == pals.isMale && isSterilized == pals.isSterilized && isVaccinated == pals.isVaccinated && Objects.equals(id, pals.id) && Objects.equals(name, pals.name) && Objects.equals(shortname, pals.shortname) && Objects.equals(icadIdentifier, pals.icadIdentifier) && Objects.equals(owner, pals.owner) && Objects.equals(birthDate, pals.birthDate) && Objects.equals(specie, pals.specie) && Objects.equals(breed, pals.breed) && Objects.equals(nextVaccine, pals.nextVaccine) && Objects.equals(nextPlannedApp, pals.nextPlannedApp) && Objects.equals(reference, pals.reference) && Objects.equals(weight, pals.weight) && Objects.equals(height, pals.height);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortname, icadIdentifier, owner, birthDate, specie, breed, hasPassport, isMale, isSterilized, isVaccinated, nextVaccine, nextPlannedApp, reference, weight, height);
    }
}
