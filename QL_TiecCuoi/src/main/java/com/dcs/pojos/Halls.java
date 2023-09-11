/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "halls")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Halls.findAll", query = "SELECT h FROM Halls h"),
    @NamedQuery(name = "Halls.findByHallID", query = "SELECT h FROM Halls h WHERE h.hallID = :hallID"),
    @NamedQuery(name = "Halls.findByHallName", query = "SELECT h FROM Halls h WHERE h.hallName = :hallName"),
    @NamedQuery(name = "Halls.findByPriceMorning", query = "SELECT h FROM Halls h WHERE h.priceMorning = :priceMorning"),
    @NamedQuery(name = "Halls.findByPriceAfternoon", query = "SELECT h FROM Halls h WHERE h.priceAfternoon = :priceAfternoon"),
    @NamedQuery(name = "Halls.findByPriceEvening", query = "SELECT h FROM Halls h WHERE h.priceEvening = :priceEvening"),
    @NamedQuery(name = "Halls.findByPriceWeekend", query = "SELECT h FROM Halls h WHERE h.priceWeekend = :priceWeekend")})
public class Halls implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "hallID")
    private Integer hallID;
    @Size(max = 100)
    @Column(name = "hallName")
    private String hallName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "priceMorning")
    private BigDecimal priceMorning;
    @Column(name = "priceAfternoon")
    private BigDecimal priceAfternoon;
    @Column(name = "priceEvening")
    private BigDecimal priceEvening;
    @Column(name = "priceWeekend")
    private BigDecimal priceWeekend;
    @OneToMany(mappedBy = "hallID")
    @JsonIgnore
    private Set<Booking> bookingSet;
    @OneToMany(mappedBy = "hallID")
    @JsonIgnore
    private Set<Event> eventSet;
    @JoinColumn(name = "branchID", referencedColumnName = "branchID")
    @ManyToOne
    private Branch branchID;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    @Size(min = 10, max = 1000)
    @Column(name = "description")
    private String description;

    @Transient
    private MultipartFile file;

    public Halls() {
    }

    public Halls(Integer hallID) {
        this.hallID = hallID;
    }

    public Integer getHallID() {
        return hallID;
    }

    public void setHallID(Integer hallID) {
        this.hallID = hallID;
    }

    public String getHallName() {
        return hallName;
    }

    public void setHallName(String hallName) {
        this.hallName = hallName;
    }

    public BigDecimal getPriceMorning() {
        return priceMorning;
    }

    public void setPriceMorning(BigDecimal priceMorning) {
        this.priceMorning = priceMorning;
    }

    public BigDecimal getPriceAfternoon() {
        return priceAfternoon;
    }

    public void setPriceAfternoon(BigDecimal priceAfternoon) {
        this.priceAfternoon = priceAfternoon;
    }

    public BigDecimal getPriceEvening() {
        return priceEvening;
    }

    public void setPriceEvening(BigDecimal priceEvening) {
        this.priceEvening = priceEvening;
    }

    public BigDecimal getPriceWeekend() {
        return priceWeekend;
    }

    public void setPriceWeekend(BigDecimal priceWeekend) {
        this.priceWeekend = priceWeekend;
    }

    @XmlTransient
    public Set<Booking> getBookingSet() {
        return bookingSet;
    }

    public void setBookingSet(Set<Booking> bookingSet) {
        this.bookingSet = bookingSet;
    }

    @XmlTransient
    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }

    public Branch getBranchID() {
        return branchID;
    }

    public void setBranchID(Branch branchID) {
        this.branchID = branchID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (hallID != null ? hallID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Halls)) {
            return false;
        }
        Halls other = (Halls) object;
        if ((this.hallID == null && other.hallID != null) || (this.hallID != null && !this.hallID.equals(other.hallID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dcs.pojos.Halls[ hallID=" + hallID + " ]";
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
