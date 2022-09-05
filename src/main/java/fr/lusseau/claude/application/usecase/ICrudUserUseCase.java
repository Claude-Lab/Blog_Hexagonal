package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.User;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 04/09/2022
 */
public interface ICrudUserUseCase {
    User create(User user);

    User getOne(Long id);

    List<User> getAll();

    void update(User user);

    void remove(User user);
}
