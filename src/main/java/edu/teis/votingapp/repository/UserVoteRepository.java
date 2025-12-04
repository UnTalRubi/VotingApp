package edu.teis.votingapp.repository;

import edu.teis.votingapp.entity.UserVote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserVoteRepository extends JpaRepository<UserVote, Long> {

    boolean existsByEmail(String email);
}
