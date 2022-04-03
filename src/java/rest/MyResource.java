/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.DataModelLocal;
import entity.Departmenttb;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Vishal
 */
@Path("employeeapi")
public class MyResource {
@EJB DataModelLocal ejb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MyResource
     */
    public MyResource() {
    }
    @Path("getalldept")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Departmenttb> getAllDepartment()
    {
        return ejb.getAllDepartment();
    }
    @Path("addept/{deptid}/{deptname}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String addept(@PathParam("deptid") Integer deptid,@PathParam("deptname") String deptname)
    {
        return ejb.addept(deptid,deptname);
    }
    @Path("updatedept/{deptid}/{deptname}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String updatedept(@PathParam("deptid") Integer deptid,@PathParam("deptname") String deptname)
    {
        return ejb.updatedept(deptid, deptname);
    }
    @Path("deletedept/{deptid}")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public String deletedept(@PathParam("deptid") Integer deptid)
    {
        return ejb.deletedept(deptid);
    }
}
