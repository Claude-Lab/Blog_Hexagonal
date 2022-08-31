package fr.lusseau.claude.application.usecase;

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
public class CrudCompanyUseCase {

    private final FactoryService factoryService;

    @Inject
    public CrudCompanyUseCase(FactoryService factoryService) {
        this.factoryService = factoryService;
    }

    public void create(Company company) {
        CompanyEntity companyEntity = ICompanyMapper.INSTANCE.companyToCompanyDto(company);
        this.factoryService.getDaoFactory().getCompanyDao().persistAndFlush(companyEntity);
    }

    public Company getOne(Long id) {
        CompanyEntity companyEntity = this.factoryService.getDaoFactory().getCompanyDao().findById(id);
        if (companyEntity == null) {
            return null;
        }
        return ICompanyMapper.INSTANCE.companyDtoToCompany(companyEntity);
    }


    public List<Company> getAll() {
        List<CompanyEntity> companyEntities = this.factoryService.getDaoFactory().getCompanyDao().listAll();
        if (companyEntities.isEmpty()) {
            return Collections.emptyList();
        }
        return ICompanyMapper.INSTANCE.companyDtoListToCompanyList(companyEntities);
    }

    public void update(Company company) {
        CompanyEntity companyEntity = ICompanyMapper.INSTANCE.companyToCompanyDto(company);
        this.factoryService.getDaoFactory().getCompanyDao().update(companyEntity);
    }

    public void remove(Company company) {
        this.factoryService.getDaoFactory().getCompanyDao().delete(ICompanyMapper.INSTANCE.companyToCompanyDto(company));
    }


}
