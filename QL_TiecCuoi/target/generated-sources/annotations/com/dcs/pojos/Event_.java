package com.dcs.pojos;

import com.dcs.pojos.Booking;
import com.dcs.pojos.Branch;
import com.dcs.pojos.Event.EventStatus;
import com.dcs.pojos.Feedback;
import com.dcs.pojos.Halls;
import com.dcs.pojos.Menu;
import com.dcs.pojos.Payment;
import com.dcs.pojos.Service;
import com.dcs.pojos.User;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T18:31:49")
@StaticMetamodel(Event.class)
public class Event_ { 

    public static volatile SingularAttribute<Event, Integer> eventID;
    public static volatile SingularAttribute<Event, Branch> branchID;
    public static volatile SingularAttribute<Event, BigDecimal> totalPrice;
    public static volatile SingularAttribute<Event, Halls> hallID;
    public static volatile SetAttribute<Event, Feedback> feedbackSet;
    public static volatile SetAttribute<Event, Booking> bookingSet;
    public static volatile SingularAttribute<Event, Menu> menuID;
    public static volatile SingularAttribute<Event, Service> serviceID;
    public static volatile SingularAttribute<Event, User> userID;
    public static volatile SetAttribute<Event, Payment> paymentSet;
    public static volatile SingularAttribute<Event, Date> eventDate;
    public static volatile SingularAttribute<Event, EventStatus> status;

}