package com.gym;

import java.io.IOException;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class BatchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BatchService batchService;

    @Override
    public void init() throws ServletException {
        batchService = new BatchService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("list".equals(action)) {
            List<Batch> batches = batchService.getAllBatches();
            request.setAttribute("batches", batches);
            request.getRequestDispatcher("/listBatch.jsp").forward(request, response);
        } else if ("update".equals(action) && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Batch batch = batchService.getBatch(id);
            request.setAttribute("batch", batch);
            request.getRequestDispatcher("/updateBatch.jsp").forward(request, response);
        } else if ("delete".equals(action) && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            batchService.deleteBatch(id);
            response.sendRedirect("batch?action=list");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("_method");
        System.out.println(method);
        if ("PUT".equalsIgnoreCase(method)) {
            doPut(request, response);
        } else {
            String name = request.getParameter("name");
            String sessionTime = request.getParameter("timeOfDay");

            Batch batch = new Batch();
            batch.setName(name);
            batch.setTimeOfDay(sessionTime);

            batchService.addBatch(batch);
            response.sendRedirect("batch?action=list");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String sessionTime = request.getParameter("timeOfDay");

        Batch batch = new Batch();
        batch.setId(id);
        batch.setName(name);
        batch.setTimeOfDay(sessionTime);

        batchService.updateBatch(batch);
        response.sendRedirect("batch?action=list");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        batchService.deleteBatch(id);
        response.sendRedirect("batch?action=list");
    }
}
