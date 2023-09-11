package com.dcs.pojos;

import com.dcs.pojos.Event;
import com.dcs.pojos.Halls;
import com.dcs.pojos.Menu;
import com.dcs.pojos.Service;
import com.dcs.pojos.Statistic;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T18:31:49")
@StaticMetamodel(Branch.class)
public class Branch_ { 

    public static volatile SingularAttribute<Branch, Integer> branchID;
    public static volatile SingularAttribute<Branch, String> image;
    public static volatile SetAttribute<Branch, Halls> hallsSet;
    public static volatile SingularAttribute<Branch, String> address;
    public static volatile SingularAttribute<Branch, String> phoneNumber;
    public static volatile SetAttribute<Branch, Statistic> statisticSet;
    public static volatile SetAttribute<Branch, Menu> menuSet;
    public static volatile SingularAttribute<Branch, String> branchName;
    public static volatile SetAttribute<Branch, Event> eventSet;
    public static volatile SetAttribute<Branch, Service> serviceSet;

}