package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.Experience;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 04/09/2022
 */
public interface ICrudExperienceUseCase {
    void create(Experience education);

    Experience getOne(Long id);

    List<Experience> getAll();

    void update(Experience education);

    void remove(Experience education);
}
