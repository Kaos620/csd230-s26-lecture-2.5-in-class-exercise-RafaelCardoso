package csd230.s26.lab1.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.util.Objects;

@Entity
public class VideoGameEntity extends ProductEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "platform")
    private String platform;

    @Column(name = "price", nullable = true)
    private double price;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void sellItem() {

    }

    public VideoGameEntity(String title, String genre, String platform, double price) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.price = price;
    }


    public VideoGameEntity() {
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VideoGameEntity that = (VideoGameEntity) o;
        return Double.compare(price, that.price) == 0 && Objects.equals(title, that.title) && Objects.equals(genre, that.genre) && Objects.equals(platform, that.platform);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, genre, platform, price);
    }

    @Override
    public String toString() {
        return "VideoGameEntity{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", platform='" + platform + '\'' +
                ", price=" + price +
                '}';
    }
}