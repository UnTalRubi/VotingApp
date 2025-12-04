package edu.teis.votingapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "user_votes")
public class UserVote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @ManyToOne
    @JoinColumn(name = "image_id", nullable = false)
    private ImageVote imageVote;

    public UserVote() {}

    public UserVote(String email, ImageVote imageVote) {
        this.email = email;
        this.imageVote = imageVote;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ImageVote getImageVote() {
        return imageVote;
    }

    public void setImageVote(ImageVote imageVote) {
        this.imageVote = imageVote;
    }
}
