/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dcs.pojos;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ASUS
 */
@Entity
@Table(name = "statistic")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Statistic.findAll", query = "SELECT s FROM Statistic s"),
    @NamedQuery(name = "Statistic.findByStatisticID", query = "SELECT s FROM Statistic s WHERE s.statisticID = :statisticID"),
    @NamedQuery(name = "Statistic.findByMonth", query = "SELECT s FROM Statistic s WHERE s.month = :month"),
    @NamedQuery(name = "Statistic.findByQuarter", query = "SELECT s FROM Statistic s WHERE s.quarter = :quarter"),
    @NamedQuery(name = "Statistic.findByYear", query = "SELECT s FROM Statistic s WHERE s.year = :year"),
    @NamedQuery(name = "Statistic.findByEventCount", query = "SELECT s FROM Statistic s WHERE s.eventCount = :eventCount"),
    @NamedQuery(name = "Statistic.findByRevenue", query = "SELECT s FROM Statistic s WHERE s.revenue = :revenue")})
public class Statistic implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "statisticID")
    private Integer statisticID;
    @Column(name = "month")
    private Integer month;
    @Column(name = "quarter")
    private Integer quarter;
    @Column(name = "year")
    private Integer year;
    @Column(name = "eventCount")
    private Integer eventCount;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "revenue")
    private BigDecimal revenue;
    @JoinColumn(name = "branchID", referencedColumnName = "branchID")
    @ManyToOne
    private Branch branchID;

    public Statistic() {
    }

    public Statistic(Integer statisticID) {
        this.statisticID = statisticID;
    }

    public Integer getStatisticID() {
        return statisticID;
    }

    public void setStatisticID(Integer statisticID) {
        this.statisticID = statisticID;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getEventCount() {
        return eventCount;
    }

    public void setEventCount(Integer eventCount) {
        this.eventCount = eventCount;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
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
        hash += (statisticID != null ? statisticID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Statistic)) {
            return false;
        }
        Statistic other = (Statistic) object;
        if ((this.statisticID == null && other.statisticID != null) || (this.statisticID != null && !this.statisticID.equals(other.statisticID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dcs.pojos.Statistic[ statisticID=" + statisticID + " ]";
    }
    
}
