package fr.lusseau.claude.domain.model;

import org.junit.jupiter.api.Test;
import org.wildfly.common.Assert;

import java.time.LocalDateTime;

/**
 * @author Claude Lusseau
 * @project site_perso
 * @package fr.lusseau.claude.domain.model
 * @date 11/08/2022
 */
class ArticleTest {

    @Test
    void shouldGetArticleInformation() {
        Article article = Article.builder()
                .withId(1L)
                .withTitle("test title")
                .withBody("Body test")
                .withUrl("test url")
                .withCreatedAt(LocalDateTime.now())
                .withAuthor(User.builder().build())
                .build();
        Assert.assertNotNull(article);
    }
}
