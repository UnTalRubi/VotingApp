package edu.teis.votingapp.dto;

public class ImageVoteDto {

    private Long id;
    private String name;
    private String imagePath;
    private int votes;

    public ImageVoteDto() {}

    public ImageVoteDto(Long id, String name, String imagePath, int votes) {
        this.id = id;
        this.name = name;
        this.imagePath = imagePath;
        this.votes = votes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }
}