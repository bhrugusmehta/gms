package com.gym;

import java.util.List;

public class BatchService {
    private BatchDAO batchRepository = new BatchDAO();
    public void addBatch(Batch batch) {
        batchRepository.addBatch(batch);
    }
    public void updateBatch(Batch batch) {
        batchRepository.updateBatch(batch);
    }
    public void deleteBatch(int id) {
        batchRepository.deleteBatch(id);
    }
    public Batch getBatch(int id) {
        return batchRepository.getBatch(id);
    }
    public List<Batch> getAllBatches() {
        return batchRepository.getAllBatches();
    }
}
