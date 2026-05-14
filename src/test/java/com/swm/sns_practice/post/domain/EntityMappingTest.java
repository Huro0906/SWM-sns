package com.swm.sns_practice.post.domain;

import com.swm.sns_practice.member.domain.Member;
import com.swm.sns_practice.member.domain.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import com.swm.sns_practice.common.config.JpaAuditConfig;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Import(JpaAuditConfig.class)
class EntityMappingTest {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private PostRepository postRepository;

    @Test
    @DisplayName("Member와 Post 매핑 확인 (UUID 사용)")
    void memberPostMappingTest() {
        // given
        Member member = Member.builder()
                .email("test@test.com")
                .password("password")
                .nickname("tester")
                .build();
        memberRepository.save(member);

        Post post = Post.builder()
                .author(member)
                .content("test content")
                .build();
        postRepository.save(post);

        // when
        Post savedPost = postRepository.findById(post.getId()).orElseThrow();

        // then
        assertThat(savedPost.getId()).isInstanceOf(UUID.class);
        assertThat(savedPost.getContent()).isEqualTo("test content");
        assertThat(savedPost.getAuthor().getNickname()).isEqualTo("tester");
        assertThat(savedPost.getCreatedAt()).isNotNull();
    }
}
