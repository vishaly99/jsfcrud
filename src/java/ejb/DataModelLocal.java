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
import javax.ejb.Local;

/**
 *
 * @author Vishal
 */
@Local
public interface DataModelLocal {
    //Department
    List<Departmenttb> getAllDepartment();
    public String addept(Integer deptid,String deptname);
    public String updatedept(Integer deptid,String deptname);
    public String deletedept(Integer deptid);
    public Departmenttb search(Integer deptid);
    //Employee
    Collection<Employeetb> getAllEmployee();
    public String addemp(Integer empid,String empname,Integer deptid,String gender,String email);
    public String updateemp(Integer empid,String empname,Integer deptid,String gender,String email);
    public String deleteemp(Integer empid);
    public Employeetb searchemp(Integer empid);
    
    
}
