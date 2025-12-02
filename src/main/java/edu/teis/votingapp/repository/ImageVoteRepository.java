package edu.teis.votingapp.repository;

import edu.teis.votingapp.entity.ImageVote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageVoteRepository extends JpaRepository<ImageVote, Long> {
}