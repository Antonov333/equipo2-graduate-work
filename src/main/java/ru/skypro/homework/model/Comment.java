package ru.skypro.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * <h2>Comment</h2>
 * Represents entity of comment published by user to advertisement or other comment
 */
@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long pk;

    @Column(name = "user_id")
    long userId; // author of comment id

    @Column(name = "created_at")
    private long createdAt; // time of creation of comment

    @Column(name = "text")
    @Size(min = 8, max = 64)
    private String text;

    @Column(name = "author_image")
    private String authorImage;

    @Column(name = "author_first_name")
    private String authorFirstName;

    @Column(name = "ad_id")
    private long adId;

}
