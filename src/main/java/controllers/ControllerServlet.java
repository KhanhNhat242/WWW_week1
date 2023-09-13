package controllers;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Account;
import repository.AccountRepository;
import services.AccountService;

import java.io.IOException;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {

    @Inject
    private AccountService accountService;

//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        String action = req.getParameter("action");
//
//    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        Account acc = new Account();

        acc.setAccount_id(req.getParameter("id"));
        acc.setFull_name(req.getParameter("fullName"));
        acc.setPassword(req.getParameter("password"));
        acc.setEmail(req.getParameter("email"));
        acc.setPhone(req.getParameter("phone"));
        acc.setStatus(Integer.parseInt(req.getParameter("status")));

        accountService.create(acc);
    }
}
