package com.social.network.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonIgnore
    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "comment_user")
    private User user;

    @JsonIgnore
    @ManyToOne(targetEntity = Post.class)
    @JoinColumn(name = "comment_post")
    private Post post;

    private String content;

}
