package fr.lusseau.claude.application.usecase;

import fr.lusseau.claude.domain.model.Company;

import java.util.List;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 04/09/2022
 */
public interface ICrudCompanyUseCase {
    Company create(Company company);

    Company getOne(Long id);

    List<Company> getAll();

    void update(Company company);

    void remove(Company company);
}
