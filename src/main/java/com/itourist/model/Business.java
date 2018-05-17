/*

 */
package com.itourist.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Table(name = "business")
@Entity
public class Business  implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY )
    @Column(name="business_id")
    private Long id;

    @Column
    private String title;

    @Column
    @Lob
    private String description;


    @Column
    private String address;

    @Column
    private String email;

    @Column
    private String phone;

    @Column
    private Double latitude;

    @Column
    private Double longitude;

    @Column
    private String category;

    @Column(name = "working_hours")
    private String workingHours;

    @OneToMany( fetch = FetchType.LAZY , mappedBy = "business",cascade = CascadeType.ALL)
    private List<Post> posts;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="featured_image")
    private Image featuredImage;


    @OneToMany(cascade = CascadeType.DETACH  )
    @JoinTable
            (
                    name="business_image",
                    joinColumns={ @JoinColumn(name="business_id", referencedColumnName="business_id") },
                    inverseJoinColumns={ @JoinColumn(name="image_id", referencedColumnName="image_id", unique=true) }
            )
    private List<Image> images = new ArrayList<>();




    @Column(name="user_id")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(String workingHours) {
        this.workingHours = workingHours;
    }

    public Image getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(Image featuredImage) {
        this.featuredImage = featuredImage;
    }

    public List<Image> getImages() {
        Collections.reverse(images);
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString(){
        return
                "Business ->"+
                        "title: " + getTitle() +
                        "featured img: " + getFeaturedImage() +
                        "extra imgs: " + getImages();
    }
}
