package projekt.web;

import java.util.ArrayList;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import projekt.*;

@Controller
public class HomeController 
{
	@GetMapping("/")
	public String home()
	{
		return "index.html";
	}
}
