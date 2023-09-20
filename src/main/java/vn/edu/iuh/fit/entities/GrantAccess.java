package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @Column(columnDefinition = "bit")
    private boolean is_grant;
    @Column(columnDefinition = "varchar(250)")
    private String note;
    @Id
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Id
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public GrantAccess() {
    }

    public GrantAccess(boolean is_grant, String note, Account account, Role role) {
        this.is_grant = is_grant;
        this.note = note;
        this.account = account;
        this.role = role;
    }

    public boolean isIs_grant() {
        return is_grant;
    }

    public String getNote() {
        return note;
    }

    public Account getAccount() {
        return account;
    }

    public Role getRole() {
        return role;
    }

    public void setIs_grant(boolean is_grant) {
        this.is_grant = is_grant;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "is_grant=" + is_grant +
                ", note='" + note + '\'' +
                ", account=" + account +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrantAccess that = (GrantAccess) o;
        return Objects.equals(account, that.account) && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, role);
    }
}
