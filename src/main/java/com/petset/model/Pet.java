package com.petset.model;

import com.petset.enumeration.PetType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "pet", schema = "petsetgo")
public class Pet extends BaseModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String petId;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private PetType petType;
    private Integer age;
    @JoinColumn(name = "breedid")
    private String  breedId;

    @ManyToMany
    @JoinTable(schema = "petsetgo", name = "petusermapping",
            joinColumns = @JoinColumn(name = "petid"),
            inverseJoinColumns = @JoinColumn(name = "userid"))
    private Set<User> owners;

    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        if (petId == null || petId.isEmpty()) {
           this.petId = this.generateId();
        } else {
            this.petId = petId;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBreedId() {
        return breedId;
    }

    public void setBreed(String breedId) {
        this.breedId = breedId;
    }

    public Set<User> getOwners() {
        return owners;
    }

    public void setOwners(Set<User> owners) {
        this.owners = owners;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Pet pet = (Pet) o;
        return Objects.equals(petId, pet.petId) && Objects.equals(name, pet.name) && petType == pet.petType && Objects.equals(age, pet.age) && Objects.equals(breedId, pet.breedId) && Objects.equals(owners, pet.owners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), petId, name, petType, age, breedId, owners);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Pet{");
        sb.append("petId='").append(petId).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", petType=").append(petType);
        sb.append(", age=").append(age);
        sb.append(", breedId='").append(breedId).append('\'');
        sb.append(", owners=").append(owners);
        sb.append('}');
        return sb.toString();
    }
}
