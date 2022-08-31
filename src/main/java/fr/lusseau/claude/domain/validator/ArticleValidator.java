package fr.lusseau.claude.domain.validator;

import fr.lusseau.claude.domain.model.Article;
import fr.lusseau.claude.domain.exception.ValidatorException;

import java.io.Serializable;

import static java.util.Objects.isNull;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.validator
 * @date 26/08/2022
 */
public class ArticleValidator implements Serializable {

    static String authorRequired = "authorRequired";

    static String urlRequired = "urlRequired";

    static String titleRequired = "titleRequired";

    static String createdAtRequired = "createdAtRequired";

    public static void validateArticle(final Article article) {

        if (isNull(article.getAuthor())) throw new ValidatorException(authorRequired);
        if ((article.getUrl().isBlank())) throw new ValidatorException(urlRequired);
        if (isNull(article.getUrl())) throw new ValidatorException(urlRequired);
        if ((article.getTitle().isBlank())) throw new ValidatorException(titleRequired);
        if (isNull(article.getTitle())) throw new ValidatorException(titleRequired);
        if (isNull(article.getCreatedAt())) throw new ValidatorException(createdAtRequired);
    }
}
