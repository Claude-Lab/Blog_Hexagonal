package fr.lusseau.claude.application.dao;

import fr.lusseau.claude.infrastructure.entity.UserEntity;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao
 * @date 04/09/2022
 */
public interface IUserDao {

    List<UserEntity> findByEmail(String email);
}
