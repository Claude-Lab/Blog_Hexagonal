package fr.lusseau.claude.application.dao;

import fr.lusseau.claude.infrastructure.entity.UserEntity;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao
 * @date 14/08/2022
 */
public interface IUserDao {

    Long create(UserEntity user);

    Long edit(UserEntity user);

    Boolean remove(UserEntity user);

    UserEntity findUser(Long id);
}