package myProject;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.szd.base.service.BaseAreaService;

public class BaseAreaTest extends BaseJunitTest {
	
	private static Logger logger = LoggerFactory.getLogger(BaseAreaTest.class);
	
	@Autowired
	private BaseAreaService baseAreaService;

	@Test
	public void test() {
		//List<BaseArea> list = baseAreaService.findAll();
	}

	@Test
	public void testController() {
		try {
			String responseString = mockMvc
					.perform(post("/login").contentType(MediaType.APPLICATION_JSON_UTF8).param("loginName", "admin").param("inputLogin", "admin").param("inputPwd", "admin"))
					.andExpect(status().isOk()).andDo(print()).andReturn().getResponse().getContentAsString();
			logger.debug("-----返回的json = "+responseString);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
