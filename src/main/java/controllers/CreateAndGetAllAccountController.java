package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Account;
import repository.AccountRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/CreateAndGetAllAccount")
public class CreateAndGetAllAccountController extends HttpServlet {

//    @Override
////    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
////        AccountRepository accountRepository = new AccountRepository();
////        String url = "/success.jsp";
////        req.setAttribute("accounts", accountRepository.getAll());
////    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        AccountRepository accountRepository = new AccountRepository();
        Account acc = new Account();

        acc.setAccount_id(req.getParameter("id"));
        acc.setFull_name(req.getParameter("fullName"));
        acc.setPassword(req.getParameter("password"));
        acc.setEmail(req.getParameter("email"));
        acc.setPhone(req.getParameter("phone"));
        acc.setStatus(Integer.parseInt(req.getParameter("status")));

        accountRepository.create(acc);
    }
}
