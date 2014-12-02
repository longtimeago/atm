package com.ppol.atm.pl.controller;


import com.ppol.atm.pl.model.CardInfo;
import com.ppol.atm.service.BusinessOperationException;
import com.ppol.atm.service.FinancialService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/atm-servlet-test.xml")
@WebAppConfiguration
public final class LoginControllerTest {

    @Autowired
    private FinancialService financialService;

    @Autowired
    private LoginController controller;

    @Test(expected = BusinessOperationException.class)
    public void testLoginFailedWithBlankCardNum() throws BusinessOperationException {
        this.controller.login("", new MockHttpServletRequest());
    }

    @Test
    public void testLoginRedirectToPin() throws BusinessOperationException {
        final MockHttpServletRequest request = new MockHttpServletRequest();
        final String cardNum = "111";
        final CardInfo info = new CardInfo(cardNum, false);
        Mockito.when(this.financialService.getCard(cardNum)).thenReturn(info);

        Assert.assertEquals("redirect:pin", this.controller.login(cardNum, request));

    }
}
