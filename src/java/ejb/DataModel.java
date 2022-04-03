/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Departmenttb;
import entity.Employeetb;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vishal
 */
@Stateless
public class DataModel implements DataModelLocal {
    @PersistenceContext(unitName = "EmployeeApplicationPU")
    EntityManager em;
    @Override
    public List<Departmenttb> getAllDepartment() {
        List<Departmenttb> deptlist=em.createNamedQuery("Departmenttb.findAll").getResultList();
        return deptlist;
    }

   
    @Override
    public String addept(Integer deptid, String deptname) {
        try {
            Departmenttb d=new Departmenttb(deptid,deptname);
            em.persist(d);
            return "inserted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deletedept(Integer deptid) {
        try {
            Departmenttb d=(Departmenttb) em.find(Departmenttb.class,deptid);
            em.remove(d);
            return "Deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updatedept(Integer deptid, String deptname) {
        try {
            Departmenttb d=(Departmenttb) em.find(Departmenttb.class,deptid);
            d.setDeptname(deptname);
            em.merge(d);
            return "Updated";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Departmenttb search(Integer deptid) {
          try {
             Departmenttb dept=em.find(Departmenttb.class,deptid);
           return dept;
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Collection<Employeetb> getAllEmployee() {
       return em.createNamedQuery("Employeetb.findAll").getResultList();
    }

    @Override
    public String addemp(Integer empid, String empname, Integer deptid, String gender, String email) {
        try {
            Departmenttb d=em.find(Departmenttb.class,deptid);
            Employeetb emp=new Employeetb();
            emp.setEmpid(0);
            emp.setEmpname(empname);
            emp.setDeptid(d);
            emp.setEmail(email);
            emp.setGender(gender);
            em.persist(emp);
            return "Inserted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String updateemp(Integer empid, String empname,Integer deptid, String gender, String email) {
        try {
            Departmenttb d=(Departmenttb) em.find(Departmenttb.class,deptid);
            Employeetb emp=(Employeetb)em.find(Employeetb.class,empid);
            emp.setEmpname(empname);
            emp.setEmail(email);
            emp.setDeptid(d);
            emp.setGender(gender);
            em.merge(emp);
            return "updated";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public String deleteemp(Integer empid) {
        try {
            Employeetb emp=em.find(Employeetb.class, empid);
            em.remove(emp);
            return "deleted";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @Override
    public Employeetb searchemp(Integer empid) {
          try {
             Employeetb emp=em.find(Employeetb.class,empid);
           return emp;
        } catch (Exception e) {
            return null;
        }
    }
    
}
