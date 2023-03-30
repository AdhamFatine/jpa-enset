package ma.enset.jpaenset.services;

import ma.enset.jpaenset.entities.*;
public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName, String roleName);

}
