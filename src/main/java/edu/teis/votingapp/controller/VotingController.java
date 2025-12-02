package edu.teis.votingapp.controller;

import edu.teis.votingapp.dto.ImageVoteDto;
import edu.teis.votingapp.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class VotingController {

    @Autowired
    private VotingService votingService;

    @GetMapping("/")
    public String showVotingPage(Model model) {
        List<ImageVoteDto> images = votingService.getAllImages();
        model.addAttribute("images", images);
        return "index";
    }

    @PostMapping("/vote/{id}")
    public String voteForImage(@PathVariable Long id) {
        votingService.voteForImage(id);
        return "redirect:/";
    }
}