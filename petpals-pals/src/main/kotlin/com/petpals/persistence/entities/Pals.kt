package com.petpals.persistence.entities;

import com.petpals.shared.enums.Species
import jakarta.persistence.*
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Past
import jakarta.validation.constraints.Pattern
import jakarta.validation.constraints.Size
import java.util.Date


@Entity
@Table(name = "pals")
class Pals() {
    constructor(
        name: String,
        shortname: String,
        icadidentifier: String,
        owner: Owners,
        birthDate: Date,
        specie: String,
        breed: String,
        hasPassport: Boolean?,
        isMale: Boolean?,
        isSterilized: Boolean?,
        isVaccinated: Boolean?,
        nextVaccine: Date?,
        nextPlannedApp: Date?,
        palReference: String
    ) : this() {
        this.name = name
        this.shortname = shortname
        this.icadidentifier = icadidentifier
        this.owner = owner
        this.birthDate = birthDate
        this.specie = specie
        this.breed = breed
        this.hasPassport = hasPassport
        this.isMale = isMale
        this.isSterilized = isSterilized
        this.isVaccinated = isVaccinated
        this.nextVaccine = nextVaccine
        this.nextPlannedApp = nextPlannedApp
        this.palReference = palReference
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pals_generator")
    @Column(name = "pal_id")
    @SequenceGenerator(name="pals_generator", sequenceName = "pals_seq", allocationSize = 1)
    var id: Long ? = null;

    @NotNull
    @Column(name = "name", nullable = false)
    lateinit var name : String;

    @Column(name = "short_name")
    lateinit var  shortname :String;

    @NotNull
    @Column(name = "icadidentifier", nullable = false,columnDefinition = "bpchar(15)")
    lateinit var icadidentifier: String;

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var owner: Owners;

    @Column(name = "birthdate")
    lateinit var birthDate: Date;
    @NotNull
    @Column(name="specie", nullable = false)
    lateinit var specie: String;
    @NotNull
    @Column(name="breed", nullable = false)
    lateinit var breed: String;

    @Column(name="has_passport")
    var hasPassport: Boolean? = false;
    @NotNull
    @Column(name="is_male", nullable = false)
    var isMale: Boolean? = false;

    @Column(name="is_sterilized")
    var isSterilized:Boolean? = false

    @Column(name="is_vaccinated")
    var isVaccinated:Boolean?=false

    @Column(name="next_vaccine")
    var nextVaccine:Date?=null;
    @Column(name="next_planned_app")
    var nextPlannedApp: Date?=null;

    @Column(name="reference",columnDefinition = "bpchar(36)")
    lateinit var palReference: String;
}
