/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import ejb.DataModelLocal;
import entity.Departmenttb;
import entity.Employeetb;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Vishal
 */
@Named(value = "employeeBean")
@ApplicationScoped
public class employeeBean {

    @EJB
    private DataModelLocal dataModel;
    
    Integer empid,deptid;
    String empname,email,gender;
    
    List<Departmenttb> deptlist;
    Employeetb e=new Employeetb(); 
    /**
     * Creates a new instance of employeeBean
     */
    public employeeBean() {
        
    }
    @PostConstruct
    public void init()
    {
        empid=0;
        deptlist=dataModel.getAllDepartment();
    }

    public List<Departmenttb> getDeptlist() {
        return deptlist;
    }

    public void setDeptlist(List<Departmenttb> deptlist) {
        this.deptlist = deptlist;
    }
    public DataModelLocal getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelLocal dataModel) {
        this.dataModel = dataModel;
    }

    public Integer getEmpid() {
        return empid;
    }

    public void setEmpid(Integer empid) {
        this.empid = empid;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public String insertemp()
    {
        try {
            e.setEmpid(0);
            Departmenttb d=dataModel.search(deptid);
            e.setDeptid(d);
            e.setEmpname(empname);
            e.setGender(gender);
            //e.setGender(gender);
            dataModel.addemp(empid, empname, deptid, gender, email);
            //return "page_1?faces-redirect=true";
            return "Departmentjsp.xhtml";
        } catch (Exception e) {
            return "employee.xhtml";
        }
    }
    public Collection<Employeetb> Show()
    {
        return dataModel.getAllEmployee();
    }
    public void delete(Integer id)
    {
        System.out.println("Id"+id);
        try {
            
            System.out.println("Message:="+dataModel.deleteemp(id));
            
        } catch (Exception e) {
             e.getMessage();
        }
    }
    public String updateemp()
    {
        try {
            Departmenttb d=dataModel.search(deptid);
            e.setEmpid(empid);
            e.setEmpname(empname);
            e.setEmail(email);
            e.setDeptid(d);
            e.setGender(gender);
//            System.out.println("name:="+empname+"deptid:="+deptid);
//            return "hello";
            System.out.println("updatemp:="+dataModel.updateemp(empid, empname, deptid, gender, email));
            return "showemp.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public String search(Integer id)
    {
        try {
            e=dataModel.searchemp(id);
        empid=e.getEmpid();
        empname=e.getEmpname();
        email=e.getEmail();
        gender=e.getGender();
        deptid=e.getDeptid().getDeptid();
        return "employee.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
        
    }
}
