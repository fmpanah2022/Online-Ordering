package org.j2os.domain.View;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;
import java.io.Serializable;

@Immutable
@Entity( name = "ORDER_DETAIL_VIEW")
@Subselect(value = "Select " +
        "        D.ORDER_DETAIL_ID, D.ORDER_ID, D.PRODUCT_ID , D.QUANTITY , D.UNIT_PRICE," +
        "        D.versionNumber DETAIL_VNO, P.PRODUCT_DESC ,  P.PRCATEGORY_ID," +
        "        PC.PRCATEGORY_NAME  " +
        "        FROM ( Select * From ORDERS Where REMOVE_DATETIME IS NULL ) O , " +
        "             ( Select * From ORDER_DETAIL Where REMOVE_DATETIME IS NULL )  D ," +
        "             ( Select * From PRODUCT Where REMOVE_DATETIME IS NULL )  P," +
        "             ( Select * From PRODUCT_CATEGORY Where REMOVE_DATETIME IS NULL ) PC " +
        "        WHERE O.ORDER_ID = D.ORDER_ID AND D.PRODUCT_ID = P.PRODUCT_ID AND P.PRCATEGORY_ID = PC.PRCATEGORY_ID ")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDetailView implements Serializable {
    @Id
    @Column( name = "ORDER_DETAIL_ID")
    private Long orderDetailId;

    @Column( name = "ORDER_ID")
    private Long orderId;

    @Column( name = "PRODUCT_ID")
    private Long productId;

    @Column( name = "PRODUCT_DESC")
    private String productDesc;

    @Column( name = "QUANTITY")
    private int quantity;

    @Column( name = "UNIT_PRICE")
    private int unitPrice;

    @Column( name = "PRCATEGORY_ID")
    private Long prCategoryId;

    @Column( name = "PRCATEGORY_NAME")
    private String prCategoryName;

    @Column( name = "DETAIL_VNO")
    private int detailVno;

    @Transient
    private int totalPrice;

    public int getTotalPrice() {
        return unitPrice * quantity;
    }
}
