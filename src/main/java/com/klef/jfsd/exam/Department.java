package com.klef.jfsd.exam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department_table")
public class Department 
{
    @Id
    private int id;

    @Column(name = "dname", length = 50, nullable = false)
    private String name;

    @Column(name = "dlocation", length = 100, nullable = false)
    private String location;

    @Column(name = "hod_name", length = 50, nullable = false)
    private String hodName;

    @Column(name = "dstatus", nullable = false)
    private boolean status; 

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getHodName() {
        return hodName;
    }

    public void setHodName(String hodName) {
        this.hodName = hodName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + ", location=" + location + 
               ", hodName=" + hodName + ", status=" + status + "]";
    }
}
