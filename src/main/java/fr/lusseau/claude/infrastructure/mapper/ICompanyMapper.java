package fr.lusseau.claude.infrastructure.mapper;

import fr.lusseau.claude.domain.model.Company;
import fr.lusseau.claude.infrastructure.dto.CompanyDTO;
import fr.lusseau.claude.infrastructure.utils.annotation.LogAudited;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.infrastructure.mapper
 * @date 17/08/2022
 */
@LogAudited
@Mapper
public interface ICompanyMapper {

    CompanyDTO entityToDTO(Company company);

    List<CompanyDTO> entityToDTO(Iterable<Company> companies);

    Company dtoToEntity(CompanyDTO companyDTO);

    List<Company> dtoToEntity(Iterable<CompanyDTO> companyDTOS);

}