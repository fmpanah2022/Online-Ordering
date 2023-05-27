package org.j2os.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sales")
@Table( name = "SALES")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Sales implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column( name = "SALE_ID", columnDefinition = "NUMBER")
    private Long customerId;

    @Column(name = "SALE_DATE" )
    private Timestamp SaleDate;

    @Column( name = "SALE_NO" , columnDefinition = "NUMBER")
    private int SaleNo;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;

    // relation with Product
    @OneToOne(fetch = FetchType.LAZY )
    @JoinColumn( name = "ORDER_ID")
    private Orders order;

    @OneToMany ( fetch= FetchType.LAZY)
    @JoinColumn( name = "SALE_ID" )
    private List<SaleDetail> saleDetails = new ArrayList<>();
}
