/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Vishal
 */
@Entity
@Table(name = "departmenttb", catalog = "employeedb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Departmenttb.findAll", query = "SELECT d FROM Departmenttb d"),
    @NamedQuery(name = "Departmenttb.findByDeptid", query = "SELECT d FROM Departmenttb d WHERE d.deptid = :deptid"),
    @NamedQuery(name = "Departmenttb.findByDeptname", query = "SELECT d FROM Departmenttb d WHERE d.deptname = :deptname")})
public class Departmenttb implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deptid", nullable = false)
    private Integer deptid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "deptname", nullable = false, length = 50)
    private String deptname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "deptid")
    private Collection<Employeetb> employeetbCollection;

    public Departmenttb() {
    }

    public Departmenttb(Integer deptid) {
        this.deptid = deptid;
    }

    public Departmenttb(Integer deptid, String deptname) {
        this.deptid = deptid;
        this.deptname = deptname;
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

    @XmlTransient
    @JsonbTransient
    public Collection<Employeetb> getEmployeetbCollection() {
        return employeetbCollection;
    }

    public void setEmployeetbCollection(Collection<Employeetb> employeetbCollection) {
        this.employeetbCollection = employeetbCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptid != null ? deptid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Departmenttb)) {
            return false;
        }
        Departmenttb other = (Departmenttb) object;
        if ((this.deptid == null && other.deptid != null) || (this.deptid != null && !this.deptid.equals(other.deptid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Departmenttb[ deptid=" + deptid + " ]";
    }
    
}
