package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.Education;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 04/09/2022
 */
public interface ICrudEducationUseCase {
    void create(Education education);

    Education getOne(Long id);

    List<Education> getAll();

    void update(Education education);

    void remove(Education education);
}
