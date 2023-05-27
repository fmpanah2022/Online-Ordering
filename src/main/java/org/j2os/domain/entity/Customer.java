package org.j2os.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "customer")
@Table( name = "CUSTOMER")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column( name = "CUSTOMER_ID", columnDefinition = "NUMBER")
    private Long customerId;

    @Column ( name = "TELL", columnDefinition = "VARCHAR2(20)")
    private String tell;

    @Column ( name = "MOBILE", columnDefinition = "VARCHAR2(20)")
    private String mobile;

    @Column ( name = "ADDRESS", columnDefinition = "VARCHAR2(100)")
    private String address;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;
    // relation with users

    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn ( name = "USER_ID")
    private Users user;
}
