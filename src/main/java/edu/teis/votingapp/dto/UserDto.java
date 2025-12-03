package edu.teis.votingapp.dto;


public class UserDto {

    @NotNull
    @Email(regexp = ".+[@].+[\\.].+")
    String email;

    public UserDto(){}

    public UserDto(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}