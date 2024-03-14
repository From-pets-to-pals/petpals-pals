package com.petpals.pals.model.pal;


import java.sql.Date;
import java.util.List;
import java.util.Objects;

public record PalValueObject(
        String name,
        Date birthDate,
        String specie,
        String race,
        Long owner,
        String icadIdentifier,
        boolean isVaccinated,
        boolean isMale,
        Double weight,
        Double height,
        String id,
        List<String>medicalHistory,
        Date nextVaccine,
        Date nextPlannedVetApp,
        boolean isSterilized,
        boolean hasPassport
) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PalValueObject that = (PalValueObject) o;

        if (isVaccinated != that.isVaccinated) return false;
        if (isMale != that.isMale) return false;
        if (isSterilized != that.isSterilized) return false;
        if (hasPassport != that.hasPassport) return false;
        if (!name.equals(that.name)) return false;
        if (!birthDate.equals(that.birthDate)) return false;
        if (!specie.equals(that.specie)) return false;
        if (!race.equals(that.race)) return false;
        if (!owner.equals(that.owner)) return false;
        if (!icadIdentifier.equals(that.icadIdentifier)) return false;
        if (!weight.equals(that.weight)) return false;
        if (!height.equals(that.height)) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(medicalHistory, that.medicalHistory))
            return false;
        if (!Objects.equals(nextVaccine, that.nextVaccine)) return false;
        return Objects.equals(nextPlannedVetApp, that.nextPlannedVetApp);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + birthDate.hashCode();
        result = 31 * result + specie.hashCode();
        result = 31 * result + race.hashCode();
        result = 31 * result + owner.hashCode();
        result = 31 * result + icadIdentifier.hashCode();
        result = 31 * result + (isVaccinated ? 1 : 0);
        result = 31 * result + (isMale ? 1 : 0);
        result = 31 * result + weight.hashCode();
        result = 31 * result + height.hashCode();
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (medicalHistory != null ? medicalHistory.hashCode() : 0);
        result = 31 * result + (nextVaccine != null ? nextVaccine.hashCode() : 0);
        result = 31 * result + (nextPlannedVetApp != null ? nextPlannedVetApp.hashCode() : 0);
        result = 31 * result + (isSterilized ? 1 : 0);
        result = 31 * result + (hasPassport ? 1 : 0);
        return result;
    }
}
