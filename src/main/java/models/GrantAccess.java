package models;

import jakarta.persistence.*;

@Entity
@Table(name = "grant_access")
public class GrantAccess {
    @Id
    private String role_id;
    private Is_Grant is_grant;
    private String note;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role roe;

    public GrantAccess(String role_id) {
        this.role_id = role_id;
    }

    public GrantAccess(String role_id, Is_Grant is_grant, String note, Account account, Role roe) {
        this.role_id = role_id;
        this.is_grant = is_grant;
        this.note = note;
        this.account = account;
        this.roe = roe;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Role getRoe() {
        return roe;
    }

    public void setRoe(Role roe) {
        this.roe = roe;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "role_id='" + role_id + '\'' +
                ", is_grant=" + is_grant +
                ", note='" + note + '\'' +
                ", account=" + account +
                ", roe=" + roe +
                '}';
    }
}
