package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.EducationLevel;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 04/09/2022
 */
public interface ICrudEducationLevelUseCase {
    EducationLevel create(EducationLevel educationLevel);

    EducationLevel getOne(Long id);

    List<EducationLevel> getAll();

    void update(EducationLevel educationLevel);

    void remove(EducationLevel educationLevel);
}
