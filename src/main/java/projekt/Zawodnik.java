package projekt;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;



public class Zawodnik implements Comparable<Object>
{
	public enum Kategoria{U21_60K, U21_70K, U21_80K, U21_WK, SNR_60K, SNR_70K, SNR_80K, SNR_WK, U21_60M, U21_70M, U21_80M, U21_WM, SNR_60M, SNR_70M, SNR_80M, SNR_WM};
	
	@NotBlank(message="Imie nie może być puste")
	private String imie;
	@NotBlank(message="Nazwisko nie może być puste")
	private String nazwisko;
	@NotNull(message="Proszę podać datę urodzenia")
	@Past(message="Data nie może być z przyszłości")
	private LocalDate urodzenie;
	@NotBlank(message="Płeć jest obowiązkowa")
	private String plec;
	@Min(value = 0, message="Proszę zaznaczyć kategorię wagową")
	private int waga;
	private int punkty;
	private Kategoria kat;
	
	public Zawodnik()
	{
		imie = "";
		nazwisko = "";
		waga = 0;
		punkty = 0;
		plec = "";
		urodzenie = null;
		kat = null;
	}
	
	public Zawodnik(String imie, String nazwisko, String data, String plec, int waga, int punkty, Kategoria kat)
	{
		this.imie = imie;
		this.nazwisko = nazwisko;
		this.urodzenie = LocalDate.parse(data, DateTimeFormatter.ISO_LOCAL_DATE);
		this.plec = plec;
		this.waga = waga;
		this.punkty = punkty;
		this.kat = kat;
	}
	
	public Zawodnik(String imie, String nazwisko, String data, String plec, int waga, int punkty, String kat)
	{
		this(imie,nazwisko,data,plec,waga,punkty,Kategoria.valueOf(kat));
	}
	
	public String toString()
	{
		return imie+" "+nazwisko+" "+urodzenie+" pkt: "+punkty+" "+waga;
	}
	
	public int compareTo(Object o)
	{
		if(this == o) return 0;
		if(o == null) return -1;
		if(!(o instanceof Zawodnik)) return 1;
		Zawodnik zw = (Zawodnik) o;
		return this.punkty-zw.punkty;
	}
	
	public String getImie()
	{
		return imie;
	}
	
	public String getNazwisko()
	{
		return nazwisko;
	}
	
	public String getPlec()
	{
		return plec;
	}
	
	public LocalDate getUrodzenie()
	{
		return urodzenie;
	}
	
	public int getWiek()
	{
		return (int) LocalDate.now().until(urodzenie, ChronoUnit.YEARS);
	}
	
	public int getWaga()
	{
		return waga;
	}
	
	public int getPunkty()
	{
		return punkty;
	}
	
	public Kategoria getKategoria()
	{
		return kat;
	}

	public void setImie(String imie)
	{
		this.imie = imie;
	}
	
	public void setNazwisko(String nazwisko)
	{
		this.nazwisko = nazwisko;
	}
	
	public void setUrodzenie(LocalDate ld)
	{
		this.urodzenie = ld;
	}
	
	public void setUrodzenie(String ld)
	{
		this.urodzenie = LocalDate.parse(ld, DateTimeFormatter.ISO_LOCAL_DATE);
	}
	
	public void setPlec(String plec)
	{
		this.plec = plec;
	}
	
	public void setWaga(int waga)
	{
		this.waga = waga;
	}
	
	public void setPunkty(int punkty)
	{
		this.punkty = punkty;
	}
	
	public void setKategoria(Kategoria kat)
	{
		this.kat = kat;
	}
}
