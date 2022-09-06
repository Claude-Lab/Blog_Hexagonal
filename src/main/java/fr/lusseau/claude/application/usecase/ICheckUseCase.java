package fr.lusseau.claude.application.usecase;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 04/09/2022
 */
public interface ICheckUseCase {
    boolean checkIfTitleExperienceExist(String title);

    boolean checkIfUrlExperienceExist(String url);

    boolean checkIfTitleEducationExist(String title);

    boolean checkIfEducationLevelNameExist(String name);

    boolean checkIfUrlEducationExist(String url);

    boolean checkIfCompanyNameExist(String name);

    boolean isEmailExist(String email, Long id);

    boolean  isEmailExistForCreate(String email);
}
