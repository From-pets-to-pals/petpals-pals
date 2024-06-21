package com.petpals.persistence.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.jboss.resteasy.spi.touri.MappedBy;

import java.sql.Date;
import java.util.Objects;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "pals")
public class Pals {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "pals_generator")
    @Column(name = "pal_id")
    @SequenceGenerator(name = "pals_generator", sequenceName = "pals_seq", allocationSize = 1)
    private Long id;
    
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "short_name")
    private String shortname;
    
    @NotNull
    @Length(min = 15, max = 15)
    @Column(name = "icadidentifier", nullable = false, columnDefinition = "bpchar(15)")
    private String icadIdentifier;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner_id")
    private Owners owner;
    
    @Column(name = "birthdate")
    private Date birthDate;
    @OneToOne
    @JoinColumn(name= "id")
    @JoinColumn(name= "specie_id")
    private Breeds breed;
    
    @Column(name = "has_passport")
    private Boolean hasPassport;
    @NotNull
    @Column(name = "is_male", nullable = false)
    private boolean isMale;
    
    @Column(name = "is_sterilized")
    private Boolean isSterilized;
    
    @Column(name = "is_vaccinated")
    private Boolean isVaccinated;
    
    @Column(name = "next_vaccine")
    private Date nextVaccine;
    @Column(name = "next_planned_app")
    private Date nextPlannedVetApp;
    
    @Column(name = "reference", columnDefinition = "bpchar(36)")
    private String reference;
    
    @Column(name = "weight", nullable = false, columnDefinition = "numeric(5,3)")
    private double weight;
    
    @Column(name = "height", nullable = false, columnDefinition = "numeric(5,3)")
    private double height;
    
    public Pals() {
    }
    
    public Pals(String name, String shortname, String icadIdentifier, Owners owner, Date birthDate,
                Breeds breed, boolean hasPassport, boolean isMale, boolean isSterilized, boolean isVaccinated,
                Date nextVaccine, Date nextPlannedVetApp, String reference) {
        this.name = name;
        this.shortname = shortname;
        this.icadIdentifier = icadIdentifier;
        this.owner = owner;
        this.birthDate = birthDate;
        this.breed = breed;
        this.hasPassport = hasPassport;
        this.isMale = isMale;
        this.isSterilized = isSterilized;
        this.isVaccinated = isVaccinated;
        this.nextVaccine = nextVaccine;
        this.nextPlannedVetApp = nextPlannedVetApp;
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
    
    public String getIcadIdentifier() {
        return icadIdentifier;
    }
    
    public void setIcadIdentifier(String ICADIdentifier) {
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
    
    
    public Breeds getBreed() {
        return breed;
    }
    
    public void setBreed(Breeds breed) {
        this.breed = breed;
    }
    
    public Boolean getHasPassport() {
        return hasPassport;
    }
    
    public void setMale(boolean male) {
        isMale = male;
    }
    
    public Boolean getSterilized() {
        return isSterilized;
    }
    
    public void setSterilized(Boolean sterilized) {
        isSterilized = sterilized;
    }
    
    public Boolean getVaccinated() {
        return isVaccinated;
    }
    
    public void setVaccinated(Boolean vaccinated) {
        isVaccinated = vaccinated;
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
    
    public Date getNextPlannedVetApp() {
        return nextPlannedVetApp;
    }
    
    public void setNextPlannedVetApp(Date nextPlannedApp) {
        this.nextPlannedVetApp = nextPlannedApp;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pals pals = (Pals) o;
        return isMale == pals.isMale && Double.compare(weight, pals.weight) == 0 && Double.compare(height, pals.height) == 0 && Objects.equals(id, pals.id) && Objects.equals(name, pals.name) && Objects.equals(shortname, pals.shortname) && Objects.equals(icadIdentifier, pals.icadIdentifier) && Objects.equals(owner, pals.owner) && Objects.equals(birthDate, pals.birthDate) && Objects.equals(breed, pals.breed) && Objects.equals(hasPassport, pals.hasPassport) && Objects.equals(isSterilized, pals.isSterilized) && Objects.equals(isVaccinated, pals.isVaccinated) && Objects.equals(nextVaccine, pals.nextVaccine) && Objects.equals(nextPlannedVetApp, pals.nextPlannedVetApp) && Objects.equals(reference, pals.reference);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, shortname, icadIdentifier, owner, birthDate, breed, hasPassport, isMale, isSterilized, isVaccinated, nextVaccine, nextPlannedVetApp, reference, weight, height);
    }
}