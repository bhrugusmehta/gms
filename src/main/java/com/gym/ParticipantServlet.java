package com.gym;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaticipantServlet
 */
import java.sql.SQLException;
import java.util.List;

public class ParticipantServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ParticipantService participantService;

    @Override
    public void init() throws ServletException {
    	participantService = new ParticipantService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String batchIdParam = request.getParameter("batchId");

        if (batchIdParam != null) {
            List<Participant> participants = participantService.getAllParticipantsByBatch(Integer.parseInt(batchIdParam));
            request.setAttribute("participants", participants);
            request.getRequestDispatcher("/participantsInBatch.jsp").forward(request, response);
        } else if ("list".equals(action)) {
            List<Participant> participants = participantService.getAllParticipants();
            request.setAttribute("participants", participants);
            request.getRequestDispatcher("/listParticipant.jsp").forward(request, response);
        } else if ("update".equals(action) && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            Participant participant = participantService.getParticipant(id);
            request.setAttribute("participant", participant);
            System.out.println(participant);
            request.getRequestDispatcher("/updateParticipant.jsp").forward(request, response);
        } else if ("delete".equals(action) && request.getParameter("id") != null) {
            int id = Integer.parseInt(request.getParameter("id"));
            participantService.deleteParticipant(id);
            response.sendRedirect("participant?action=list");
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
            int batchId = Integer.parseInt(request.getParameter("batchId"));

            Participant participant = new Participant();
            participant.setName(name);
            participant.setBatchId(batchId);

            participantService.addParticipant(participant);
            response.sendRedirect("participant?action=list");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int batchId = Integer.parseInt(request.getParameter("batchId"));

        Participant participant = new Participant();
        participant.setId(id);
        participant.setName(name);
        participant.setBatchId(batchId);

        System.out.println(participant);
        participantService.updateParticipant(participant);
        response.sendRedirect("participant?action=list");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        participantService.deleteParticipant(id);
        response.sendRedirect("participant?action=list");
    }
}

