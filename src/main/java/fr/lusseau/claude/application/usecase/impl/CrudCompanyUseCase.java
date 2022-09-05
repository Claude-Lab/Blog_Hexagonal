package fr.lusseau.claude.application.usecase.impl;

import fr.lusseau.claude.application.usecase.ICrudCompanyUseCase;
import fr.lusseau.claude.domain.model.Company;
import fr.lusseau.claude.infrastructure.entity.CompanyEntity;
import fr.lusseau.claude.infrastructure.factory.FactoryService;
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
public class CrudCompanyUseCase implements ICrudCompanyUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudCompanyUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }


    @Override
    public Company create(Company company) {
        CompanyEntity companyEntity = ICompanyMapper.INSTANCE.companyToCompanyDto(company);
        factoryService.getDaoFactory().getCompanyDao().create(companyEntity);
        if(companyEntity.getId() == null) {
            return null;
        }
        return ICompanyMapper.INSTANCE.companyDtoToCompany(companyEntity);
    }

    @Override
    public Company getOne(Long id) {
        CompanyEntity companyEntity = this.factoryService.getDaoFactory().getCompanyDao().getOne(id);
        if (companyEntity == null) {
            return null;
        }
        return ICompanyMapper.INSTANCE.companyDtoToCompany(companyEntity);
    }


    @Override
    public List<Company> getAll() {
        List<CompanyEntity> companyEntities = this.factoryService.getDaoFactory().getCompanyDao().getAll();
        if (companyEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return ICompanyMapper.INSTANCE.companyDtoListToCompanyList(companyEntities);
    }

    @Override
    public void update(Company company) {
        CompanyEntity companyEntity = ICompanyMapper.INSTANCE.companyToCompanyDto(company);
        this.factoryService.getDaoFactory().getCompanyDao().update(companyEntity);
    }

    @Override
    public void remove(Company company) {
        this.factoryService.getDaoFactory().getCompanyDao().remove(ICompanyMapper.INSTANCE.companyToCompanyDto(company));
    }


}
