package projekt.web;

import java.util.ArrayList;
import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
import projekt.*;

@Controller
@SessionAttributes("katmodel")
public class DrabinkaController 
{
	private static Zawodnik.Kategoria kat = Zawodnik.Kategoria.U21_60K;
	private String kat_w = "U21 ";
	private String plec_w = "Kobiety ";
	private String waga_w = "do 60 kg";
	DataOperator op;
	
	@GetMapping("/drabinka")
	public String drabinka(Model model)
	{
		op = new DataOperator();
		TreeMap<Zawodnik.Kategoria, ArrayList<Zawodnik>> mapa =  op.getData();
		model.addAttribute("wyswietlana", kat_w+plec_w+waga_w);
		model.addAttribute("zawodnicy", mapa.get(kat));
		model.addAttribute("katmodel", new KatModel());
		return "drabinka";
	}
	
	@PostMapping("/drabinka")
	public String create(KatModel katmodel, Model model)
	{
		if(katmodel.getKat()==null)
            katmodel = new KatModel("U21_k","60");
        op = new DataOperator();
		StringBuilder sb = new StringBuilder();
		sb.append(katmodel.getKat().substring(0, 4));
		sb.append(katmodel.getWaga());
		sb.append(katmodel.getKat().substring(4).toUpperCase());
		kat = Zawodnik.Kategoria.valueOf(sb.toString());
		TreeMap<Zawodnik.Kategoria, ArrayList<Zawodnik>> mapa =  op.getData();
		
		kat_w = katmodel.getKat().substring(0, 3);
		plec_w = (katmodel.getKat().substring(4, 5).equals("k"))?" Kobiet ":" Mężczyzn ";
		waga_w = (katmodel.getWaga().equals("W"))?"powyżej 80 kg":"do "+katmodel.getWaga()+" kg";
		
		model.addAttribute("zawodnicy", mapa.get(kat));
		model.addAttribute("wyswietlana", kat_w+plec_w+waga_w);
		return "drabinka";
	}
}
