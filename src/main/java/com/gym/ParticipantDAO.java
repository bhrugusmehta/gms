package com.gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {
	    private Connection getConnection() throws SQLException {
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management", "root", "Test123$");
	    }

        public void addParticipant(Participant participant) {
            String sql = "INSERT INTO participant (name, batch_id) VALUES (?, ?)";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, participant.getName());
                stmt.setInt(2, participant.getBatchId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        public Participant getParticipant(int id) {
            String sql = "SELECT * FROM participant WHERE id = ?";
            Participant participant = null;
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    participant = new Participant();
                    participant.setId(rs.getInt("id"));
                    participant.setName(rs.getString("name"));
                    participant.setBatchId(rs.getInt("batch_id"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return participant;
        }

        
        public void updateParticipant(Participant participant) {
            String sql = "UPDATE participant SET name = ?, batch_id = ? WHERE id = ?";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, participant.getName());
                stmt.setInt(2, participant.getBatchId());
                stmt.setInt(3, participant.getId());
                stmt.executeUpdate();
                System.out.println(participant);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        
        public void deleteParticipant(int id) {
            String sql = "DELETE FROM participant WHERE id = ?";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        
        public List<Participant> getAllParticipants() {
            List<Participant> participants = new ArrayList<>();
            String sql = "SELECT * FROM participant";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Participant participant = new Participant();
                    participant.setId(rs.getInt("id"));
                    participant.setName(rs.getString("name"));
                    participant.setBatchId(rs.getInt("batch_id"));
                    participants.add(participant);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return participants;
        }

    public List<Participant> getParticipantsByBatch(int batchId) {
        String sql = "SELECT * FROM participant WHERE batch_id = ?";
        List<Participant> participants = new ArrayList<>();
        System.out.println(participants);
        try (Connection conn = getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, batchId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Participant participant = new Participant();
                    participant.setId(rs.getInt("id"));
                    participant.setName(rs.getString("name"));
                    participant.setBatchId(rs.getInt("batch_id"));
                    participants.add(participant);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return participants;
    }
}

