package com.ppol.atm.pl.controller;

import com.ppol.atm.service.FinancialService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * @author Pavlo Polishchuk (papolishchuk@luxoft.com)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/atm-servlet-test.xml")
@WebAppConfiguration
public class OperationControllerTest {

	@Autowired
	private FinancialService financialService;

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		Mockito.reset(financialService);

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void testShowBalance() throws Exception {
		final String cardNum = "111";
		final BigDecimal balance = BigDecimal.TEN;
		Mockito.when(this.financialService.getBalance(cardNum)).thenReturn(balance);


		mockMvc.perform(post("/balance").sessionAttr("card_number", cardNum))
				.andExpect(status().isOk())
				.andExpect(view().name("balance"))
				.andExpect(forwardedUrl("/WEB-INF/jsp/balance.jsp"))
				.andExpect(model().attribute("balance", 10.0));
	}
}
