package org.j2os.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "productImages")
@Table( name = "PRODUCT_IMAGES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductImages implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column( name = "PRIMAGE_ID", columnDefinition = "NUMBER")
    private Long prImageId;

    @Column( name = "PRIMAGE_NAME", columnDefinition = "VARCHAR2(30)")
    private String prImageName;

    @Column( name = "PRIMAGE_PATH", columnDefinition = "VARCHAR2(100)")
    private String prImagePath;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;
}
