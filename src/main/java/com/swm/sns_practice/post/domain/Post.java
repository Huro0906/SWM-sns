package com.swm.sns_practice.post.domain;

import com.swm.sns_practice.common.domain.BaseTimeEntity;
import com.swm.sns_practice.member.domain.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.hibernate.annotations.SoftDelete;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "posts")
@SoftDelete
public class Post extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "UUID")
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member author;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public Post(Member author, String content) {
        this.author = author;
        this.content = content;
    }

    public void update(String content) {
        this.content = content;
    }
}
