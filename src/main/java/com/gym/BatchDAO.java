package com.gym;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchDAO {
	    private Connection getConnection() throws SQLException  {
	    	try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	        return DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management?serverTimezone=UTC", "root", "Test123$");
	    }


        public void addBatch(Batch batch) {
            String sql = "INSERT INTO batch (name, time_of_day) VALUES (?, ?)";
            try {
            	Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, batch.getName());
                stmt.setString(2, batch.getTimeOfDay());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public Batch getBatch(int id) {
            String sql = "SELECT * FROM batch WHERE id = ?";
            Batch batch = null;
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    batch = new Batch();
                    batch.setId(rs.getInt("id"));
                    batch.setName(rs.getString("name"));
                    batch.setTimeOfDay(rs.getString("time_of_day"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return batch;
        }

        public void updateBatch(Batch batch) {
            String sql = "UPDATE batch SET name = ?, time_of_day = ? WHERE id = ?";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, batch.getName());
                stmt.setString(2, batch.getTimeOfDay());
                stmt.setInt(3, batch.getId());
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void deleteBatch(int id) {
            String sql = "DELETE FROM batch WHERE id = ?";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public List<Batch> getAllBatches() {
            List<Batch> batches = new ArrayList<>();
            String sql = "SELECT * FROM batch";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Batch batch = new Batch();
                    batch.setId(rs.getInt("id"));
                    batch.setName(rs.getString("name"));
                    batch.setTimeOfDay(rs.getString("time_of_day"));

                    batches.add(batch);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return batches;
        }

}
