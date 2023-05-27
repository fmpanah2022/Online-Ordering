package org.j2os.repository.modern;

import org.j2os.domain.View.OrderDetailView;
import org.j2os.domain.entity.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailViewRepository extends JpaRepository<OrderDetailView , Long> {
    List<OrderDetailView> findOrderDetailViewsByOrderId(Long orderId);
    OrderDetailView findOrderDetailViewByOrderDetailId(Long orderDetailId);
 //   Optional<OrderDetailView> findOrderDetailViewByOrderDetailId(Long orderDetailId);
    List<OrderDetailView> findOrderDetailViewByOrderDetailIdAndProductId(Long productId);


}
