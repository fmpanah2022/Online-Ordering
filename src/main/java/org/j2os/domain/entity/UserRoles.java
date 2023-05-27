package org.j2os.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity ( name = "userRoles")
@Table ( name = "User_ROLES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@NamedQueries({
        @NamedQuery(name = "userRoles.findByUserNameAndPassword" , query = " select ur from userRoles ur left join fetch ur.user u  " +
                " where upper(u.userName) = :userName and upper(u.password) = :password and ur.removeDateTime is null and u.removeDateTime is null "),
        @NamedQuery(name = "userRoles.findByUserId" , query = " select ur from userRoles ur left join fetch ur.user u  " +
                " where u.userId = :userId and ur.removeDateTime is null and u.removeDateTime is null ")
})

public class UserRoles implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column( name = "USER_ROLES_ID")
    private Long userRolesId;

    @Column( name = "ROLE_NAME")
    private String roleName;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn ( name = "USER_ID")
    private Users user;
}
