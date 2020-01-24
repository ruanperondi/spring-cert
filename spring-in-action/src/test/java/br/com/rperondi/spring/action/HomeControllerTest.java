package br.com.rperondi.spring.action;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import br.com.rperondi.spring.action.controller.HomeController;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {HomeController.class})
@WebMvcTest
class HomeControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  void testHomePage() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.get("/")).
    andExpect(MockMvcResultMatchers.status().isOk()).
    andExpect(MockMvcResultMatchers.view().name("home")).
    andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("Welcome to...")));
    
  }

}
