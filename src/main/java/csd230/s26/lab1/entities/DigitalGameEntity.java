package csd230.s26.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class DigitalGameEntity extends VideoGameEntity {
    @Column(name = "storage_size_gb", nullable = true)
    private double storageSizeGb;

    @Column(name = "version")
    private String version;

    public double getStorageSizeGb() {
        return storageSizeGb;
    }

    public void setStorageSizeGb(double storageSizeGb) {
        this.storageSizeGb = storageSizeGb;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public DigitalGameEntity() {
    }

    public DigitalGameEntity(double storageSizeGb, String version) {
        this.storageSizeGb = storageSizeGb;
        this.version = version;
    }

    public DigitalGameEntity(String title, String genre, String platform, double price, double storageSizeGb, String version) {
        super(title, genre, platform, price);
        this.storageSizeGb = storageSizeGb;
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DigitalGameEntity that = (DigitalGameEntity) o;
        return Double.compare(storageSizeGb, that.storageSizeGb) == 0 && Objects.equals(version, that.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), storageSizeGb, version);
    }

    @Override
    public String toString() {
        return "DigitalGameEntity{" +
                "storageSizeGb=" + storageSizeGb +
                ", version='" + version + '\'' +
                '}';
    }
}