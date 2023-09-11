package com.dcs.pojos;

import com.dcs.pojos.Event;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T18:31:49")
@StaticMetamodel(Payment.class)
public class Payment_ { 

    public static volatile SingularAttribute<Payment, Event> eventID;
    public static volatile SingularAttribute<Payment, Integer> paymentID;
    public static volatile SingularAttribute<Payment, String> invoiceNumber;
    public static volatile SingularAttribute<Payment, String> paymentMethod;
    public static volatile SingularAttribute<Payment, String> details;
    public static volatile SingularAttribute<Payment, Date> paymentDate;

}