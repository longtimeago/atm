package com.ppol.atm.pl.controller;

import com.ppol.atm.domain.Operation;
import com.ppol.atm.integration.api.model.Document;
import com.ppol.atm.pl.utils.SessionUtils;
import com.ppol.atm.integration.api.DocumentService;
import com.ppol.atm.service.FinancialService;
import com.ppol.atm.service.BusinessOperationException;
import java.io.IOException;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class OperationController {

    private static final Logger LOG = LoggerFactory.getLogger(OperationController.class);


    @Autowired
    private FinancialService financialService;

    @Autowired
    private DocumentService documentService;

    @RequestMapping(value="/operation", method = RequestMethod.GET)
    public String operation() {
        return "operation";
    }

    @RequestMapping(value="/balance", method = RequestMethod.POST)
    public String balance(
        ModelMap model,
        HttpServletRequest request) throws BusinessOperationException {

        final String cardNumber = SessionUtils.getCardNum(request);

        final BigDecimal balance = this.financialService.getBalance(cardNumber);
        model.addAttribute("balance", balance.doubleValue());

        return "balance";
    }

    @RequestMapping(value="/withdraw", method = RequestMethod.GET)
    public String withdraw() {
        return "withdraw";
    }

    @RequestMapping(value="/withdraw", method = RequestMethod.POST)
    public String withdraw(
        @RequestParam(value="amount", required=true) final String amount,
        ModelMap model,
        HttpServletRequest request) throws BusinessOperationException {

        final String cardNumber = SessionUtils.getCardNum(request);

        final Operation operation = this.financialService.withdraw(cardNumber, BigDecimal.valueOf(Double.valueOf(amount)));
        model.addAttribute("operation", operation);

        return "withdraw_report";
    }

    @RequestMapping(value="/upload", method = RequestMethod.POST)
    public String uploadDoc(@RequestParam("file") MultipartFile file, ModelMap model) throws IOException {
        LOG.info("Uploading file: " + file.getOriginalFilename());
        if (!file.isEmpty()) {
            documentService.process(new Document(file.getOriginalFilename(),
                file.getBytes(), file.getContentType()));

            model.addAttribute("fileName", file.getOriginalFilename());
            return "upload_report";
        }

        return "redirect:logout";
    }
}
