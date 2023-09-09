package models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class GrantAccess {
    @Id
    private String role_id;
//    private Enum is_grant{
//        1, 0, -1 ggg
//    }
    private String note;
}
