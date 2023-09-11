package com.dcs.pojos;

import com.dcs.pojos.Branch;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-09-10T18:31:49")
@StaticMetamodel(Statistic.class)
public class Statistic_ { 

    public static volatile SingularAttribute<Statistic, Branch> branchID;
    public static volatile SingularAttribute<Statistic, Integer> statisticID;
    public static volatile SingularAttribute<Statistic, BigDecimal> revenue;
    public static volatile SingularAttribute<Statistic, Integer> month;
    public static volatile SingularAttribute<Statistic, Integer> year;
    public static volatile SingularAttribute<Statistic, Integer> eventCount;
    public static volatile SingularAttribute<Statistic, Integer> quarter;

}