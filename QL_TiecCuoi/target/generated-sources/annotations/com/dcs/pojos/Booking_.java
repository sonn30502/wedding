package com.dcs.pojos;

import com.dcs.pojos.Event;
import com.dcs.pojos.Halls;
import com.dcs.pojos.Menu;
import com.dcs.pojos.Service;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T18:31:49")
@StaticMetamodel(Booking.class)
public class Booking_ { 

    public static volatile SingularAttribute<Booking, Event> eventID;
    public static volatile SingularAttribute<Booking, Halls> hallID;
    public static volatile SingularAttribute<Booking, Menu> menuID;
    public static volatile SingularAttribute<Booking, Service> serviceID;
    public static volatile SingularAttribute<Booking, Integer> bookingID;

}