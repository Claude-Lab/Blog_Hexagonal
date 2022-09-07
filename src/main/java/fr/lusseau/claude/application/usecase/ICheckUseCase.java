package fr.lusseau.claude.application.usecase;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase
 * @date 04/09/2022
 */
public interface ICheckUseCase {
    boolean checkIfTitleExperienceExist(String title, Long id);

    boolean checkIfUrlExperienceExist(String url, Long id);

    boolean checkIfTitleEducationExist(String title, Long id);

    boolean checkIfEducationLevelNameExist(String name, Long id);

    boolean checkIfUrlEducationExist(String url, Long id);

    boolean checkIfCompanyNameExist(String name, Long id);

    boolean isEmailExist(String email, Long id);

}
