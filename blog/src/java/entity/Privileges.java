/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author sevda.cuya
 */
public class Privileges {

    private Long id;
    private String mname;
    private boolean icreate;
    private boolean iread;
    private boolean iupdate;
    private boolean idelete;
    private boolean ishow;

    public Privileges() {
    }

    public Privileges(Long id, String mname, boolean icreate, boolean iread, boolean iupdate, boolean idelete, boolean ishow) {
        this.id = id;
        this.mname = mname;
        this.icreate = icreate;
        this.iread = iread;
        this.iupdate = iupdate;
        this.idelete = idelete;
        this.ishow = ishow;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public boolean isIcreate() {
        return icreate;
    }

    public void setIcreate(boolean icreate) {
        this.icreate = icreate;
    }

    public boolean isIread() {
        return iread;
    }

    public void setIread(boolean iread) {
        this.iread = iread;
    }

    public boolean isIupdate() {
        return iupdate;
    }

    public void setIupdate(boolean iupdate) {
        this.iupdate = iupdate;
    }

    public boolean isIdelete() {
        return idelete;
    }

    public void setIdelete(boolean idelete) {
        this.idelete = idelete;
    }

    public boolean isIshow() {
        return ishow;
    }

    public void setIshow(boolean ishow) {
        this.ishow = ishow;
    }

}
