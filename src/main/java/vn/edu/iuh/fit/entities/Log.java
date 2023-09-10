package vn.edu.iuh.fit.entities;

import java.sql.Date;

public class Log {
    private long id;
    private String account_id;
    private Date login_time;
    private Date logout_time;
    private String notes;

    public Log() {
    }

    public Log(long id, String account_id, Date login_time, Date logout_time, String notes) {
        this.id = id;
        this.account_id = account_id;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public String getAccount_id() {
        return account_id;
    }

    public Date getLogin_time() {
        return login_time;
    }

    public Date getLogout_time() {
        return logout_time;
    }

    public String getNotes() {
        return notes;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public void setLogin_time(Date login_time) {
        this.login_time = login_time;
    }

    public void setLogout_time(Date logout_time) {
        this.logout_time = logout_time;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", account_id='" + account_id + '\'' +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}
