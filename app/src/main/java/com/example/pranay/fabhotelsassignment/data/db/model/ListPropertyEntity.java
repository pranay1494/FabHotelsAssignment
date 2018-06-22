package com.example.pranay.fabhotelsassignment.data.db.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by pranay on 22/06/18.
 */

@Entity(nameInDb = "properties")
public class ListPropertyEntity {

    @Id(autoincrement = true)
    private Long id;
    @SerializedName("landmark")
    @Expose
    @Property(nameInDb = "landmark")
    private String landmark;
    @SerializedName("city")
    @Expose
    @Property(nameInDb = "city")
    private String city;
    @SerializedName("name")
    @Expose
    @Property(nameInDb = "name")
    private String name;
    @SerializedName("reviewCount")
    @Expose
    @Property(nameInDb = "reviewCount")
    private Integer reviewCount;
    @SerializedName("price")
    @Expose
    @Property(nameInDb = "price")
    private Integer price;
    @SerializedName("ratedText")
    @Expose
    @Property(nameInDb = "ratedText")
    private String ratedText;
    @Generated(hash = 1907791355)
    public ListPropertyEntity(Long id, String landmark, String city, String name,
            Integer reviewCount, Integer price, String ratedText) {
        this.id = id;
        this.landmark = landmark;
        this.city = city;
        this.name = name;
        this.reviewCount = reviewCount;
        this.price = price;
        this.ratedText = ratedText;
    }
    @Generated(hash = 327958253)
    public ListPropertyEntity() {
    }
    public Long getId() {
        return this.id;
    }
    public String getLandmark() {
        return this.landmark;
    }
    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
    public String getCity() {
        return this.city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getReviewCount() {
        return this.reviewCount;
    }
    public void setReviewCount(Integer reviewCount) {
        this.reviewCount = reviewCount;
    }
    public Integer getPrice() {
        return this.price;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public String getRatedText() {
        return this.ratedText;
    }
    public void setRatedText(String ratedText) {
        this.ratedText = ratedText;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
