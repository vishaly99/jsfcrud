/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:MyResource [employeeapi]<br>
 * USAGE:
 * <pre>
 *        RestClient client = new RestClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Vishal
 */
public class RestClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/EmployeeApplication/webresources";

    public RestClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("employeeapi");
    }

    public String deletedept(String deptid) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("deletedept/{0}", new Object[]{deptid})).request().post(null, String.class);
    }

    public String updatedept(String deptid, String deptname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("updatedept/{0}/{1}", new Object[]{deptid, deptname})).request().post(null, String.class);
    }

    public String addept(String deptid, String deptname) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("addept/{0}/{1}", new Object[]{deptid, deptname})).request().post(null, String.class);
    }

    public <T> T getAllDepartment(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getalldept");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
