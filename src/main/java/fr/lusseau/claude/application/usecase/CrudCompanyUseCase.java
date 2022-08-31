package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.Company;
import fr.lusseau.claude.domain.validator.CompanyValidator;
import fr.lusseau.claude.infrastructure.dto.CompanyDTO;
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
        CompanyDTO companyDTO = ICompanyMapper.INSTANCE.companyToCompanyDto(company);
        this.factoryService.getDaoFactory().getCompanyDao().persistAndFlush(companyDTO);
    }

    public Company getOne(Long id) {
        CompanyDTO companyDTO = this.factoryService.getDaoFactory().getCompanyDao().findById(id);
        if (companyDTO == null) {
            return null;
        }
        return ICompanyMapper.INSTANCE.companyDtoToCompany(companyDTO);
    }


    public List<Company> getAll() {
        List<CompanyDTO> companyDTOS = this.factoryService.getDaoFactory().getCompanyDao().listAll();
        if (companyDTOS.isEmpty()) {
            return Collections.emptyList();
        }
        return ICompanyMapper.INSTANCE.companyDtoListToCompanyList(companyDTOS);
    }

    public void update(Company company) {
        CompanyDTO companyDTO = ICompanyMapper.INSTANCE.companyToCompanyDto(company);
        this.factoryService.getDaoFactory().getCompanyDao().update(companyDTO);
    }

    public void remove(Company company) {
        this.factoryService.getDaoFactory().getCompanyDao().delete(ICompanyMapper.INSTANCE.companyToCompanyDto(company));
    }


}
