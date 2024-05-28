package com.petset.model;

import com.petset.enumeration.SheddingLevel;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "breed", schema = "petsetgo")
public class Breed extends BaseModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String breedId;
    private String breedName;
    private boolean apartmentFriendly;
    private boolean familyFriendly;
    @Enumerated(value = EnumType.STRING)
    private SheddingLevel sheddingLevel;

    public Breed() {
        this.setBreedId(null);
    }

    public String getBreedId() {
        return breedId;
    }

    public void setBreedId(String breedId) {
        if (breedId == null || breedId.isEmpty()) {
            this.breedId = this.generateId();
        } else {
            this.breedId = breedId;
        }
    }

    public String getBreedName() {
        return breedName;
    }

    public void setBreedName(String breedName) {
        this.breedName = breedName;
    }

    public boolean isApartmentFriendly() {
        return apartmentFriendly;
    }

    public void setApartmentFriendly(boolean apartmentFriendly) {
        this.apartmentFriendly = apartmentFriendly;
    }

    public boolean isFamilyFriendly() {
        return familyFriendly;
    }

    public void setFamilyFriendly(boolean familyFriendly) {
        this.familyFriendly = familyFriendly;
    }

    public SheddingLevel getSheddingLevel() {
        return sheddingLevel;
    }

    public void setSheddingLevel(SheddingLevel sheddingLevel) {
        this.sheddingLevel = sheddingLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Breed breed = (Breed) o;
        return apartmentFriendly == breed.apartmentFriendly && familyFriendly == breed.familyFriendly && Objects.equals(breedId, breed.breedId) && Objects.equals(breedName, breed.breedName) && sheddingLevel == breed.sheddingLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(breedId, breedName, apartmentFriendly, familyFriendly, sheddingLevel);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Breed{");
        sb.append("breedId='").append(breedId).append('\'');
        sb.append(", breedName='").append(breedName).append('\'');
        sb.append(", apartmentFriendly=").append(apartmentFriendly);
        sb.append(", familyFriendly=").append(familyFriendly);
        sb.append(", sheddingLevel=").append(sheddingLevel);
        sb.append('}');
        return sb.toString();
    }
}
