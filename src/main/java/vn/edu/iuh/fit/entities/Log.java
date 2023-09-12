package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "bigint")
    private long id;
    @ManyToOne
    @Column(columnDefinition = "varchar(50)", name = "account_id")
    private Account Account;
    @Column(columnDefinition = "datetime")
    private Date login_time;
    @Column(columnDefinition = "datetime")
    private Date logout_time;
    @Column(columnDefinition = "varchar(250)")
    private String notes;

    public Log() {
    }

    public Log(long id, vn.edu.iuh.fit.entities.Account account, Date login_time, Date logout_time, String notes) {
        this.id = id;
        Account = account;
        this.login_time = login_time;
        this.logout_time = logout_time;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public vn.edu.iuh.fit.entities.Account getAccount() {
        return Account;
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

    public void setAccount(vn.edu.iuh.fit.entities.Account account) {
        Account = account;
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
                ", Account=" + Account +
                ", login_time=" + login_time +
                ", logout_time=" + logout_time +
                ", notes='" + notes + '\'' +
                '}';
    }
}
