package com.gym;

import java.util.List;

public class ParticipantService {
    private ParticipantDAO participantRepository = new ParticipantDAO();

    public void addParticipant(Participant participant) {
        participantRepository.addParticipant(participant);
    }

    public void updateParticipant(Participant participant) {
        participantRepository.updateParticipant(participant);
    }

    public void deleteParticipant(int id) {
        participantRepository.deleteParticipant(id);
    }

    public Participant getParticipant(int id) {
        return participantRepository.getParticipant(id);
    }

    public List<Participant> getAllParticipants() {
        return participantRepository.getAllParticipants();
    }

    public List<Participant> getAllParticipantsByBatch(int batchId) {
        return participantRepository.getParticipantsByBatch(batchId);
    }

}
