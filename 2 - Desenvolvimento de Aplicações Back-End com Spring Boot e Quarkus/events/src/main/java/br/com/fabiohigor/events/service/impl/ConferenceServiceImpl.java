package br.com.fabiohigor.events.service.impl;

import br.com.fabiohigor.events.exception.NotFoundException;
import br.com.fabiohigor.events.model.Conference;
import br.com.fabiohigor.events.repository.ConferenceRepository;
import br.com.fabiohigor.events.service.IConferenceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConferenceServiceImpl implements IConferenceService {

    private ConferenceRepository repository;

    public ConferenceServiceImpl(ConferenceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Conference addConference(Conference conference) {
        if (conference == null) {
            throw new IllegalArgumentException("Conference cannot be null");
        }
        return repository.save(conference);
    }

    @Override
    public Conference getConferenceById(Integer conferenceId) {
        if (conferenceId == null) {
            throw new IllegalArgumentException("Conference ID cannot be null");
        }
        return repository.findById(conferenceId)
                .orElseThrow(() -> new NotFoundException("Conference not found with ID: " + conferenceId));
    }

    @Override
    public List<Conference> getAllConferences() {
        return repository.findAll();
    }
}
