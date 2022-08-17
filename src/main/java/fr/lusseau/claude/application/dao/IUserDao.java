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

    Boolean create(UserDTO user);

    Long edit(UserDTO user);

    Integer remove(Long id);

    UserDTO findUser(Long id);

    List<UserDTO> findAll();
}