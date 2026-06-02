package csd230.s26.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class PhysicalGameEntity extends VideoGameEntity {
    @Column(name = "media_type")
    private String mediaType;

    @Column(name = "number_of_discs", nullable = true)
    private int numberOfDiscs;

    @Column(name = "copies", nullable = true)
    private int copies;

    @Column(name = "price", nullable = true)
    private double price;

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public int getNumberOfDiscs() {
        return numberOfDiscs;
    }

    public void setNumberOfDiscs(int numberOfDiscs) {
        this.numberOfDiscs = numberOfDiscs;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public PhysicalGameEntity(String title, String genre, String platform, double price, String mediaType, int numberOfDiscs, int copies) {
        super(title, genre, platform, price);
        this.mediaType = mediaType;
        this.numberOfDiscs = numberOfDiscs;
        this.copies = copies;
    }

    public PhysicalGameEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PhysicalGameEntity that = (PhysicalGameEntity) o;
        return numberOfDiscs == that.numberOfDiscs && copies == that.copies && Double.compare(price, that.price) == 0 && Objects.equals(mediaType, that.mediaType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), mediaType, numberOfDiscs, copies, price);
    }

    @Override
    public String toString() {
        return "PhysicalGameEntity{" +
                "mediaType='" + mediaType + '\'' +
                ", numberOfDiscs=" + numberOfDiscs +
                ", copies=" + copies +
                ", price=" + price +
                '}';
    }
}