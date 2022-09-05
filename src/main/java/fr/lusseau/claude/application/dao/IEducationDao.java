package fr.lusseau.claude.application.dao;

import fr.lusseau.claude.infrastructure.entity.EducationEntity;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao
 * @date 04/09/2022
 */
public interface IEducationDao {
    List<EducationEntity> getAll();

    EducationEntity getOne(Long id);

    void create(EducationEntity educationEntity);

    void update(EducationEntity educationEntity);

    void remove(EducationEntity educationEntity);

    List<EducationEntity> isTitleExist(String title);

    List<EducationEntity> isUrlExist(String url);
}
