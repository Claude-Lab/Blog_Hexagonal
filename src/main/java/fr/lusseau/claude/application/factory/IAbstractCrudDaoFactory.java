package fr.lusseau.claude.application.factory;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.dao
 * @date 08/09/2022
 */
public interface IAbstractCrudDaoFactory<H> {

    List<H> getAll();
    H getOne(Long id);
    void create(H entity);
    void update(H entity);
    void remove(H entity);
}
