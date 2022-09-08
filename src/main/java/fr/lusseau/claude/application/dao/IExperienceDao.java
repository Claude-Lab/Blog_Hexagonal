package fr.lusseau.claude.application.dao;

import fr.lusseau.claude.infrastructure.entity.ExperienceEntity;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao
 * @date 04/09/2022
 */
public interface IExperienceDao {

    List<ExperienceEntity> isTitleExist(String title);

    List<ExperienceEntity> isUrlExist(String url);
}
