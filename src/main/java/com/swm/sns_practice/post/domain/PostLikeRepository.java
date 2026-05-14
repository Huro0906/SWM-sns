package com.swm.sns_practice.post.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface PostLikeRepository extends JpaRepository<PostLike, UUID> {
}
