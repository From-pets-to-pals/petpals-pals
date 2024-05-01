package com.petpals.persistence.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "owners")
public class Owners {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "owners_generator")
    @SequenceGenerator(name = "owners_generator", sequenceName = "owners_seq", allocationSize = 1 )
    private Long id;

    @Column(name = "email", nullable = false, unique=true)
    private String mail;

    @Column(name = "device", nullable = false)
    private String device;
    @Column(name = "reference", nullable = false, columnDefinition = "bpchar(36)", unique = true)
    private String reference;


    @Column(name = "location", nullable = false)
    private String location;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id")
    private List<Pals> palsList;

    public Owners() {
    }
    
    public Owners(String mail, String device, String reference, String location) {
        this.mail = mail;
        this.device = device;
        this.reference = reference;
        this.location = location;
    }
    
    @Override
    public String toString() {
        return "Owners{" +
                       "id=" + this.id +
                       ", mail='" + this.mail + '\'' +
                       ", device='" + this.device + '\'' +
                       ", reference='" + this.reference + '\'' +
                       ", location='" + location + '\'' +
                       ", palsList=" + this.palsList +
                       '}';
    }
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Owners owners = (Owners) o;
        return Objects.equals(id, owners.id) && Objects.equals(mail, owners.mail) && Objects.equals(device, owners.device) && Objects.equals(reference, owners.reference) && Objects.equals(location, owners.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mail, device, reference, location);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    public List<Pals> getPalsList() {
        return palsList;
    }
    
    public void setPalsList(List<Pals> palsList) {
        this.palsList = palsList;
    }
}
