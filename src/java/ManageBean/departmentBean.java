/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManageBean;

import client.RestClient;
import ejb.DataModelLocal;
import entity.Departmenttb;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Vishal
 */
@Named(value = "departmentBean")
@ApplicationScoped
public class departmentBean {
    
    @EJB
    private DataModelLocal dataModel;
    
    Response res;
    RestClient pbl;
    Collection<Departmenttb> departmenttb;
    GenericType<Collection<Departmenttb>> gdepartmenttb;
    
    
    Integer deptid;
    String deptname;
    Departmenttb d=new Departmenttb();
    Collection<Departmenttb> data;
    @PostConstruct
    public void init()
    {
        pbl=new RestClient();
        deptid=0;
        gdepartmenttb=new GenericType<Collection<Departmenttb>>() {};
        res=pbl.getAllDepartment(Response.class);
        data=res.readEntity(gdepartmenttb);
    }

    public DataModelLocal getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModelLocal dataModel) {
        this.dataModel = dataModel;
    }

    public Integer getDeptid() {
        return deptid;
    }

    public void setDeptid(Integer deptid) {
        this.deptid = deptid;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }
    
    public departmentBean() {
    }
    public String adddept()
    {
        d.setDeptid(0);
        d.setDeptname(deptname);
       // dataModel.addept(deptid, deptname);
        System.out.println("Message addepartment:="+pbl.addept("0",deptname));
        return "showjsf.xhtml";
    }
    public Collection<Departmenttb> Show()
    {
        return data;
    }
    public void deptDelete(Integer id)
    {
        try {
            dataModel.deletedept(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
    public String updatedept() {
        try {

            d.setDeptid(deptid);
            d.setDeptname(deptname);
            dataModel.updatedept(deptid, deptname);
            return "showjsf.xhtml";
        } catch (Exception e) {
           return e.getMessage();
        }
    }
    public String search_click(Integer id) {
        try {
            d = dataModel.search(id);
            deptid = d.getDeptid();
            deptname = d.getDeptname();
            return "Departmentjsp.xhtml";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}

