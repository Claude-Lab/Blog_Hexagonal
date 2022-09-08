package fr.lusseau.claude.application.factory;


import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 29/08/2022
 */
public interface IAbstractCrudUseCaseFactory<T> {

    List<T> getAll();
    T getOne(Long id);
    T create(T entity);
    void update(T entity);
    void remove(T entity);

}
