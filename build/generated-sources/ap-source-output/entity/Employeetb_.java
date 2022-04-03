package entity;

import entity.Departmenttb;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-02T23:36:48", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Employeetb.class)
public class Employeetb_ { 

    public static volatile SingularAttribute<Employeetb, String> empname;
    public static volatile SingularAttribute<Employeetb, Integer> empid;
    public static volatile SingularAttribute<Employeetb, String> gender;
    public static volatile SingularAttribute<Employeetb, Departmenttb> deptid;
    public static volatile SingularAttribute<Employeetb, String> email;

}