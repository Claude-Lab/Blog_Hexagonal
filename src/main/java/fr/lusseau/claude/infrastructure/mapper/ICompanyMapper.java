package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.Company;
import fr.lusseau.claude.infrastructure.entity.CompanyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import javax.inject.Named;
import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.mapper
 * @date 27/08/2022
 */
@Mapper
@Named
public interface ICompanyMapper {

    ICompanyMapper INSTANCE = Mappers.getMapper(ICompanyMapper.class);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    @Mapping(target = "withPlace", source = "place")
    @Mapping(target = "withType", source = "type")
    Company companyDtoToCompany(CompanyEntity companyEntity);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    @Mapping(target = "withPlace", source = "place")
    @Mapping(target = "withType", source = "type")
    CompanyEntity companyToCompanyDto(Company company);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    @Mapping(target = "withPlace", source = "place")
    @Mapping(target = "withType", source = "type")
    List<Company> companyDtoListToCompanyList(List<CompanyEntity> companyEntities);

    @Mapping(target = "withId", source = "id")
    @Mapping(target = "withName", source = "name")
    @Mapping(target = "withPlace", source = "place")
    @Mapping(target = "withType", source = "type")
    List<CompanyEntity> companyListToCompanyDtoList(List<Company> companies);
}
