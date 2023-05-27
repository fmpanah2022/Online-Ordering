package org.j2os.repository.modern;

import org.j2os.domain.entity.UserRoles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRolesRepository extends JpaRepository<UserRoles , Long> {
    List<UserRoles> findUserRolesByUser_UserNameAndUser_PasswordAndRemoveDateTimeIsNull(String userName ,String password);
}
