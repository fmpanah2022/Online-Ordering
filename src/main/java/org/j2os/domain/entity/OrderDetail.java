package org.j2os.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Entity(name = "orderDetail")
@Table( name = "ORDER_DETAIL")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column( name = "ORDER_DETAIL_ID", columnDefinition = "NUMBER")
    private Long customerId;

    @Column ( name = "PRODUCT_ID", columnDefinition = "NUMBER")
    private Long productId;

    @Column ( name = "ORDER_ID")
    private Long orderID;

    @Column ( name = "Quantity")
    private int quantity;

    @Column ( name = "UNIT_PRICE")
    private int unitPrice;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;

    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private List<Product> products;
}
