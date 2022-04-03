package entity;

import entity.Employeetb;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-04-02T23:36:48", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Departmenttb.class)
public class Departmenttb_ { 

    public static volatile CollectionAttribute<Departmenttb, Employeetb> employeetbCollection;
    public static volatile SingularAttribute<Departmenttb, Integer> deptid;
    public static volatile SingularAttribute<Departmenttb, String> deptname;

}