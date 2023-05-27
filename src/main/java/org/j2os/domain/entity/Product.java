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

@Entity ( name = "product")
@Table( name = "PRODUCT")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column( name = "PRODUCT_ID" , columnDefinition = "NUMBER")
    private Long productId;

    @Column( name = "PRODUCT_PRICE" , columnDefinition = "FLOAT")
    private float productPrice;

    @Column( name = "PRODUCT_DESC" , columnDefinition = "VARCHAR2(30)")
    private float productDesc;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;
    //Relation with Product Category

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRCATEGORY_ID")
    private ProductCategory productCategory;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRIMAGE_ID")
    private List<ProductImages> productImage = new ArrayList<>();

}
