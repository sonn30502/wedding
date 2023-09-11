package com.dcs.pojos;

import com.dcs.pojos.Booking;
import com.dcs.pojos.Branch;
import com.dcs.pojos.Event;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T18:31:49")
@StaticMetamodel(Menu.class)
public class Menu_ { 

    public static volatile SingularAttribute<Menu, String> image;
    public static volatile SingularAttribute<Menu, Branch> branchID;
    public static volatile SingularAttribute<Menu, Date> createdDate;
    public static volatile SingularAttribute<Menu, BigDecimal> price;
    public static volatile SetAttribute<Menu, Booking> bookingSet;
    public static volatile SingularAttribute<Menu, Integer> menuID;
    public static volatile SingularAttribute<Menu, String> description;
    public static volatile SingularAttribute<Menu, String> menuName;
    public static volatile SetAttribute<Menu, Event> eventSet;

}