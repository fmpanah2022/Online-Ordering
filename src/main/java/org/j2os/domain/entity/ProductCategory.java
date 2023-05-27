package org.j2os.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity(name = "productCategory")
@Table( name = "PRODUCT_CATEGORY")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory implements Serializable {
    @Id
    @GeneratedValue ( strategy = GenerationType.AUTO)
    @Column( name = "PRCATEGORY_ID", columnDefinition = "NUMBER")
    private Long prCategoryId;

    @Column( name = "PRCATEGORY_NAME", columnDefinition = "VARCHAR2(20)")
    private String prCategoryName;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;
 }
