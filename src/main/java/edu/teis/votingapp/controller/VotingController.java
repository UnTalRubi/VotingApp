package edu.teis.votingapp.controller;

import edu.teis.votingapp.dto.ImageVoteDto;
import edu.teis.votingapp.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/vote")
    public String voteForImage(
            @RequestParam String email,
            @RequestParam Long imageId) {

        votingService.voteForImage(imageId, email);
        return "redirect:/";
    }
}