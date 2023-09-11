package com.dcs.pojos;

import com.dcs.pojos.Booking;
import com.dcs.pojos.Branch;
import com.dcs.pojos.Event;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T18:31:49")
@StaticMetamodel(Service.class)
public class Service_ { 

    public static volatile SingularAttribute<Service, Branch> branchID;
    public static volatile SingularAttribute<Service, String> image;
    public static volatile SingularAttribute<Service, BigDecimal> price;
    public static volatile SetAttribute<Service, Booking> bookingSet;
    public static volatile SingularAttribute<Service, String> description;
    public static volatile SetAttribute<Service, Event> eventSet;
    public static volatile SingularAttribute<Service, Integer> serviceID;
    public static volatile SingularAttribute<Service, String> serviceName;

}