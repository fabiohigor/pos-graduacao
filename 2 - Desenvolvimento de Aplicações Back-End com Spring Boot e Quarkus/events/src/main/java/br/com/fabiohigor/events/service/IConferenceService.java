package br.com.fabiohigor.events.service;

import br.com.fabiohigor.events.model.Conference;

import java.util.List;

public interface IConferenceService {

    public Conference addConference(Conference conference);
    public Conference getConferenceById(Integer conferenceId);
    public List<Conference> getAllConferences();
}
