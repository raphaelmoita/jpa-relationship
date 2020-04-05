package org.moita.relationship.repository;

import org.moita.relationship.entity.Comment;
import org.moita.relationship.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

}
