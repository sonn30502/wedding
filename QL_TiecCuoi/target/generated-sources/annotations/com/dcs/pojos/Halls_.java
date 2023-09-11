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
@StaticMetamodel(Halls.class)
public class Halls_ { 

    public static volatile SingularAttribute<Halls, Branch> branchID;
    public static volatile SingularAttribute<Halls, String> image;
    public static volatile SingularAttribute<Halls, BigDecimal> priceAfternoon;
    public static volatile SingularAttribute<Halls, Integer> hallID;
    public static volatile SingularAttribute<Halls, BigDecimal> priceEvening;
    public static volatile SingularAttribute<Halls, BigDecimal> priceWeekend;
    public static volatile SetAttribute<Halls, Booking> bookingSet;
    public static volatile SingularAttribute<Halls, String> description;
    public static volatile SingularAttribute<Halls, BigDecimal> priceMorning;
    public static volatile SetAttribute<Halls, Event> eventSet;
    public static volatile SingularAttribute<Halls, String> hallName;

}