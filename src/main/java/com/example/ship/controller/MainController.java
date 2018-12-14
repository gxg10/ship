package com.example.ship.controller;

import com.example.ship.exception.ShipException;
import com.example.ship.form.SendMoneyForm;
import com.example.ship.model.ShipInfo;
import com.example.ship.repo.ShipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private ShipDAO shipDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showSHips(Model model) {
        List<ShipInfo> list = shipDAO.listShips();

        model.addAttribute("accountInfos", list);

        return "accountsPage";
    }

    @RequestMapping(value = "/addkm", method = RequestMethod.GET)
    public String viewSendMoneyPage(Model model) {

        SendMoneyForm form = new SendMoneyForm(1L, 700d);

        model.addAttribute("sendMoneyForm", form);

        return "sendMoneyPage";
    }

    @RequestMapping(value = "/addkm", method = RequestMethod.POST)
    public String addKilometri(Model model, SendMoneyForm sendMoneyForm) {
        System.out.println("adding km " + sendMoneyForm.getAmount());

        try {
            shipDAO.addkm(sendMoneyForm.getFromAccountId(),
                    sendMoneyForm.getAmount());
        } catch (ShipException e) {
            model.addAttribute("errorMessage", "Error" + e.getMessage());
        }

        return "redirect:/";
    }
}
