package projekt.web;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import projekt.*;

@Controller
@SessionAttributes("zawodnik")
public class FormularzController 
{
	@GetMapping("/formularz")
	public String form(Model model)
	{
		model.addAttribute("zawodnik", new Zawodnik());
		model.addAttribute("przepelnienie",false);
		return "java";
	}
	
	@PostMapping("/formularz")
	public String dodaj(@Valid Zawodnik zawodnik, Errors errors, Model model)
	{
		if(errors.hasErrors())
			return "java";
		
		StringBuilder sb = new StringBuilder();
		DataOperator op = new DataOperator();
		int lata = Period.between(zawodnik.getUrodzenie(),LocalDate.now()).getYears();
		if(lata>21)
			sb.append("SNR_");
		else
			sb.append("U21_");
		if(zawodnik.getWaga()==1)
			sb.append("W");
		else
			sb.append(zawodnik.getWaga());
		sb.append(zawodnik.getPlec());
		zawodnik.setKategoria(Zawodnik.Kategoria.valueOf(sb.toString()));
		System.out.println("S"+zawodnik.getWaga());
		
		if(op.canAdd(zawodnik))
		{
			op.insertData(zawodnik);
			return "redirect:/";
		}
		else
			model.addAttribute("przepelnienie",true);
		return "java";
		
	}
}
