package com.jinpalhawang.jambudvipa.financemiddle;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.nio.charset.Charset;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FinanceMiddleApplication.class)
@WebAppConfiguration
public class FinanceMiddleApplicationTests {

  private MockMvc mockMvc;

  @Autowired
  private WebApplicationContext webApplicationContext;

  @Autowired
  private FinancialAccountRepository financialAccountRepository;

  @Before
  public void setup() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
    this.financialAccountRepository.deleteAll();
    this.financialAccountRepository.save(new FinancialAccount("Internet Expense"));
  }

  @Test
  public void helloWorld() throws Exception {
    mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(new MediaType(MediaType.TEXT_PLAIN.getType(),
            MediaType.TEXT_PLAIN.getSubtype(),
            Charset.forName("utf8"))))
        .andExpect(content().string("Hello Finances!"));
  }

  @Test
  public void applicationsFindByName() throws Exception {
    mockMvc.perform(get("/financialaccounts/search/findByName?name=Internet Expense"))
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaTypes.HAL_JSON));
  }

  @Test
  public void applicationsFindByNameNotFound() throws Exception {
    mockMvc.perform(get("/financialaccounts/search/findByName?name=invalid"))
        .andExpect(status().isNotFound());
  }

}
