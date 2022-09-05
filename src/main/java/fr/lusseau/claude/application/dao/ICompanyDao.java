package fr.lusseau.claude.application.dao;

import fr.lusseau.claude.infrastructure.entity.CompanyEntity;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.dao
 * @date 04/09/2022
 */
public interface ICompanyDao {
    List<CompanyEntity> getAll();

    CompanyEntity getOne(Long id);

    void create(CompanyEntity companyEntity);

    void update(CompanyEntity companyEntity);

    void remove(CompanyEntity companyEntity);

    List<CompanyEntity> isNameExist(String name);
}
