/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "branch")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
    @NamedQuery(name = "Branch.findByBranchID", query = "SELECT b FROM Branch b WHERE b.branchID = :branchID"),
    @NamedQuery(name = "Branch.findByBranchName", query = "SELECT b FROM Branch b WHERE b.branchName = :branchName"),
    @NamedQuery(name = "Branch.findByAddress", query = "SELECT b FROM Branch b WHERE b.address = :address"),
    @NamedQuery(name = "Branch.findByPhoneNumber", query = "SELECT b FROM Branch b WHERE b.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "Branch.findByImage", query = "SELECT b FROM Branch b WHERE b.image = :image")})
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "branchID")
    private Integer branchID;

    @NotNull(message = "{branch.branchName.notNull}")
    @Size(min = 5, max = 100, message = "{branch.branchName.lenErr}")
    @Column(name = "branchName")
    private String branchName;
    @NotNull(message = "{branch.address.notNull}")
    @Size(max = 200)
    @Column(name = "address")
    private String address;
    @Size(max = 20)
    @Column(name = "phoneNumber")
    private String phoneNumber;
    @Size(max = 200)
    @Column(name = "image")
    private String image;
    @OneToMany(mappedBy = "branchID")
    @JsonIgnore
    private Set<Statistic> statisticSet;
    @OneToMany(mappedBy = "branchID")
    @JsonIgnore
    private Set<Service> serviceSet;
    @OneToMany(mappedBy = "branchID")
    @JsonIgnore
    private Set<Event> eventSet;
    @OneToMany(mappedBy = "branchID")
    @JsonIgnore
    private Set<Menu> menuSet;
    @OneToMany(mappedBy = "branchID")
    @JsonIgnore
    private Set<Halls> hallsSet;

    @Transient
    private MultipartFile file;

    public Branch() {
    }

    public Branch(Integer branchID) {
        this.branchID = branchID;
    }

    public Integer getBranchID() {
        return branchID;
    }

    public void setBranchID(Integer branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @XmlTransient
    public Set<Statistic> getStatisticSet() {
        return statisticSet;
    }

    public void setStatisticSet(Set<Statistic> statisticSet) {
        this.statisticSet = statisticSet;
    }

    @XmlTransient
    public Set<Service> getServiceSet() {
        return serviceSet;
    }

    public void setServiceSet(Set<Service> serviceSet) {
        this.serviceSet = serviceSet;
    }

    @XmlTransient
    public Set<Event> getEventSet() {
        return eventSet;
    }

    public void setEventSet(Set<Event> eventSet) {
        this.eventSet = eventSet;
    }

    @XmlTransient
    public Set<Menu> getMenuSet() {
        return menuSet;
    }

    public void setMenuSet(Set<Menu> menuSet) {
        this.menuSet = menuSet;
    }

    @XmlTransient
    public Set<Halls> getHallsSet() {
        return hallsSet;
    }

    public void setHallsSet(Set<Halls> hallsSet) {
        this.hallsSet = hallsSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (branchID != null ? branchID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.branchID == null && other.branchID != null) || (this.branchID != null && !this.branchID.equals(other.branchID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dcs.pojos.Branch[ branchID=" + branchID + " ]";
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

}
