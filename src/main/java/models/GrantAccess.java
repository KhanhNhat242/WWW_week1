package models;

import jakarta.persistence.*;

@Table(name = "grant_access")
public class GrantAccess {
    private Is_Grant is_grant;
    private String note;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account_id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role_id;

    public GrantAccess(Is_Grant is_grant, String note, Account account_id, Role role_id) {
        this.is_grant = is_grant;
        this.note = note;
        this.account_id = account_id;
        this.role_id= role_id;
    }

    public Role getRole() {
        return role_id;
    }

    public void setRole(Role role) {
        this.role_id = role_id;
    }

    public GrantAccess() {

    }

    public Is_Grant getIs_grant() {
        return is_grant;
    }

    public void setIs_grant(Is_Grant is_grant) {
        this.is_grant = is_grant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Account getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Account account_id) {
        this.account_id = account_id;
    }

    public Role getRole_id() {
        return role_id;
    }

    public void setRole_id(Role role_id) {
        this.role_id = role_id;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "is_grant=" + is_grant +
                ", note='" + note + '\'' +
                ", account_id=" + account_id +
                ", role=" + role_id +
                '}';
    }
}
