package vn.edu.iuh.fit.entities;

public class Role {
    private String role_id;
    private String role_name;
    private String description;
    private byte status;

    public Role() {
    }

    public Role(String role_id, String role_name, String description, byte status) {
        this.role_id = role_id;
        this.role_name = role_name;
        this.description = description;
        this.status = status;
    }

    public String getRole_id() {
        return role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public String getDescription() {
        return description;
    }

    public byte getStatus() {
        return status;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", role_name='" + role_name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                '}';
    }
}
