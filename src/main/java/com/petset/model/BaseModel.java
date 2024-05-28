package com.petset.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public class BaseModel implements Serializable {
    String createdBy;
    LocalDateTime createdOn;
    String lastUpdatedBy;
    LocalDateTime lastUpdatedOn;

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }


    @Column(name = "createdon")
    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public LocalDateTime getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(LocalDateTime lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseModel baseModel = (BaseModel) o;
        return Objects.equals(createdBy, baseModel.createdBy) && Objects.equals(createdOn, baseModel.createdOn) && Objects.equals(lastUpdatedBy, baseModel.lastUpdatedBy) && Objects.equals(lastUpdatedOn, baseModel.lastUpdatedOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdBy, createdOn, lastUpdatedBy, lastUpdatedOn);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BaseModel{");
        sb.append("createdBy='").append(createdBy).append('\'');
        sb.append(", createdOn='").append(createdOn).append('\'');
        sb.append(", lastUpdatedBy='").append(lastUpdatedBy).append('\'');
        sb.append(", lastUpdatedOn='").append(lastUpdatedOn).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String generateId() {
        return UUID.randomUUID().toString();
    }
}
