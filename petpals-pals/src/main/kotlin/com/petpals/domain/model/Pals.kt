package com.petpals.domain.model

import com.petpals.shared.enums.Species
import java.text.DecimalFormat
import java.text.NumberFormat

class Pals(
    var technicalId: Long?,
    var functionalId: String?,
    var palMedicalInformation: PalMedicalInformation,
    var palIdentityInformation: PalIdentityInformation,
    var palMeasurement: PalMeasurement,
    var owner: Owner,
    hasDied: Boolean
) {
    var isHasDied: Boolean = hasDied

    fun calculatePalDailyRation(): String {
        val formatter: NumberFormat = DecimalFormat("#00")
        val ration = when (palIdentityInformation!!.specie) {
            Species.DOG -> palMeasurement!!.weight * 0.015 * 1000
            Species.CAT -> palMeasurement!!.weight * 40
            Species.FERRET -> 50.0
            else -> throw RuntimeException()
        }
        return String.format("%s grammes", formatter.format(ration))
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val pal = o as Pals

        if (technicalId != pal.technicalId) return false
        if (!palMedicalInformation!!.equals(pal.palMedicalInformation)) return false
        if (!palIdentityInformation!!.equals(pal.palIdentityInformation)) return false
        if (!owner!!.equals(pal.owner)) return false
        return palMeasurement!!.equals(pal.palMeasurement)
    }

    override fun hashCode(): Int {
        var result = if (technicalId != null) technicalId.hashCode() else 0
        result = 31 * result + palMedicalInformation.hashCode()
        result = 31 * result + palIdentityInformation.hashCode()
        result = 31 * result + owner.hashCode()
        result = 31 * result + palMeasurement.hashCode()
        return result
    }

    override fun toString(): String {
        return "Pals{" +
                "technicalId=" + technicalId +
                ", functionalId='" + functionalId + '\'' +
                ", palMedicalInformation=" + palMedicalInformation +
                ", palIdentityInformation=" + palIdentityInformation +
                ", palMeasurement=" + palMeasurement +
                ", owner=" + owner +
                ", hasDied=" + isHasDied +
                '}'
    }
}
