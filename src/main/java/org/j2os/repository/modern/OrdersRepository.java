package org.j2os.repository.modern;

import org.j2os.domain.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Orders , Long> {

}
