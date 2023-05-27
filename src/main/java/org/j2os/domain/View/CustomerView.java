package org.j2os.domain.View;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "customerView")
@Immutable
@Subselect(value = "Select " +
        "        C.CUSTOMER_ID, C.TELL, C.MOBILE , C.ADDRESS , C.versionNumber CUSTOMER_VNO," +
        "        C.USER_ID , U.USERNAME ,  U.versionNumber USER_VNO " +
        "        FROM ( Select * From CUSTOMER Where REMOVE_DATETIME IS NULL ) C , " +
        "             ( Select * From USERS Where REMOVE_DATETIME IS NULL )  U " +
        "        WHERE C.USER_ID = U.USER_ID  ")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerView implements Serializable {
    @Id
    @Column( name = "CUSTOMER_ID")
    private Long customerId;

    @Column( name = "TELL")
    private String tell;

    @Column( name = "MOBILE")
    private Long mobile;

    @Column( name = "ADDRESS")
    private Long address;

    @Column( name = "CUSTOMER_VNO")
    private Long customerVno;

    @Column( name = "USER_ID")
    private Long userId;

    @Column( name = "USERNAME")
    private Long userName;

    @Column( name = "USER_VNO")
    private Long userVno;
}
