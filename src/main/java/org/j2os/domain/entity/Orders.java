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

@Entity(name = "orders")
@Table( name = "ORDERS")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders implements Serializable {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    @Column( name = "ORDER_ID", columnDefinition = "NUMBER")
    private Long orderId;

    @Column ( name = "ORDER_NUMBER", columnDefinition = "INT")
    private int orderNumber;

    @Column ( name = "ORDER_DATE")
    private Timestamp orderDate;

    @Column ( name = "REMOVE_DATETIME" )
    private Timestamp removeDateTime;
    @Version
    private int versionNumber;


    @Column( name = "PAYMENT_ID", columnDefinition = "NUMBER")
    private Long paymentId;

    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn( name = "ORDER_ID")
    private List<OrderDetail> orderDetails = new ArrayList<>();

    @OneToMany( fetch = FetchType.LAZY)
    @JoinColumn( name = "PAYMENT_ID")
    private List<Payment> payments = new ArrayList<>();
}
