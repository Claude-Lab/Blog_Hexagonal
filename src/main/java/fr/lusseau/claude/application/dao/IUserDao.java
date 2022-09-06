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
    List<UserEntity> getAll();

    UserEntity getOne(Long id);

    void create(UserEntity userEntity);

    void update(UserEntity userEntity);

    void remove(UserEntity userEntity);

    List<UserEntity> findByEmail(String email);
}
