package br.com.fabiohigor.events.controller;


import br.com.fabiohigor.events.model.Conference;
import br.com.fabiohigor.events.service.IConferenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conferences")
public class ConferenceController {

    private IConferenceService service;

    public ConferenceController(IConferenceService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Conference> addConference(@RequestBody Conference conference) {
        return ResponseEntity.ok(service.addConference(conference));
    }

    @GetMapping
    public ResponseEntity<List<Conference>> getAllConferences() {
        return ResponseEntity.ok(service.getAllConferences());
    }

    @GetMapping("/{conferenceId}")
    public ResponseEntity<Conference> getConferenceById(@PathVariable("conferenceId") Integer conferenceId) {
        return ResponseEntity.ok(service.getConferenceById(conferenceId));
    }
}
