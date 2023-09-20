package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Account;
import repository.AccountRepository;

import java.io.IOException;
import java.util.List;

@WebServlet("/update")
public class UpdateAndDeleteController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        String action = req.getParameter("action");
        AccountRepository accountRepository = new AccountRepository();

        if(action.equals("updateAccount")){
            String id = req.getParameter("id");
            Account a = new Account();
            Account acc = accountRepository.findById(id);
            System.out.println(id);
            System.out.println(acc);

            if(!req.getParameter("fullName").equals(""))
                a.setFull_name(req.getParameter("fullName"));
            else
                a.setFull_name(acc.getFull_name());

            if(!req.getParameter("email").equals(""))
                a.setEmail(req.getParameter("email"));
            else
                a.setEmail(acc.getEmail());

            if(!req.getParameter("phone").equals(""))
                a.setPhone(req.getParameter("phone"));
            else
                a.setPhone(acc.getPhone());

            accountRepository.update(a, id);
            loadData(req, res);
        }
        else if(action.equals("delete")){
            String deleteId = req.getParameter("deleteId");
            accountRepository.delete(deleteId);
            loadData(req, res);
        }
    }

    public void loadData(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        AccountRepository accountRepository = new AccountRepository();
        List<Account> accounts = accountRepository.getAll();
        req.setAttribute("accounts", accounts);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("success.jsp");
        requestDispatcher.forward(req, res);
    }
}
