package com.example.codefellowship;

import com.example.codefellowship.controllers.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// I WAS HAVING SOME WEIRD BUGS SO I COPIED NICHOLAS'S IMPORT STATEMENTS AND IT STARTED WORKING.
// I MUST HAVE IMPORTED SOMETHING WRONG BUT I COULDN'T FIGURE IT OUT.
@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private UserController userController;

	@Test
	public void shouldHaveHomePage() throws Exception{
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Welcome to Shane's")));
	}
	@Test
	public void shouldHaveLoginPage() throws Exception{
		this.mockMvc.perform(get("/login"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("Username or password was incorrect")));
	}
	@Test
	public void shouldHaveSignUp() throws Exception{
		this.mockMvc.perform(get("/signup"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<form action=\"/signup\" method=\"POST\">\n" +
						"    Register: <br>\n" +
						"    Username: <input type=\"text\" name=\"username\"> <br>\n" +
						"    Password: <input type=\"text\" name=\"password\"> <br>\n" +
						"    First Name: <input type=\"text\" name=\"firstName\"> <br>\n" +
						"    Last Name: <input type=\"text\" name=\"lastName\"> <br>\n" +
						"    Bio: <input type=\"text\" name=\"bio\"> <br>\n" +
						"    <input type=\"submit\">\n" +
						"</form>")));
	}

}
