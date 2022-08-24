package fr.lusseau.claude.application.dao;

import fr.lusseau.claude.infrastructure.dto.UserDTO;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao
 * @date 14/08/2022
 */
public interface IUserDao {

    void create(UserDTO userDTO);

    UserDTO edit(UserDTO userDTO);

    void remove(Long id);

    UserDTO findUser(Long id);

    List<UserDTO> findAll();

    Boolean isEmailExist(String email);
}