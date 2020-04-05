package org.moita.relationship.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.moita.relationship.entity.Comment;
import org.moita.relationship.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@ExtendWith(SpringExtension.class)
@Import(TestConfiguration.class)
@DataJpaTest
public class PostRepositoryTest {

    private PostRepository  postRepository;

    private TestEntityManager entityManager;

    @Autowired
    public PostRepositoryTest(PostRepository postRepository, TestEntityManager entityManager) {
        this.postRepository = postRepository;
        this.entityManager = entityManager;
    }

    @Test
    public void contextLoads() {

        assertThat(postRepository, is(notNullValue()));
        assertThat(entityManager, is(notNullValue()));
    }

    @Test
    public void shouldAddNewPost() {

        Post post = new Post();
        post.setTitle("1st post");
        post.setDescription("This is my 1st 2020 post");

        Comment comment = new Comment();
        comment.setComment("I liked this 1st post");
        post.addComment(comment);

        entityManager.persist(post);
        entityManager.flush();

        postRepository.findById(post.getId())
            .orElseThrow(RuntimeException::new);
    }

}