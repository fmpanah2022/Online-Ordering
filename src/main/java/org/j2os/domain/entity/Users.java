package org.j2os.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity( name = "users")
@Table( name = "USERS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@NamedQueries({
        @NamedQuery(name = "users.findByUserNameAndPassword" , query = " select u from users u " +
                " where u.removeDateTime is null  and upper(u.userName) = :userName " +
                " and upper(u.password) = :password ")
})
public class Users implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column ( name = "USER_ID" , columnDefinition = "NUMBER")
    private Long userId;

    @Column ( name = "USERNAME" , columnDefinition = "VARCHAR2(20)")
    private Long userName;

    @Column ( name = "PASSWORD" , columnDefinition = "VARCHAR2(20)")
    private Long password;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;


}
