package org.j2os.repository.modern;

import org.j2os.domain.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users , Long> {
    Users findUsersByUserNameAndPasswordAndRemoveDateTimeIsNull(String userName , String password);

}