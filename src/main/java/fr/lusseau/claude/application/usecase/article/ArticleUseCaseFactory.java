package fr.lusseau.claude.application.usecase.article;

import fr.lusseau.claude.domain.model.Article;
import fr.lusseau.claude.domain.model.Education;
import fr.lusseau.claude.domain.model.Experience;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.application.usecase.article
 * @date 13/08/2022
 */
public class ArticleUseCaseFactory {

    public static Article getArticle(Long id) {
        Article article = null;
        if(article instanceof Experience) {
            return new Experience(Experience.builder());
        }
        if (article instanceof Education) {
            return new Education(Education.builder());
        }
        return article;
    }
}
