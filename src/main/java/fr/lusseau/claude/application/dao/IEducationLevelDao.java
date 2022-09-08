package fr.lusseau.claude.application.dao;

import fr.lusseau.claude.infrastructure.entity.EducationLevelEntity;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao
 * @date 04/09/2022
 */
public interface IEducationLevelDao {

    List<EducationLevelEntity> findByName(String name);
}
