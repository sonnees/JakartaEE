package vn.edu.iuh.fit.entities;

public class GrantAccess {
    private String account_id;
    private String role_id  ;
    private boolean is_grant;
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(String account_id, String role_id, boolean is_grant, String note) {
        this.account_id = account_id;
        this.role_id = role_id;
        this.is_grant = is_grant;
        this.note = note;
    }

    public String getAccount_id() {
        return account_id;
    }

    public String getRole_id() {
        return role_id;
    }

    public boolean isIs_grant() {
        return is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setAccount_id(String account_id) {
        this.account_id = account_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public void setIs_grant(boolean is_grant) {
        this.is_grant = is_grant;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "account_id='" + account_id + '\'' +
                ", role_id='" + role_id + '\'' +
                ", is_grant=" + is_grant +
                ", note='" + note + '\'' +
                '}';
    }
}
