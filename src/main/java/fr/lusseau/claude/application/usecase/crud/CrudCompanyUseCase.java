package fr.lusseau.claude.application.usecase.crud;

import fr.lusseau.claude.application.factory.IAbstractCrudDaoFactory;
import fr.lusseau.claude.application.factory.IAbstractCrudUseCaseFactory;
import fr.lusseau.claude.domain.model.Company;
import fr.lusseau.claude.domain.validator.CompanyValidator;
import fr.lusseau.claude.infrastructure.entity.CompanyEntity;
import fr.lusseau.claude.infrastructure.mapper.ICompanyMapper;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Collections;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.impl
 * @date 29/08/2022
 */
@Named
@LogAudited
public class CrudCompanyUseCase implements IAbstractCrudUseCaseFactory<Company> {

    private final IAbstractCrudDaoFactory<CompanyEntity> dao;

    @Inject
    public CrudCompanyUseCase(IAbstractCrudDaoFactory<CompanyEntity> dao) {
        this.dao = dao;
    }


    @Override
    public Company create(Company company) {
        CompanyEntity companyEntity = ICompanyMapper.INSTANCE.companyToCompanyDto(company);
        dao.create(companyEntity);
        if(companyEntity.getId() == null) {
            return null;
        }
        return ICompanyMapper.INSTANCE.companyDtoToCompany(companyEntity);
    }

    @Override
    public Company getOne(Long id) {
        CompanyEntity companyEntity = dao.getOne(id);
        if (companyEntity == null) {
            return null;
        }
        return ICompanyMapper.INSTANCE.companyDtoToCompany(companyEntity);
    }


    @Override
    public List<Company> getAll() {
        List<CompanyEntity> companyEntities = dao.getAll();
        if (companyEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return ICompanyMapper.INSTANCE.companyDtoListToCompanyList(companyEntities);
    }

    @Override
    public void update(Company company) {
        CompanyValidator.validateCompany(company);
        CompanyEntity companyEntity = ICompanyMapper.INSTANCE.companyToCompanyDto(company);
        dao.update(companyEntity);
    }

    @Override
    public void remove(Company company) {
        dao.remove(ICompanyMapper.INSTANCE.companyToCompanyDto(company));
    }


}
