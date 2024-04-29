package projekt;

public class KatModel 
{
	private String kat;
	private String waga;
	
	public KatModel(String kat, String waga)
	{
		this.kat = kat;
		this.waga = waga;
	}
	
	public KatModel() {}
	
	public void setKat(String kat)
	{
		this.kat = kat;
	}
	
	public void setWaga(String waga)
	{
		this.waga = waga;
	}
	
	public String getKat()
	{
		return kat;
	}
	
	public String getWaga()
	{
		return waga;
	}
}
