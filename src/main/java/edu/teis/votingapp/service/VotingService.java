package edu.teis.votingapp.service;

import edu.teis.votingapp.dto.ImageVoteDto;
import edu.teis.votingapp.entity.ImageVote;
import edu.teis.votingapp.repository.ImageVoteRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VotingService {

    @Autowired
    private ImageVoteRepository imageVoteRepository;

    @PostConstruct
    public void initDatabase() {
        if (imageVoteRepository.count() == 0) {
            ImageVote image1 = new ImageVote("Silksong", "/images/Silksong.jpg");
            ImageVote image2 = new ImageVote("Hades 2", "/images/Hades2.jpg");
            ImageVote image3 = new ImageVote("Expedition 33", "/images/Expedition33.jpg");

            imageVoteRepository.save(image1);
            imageVoteRepository.save(image2);
            imageVoteRepository.save(image3);
        }
    }

    public List<ImageVoteDto> getAllImages() {
        return imageVoteRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public void voteForImage(Long imageId) {
        ImageVote image = imageVoteRepository.findById(imageId)
                .orElseThrow(() -> new RuntimeException("Imagen no encontrada"));
        image.incrementVotes();
        imageVoteRepository.save(image);
    }

    private ImageVoteDto convertToDto(ImageVote image) {
        return new ImageVoteDto(
                image.getId(),
                image.getName(),
                image.getImagePath(),
                image.getVotes()
        );
    }
}