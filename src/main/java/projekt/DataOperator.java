package projekt;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.*;

public class DataOperator 
{
	private TreeMap<Zawodnik.Kategoria, ArrayList<Zawodnik>> mapa = new TreeMap<>();
	
	//warto�ci domy�lne
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "";
	private String user = "root";
	private String password = "123";

	public boolean insertData(Zawodnik zaw)
	{
		int result=1;
		try(Connection con = getConnection(); Statement stat = con.createStatement())
		{
			String kat = zaw.getKategoria().toString().substring(0,3);
			result = stat.executeUpdate(String.format("INSERT INTO zawodnicy VALUES (%s,'%s','%s','%s','%s',%d,%d,'%s');",
					"null",zaw.getImie(),zaw.getNazwisko(),zaw.getUrodzenie().toString(),zaw.getPlec(),zaw.getWaga(),zaw.getPunkty(),kat));
		} 
		catch (SQLException | IOException e) 
		{
			System.out.println(e.getMessage());
			e.printStackTrace();
			return false;
		}
		
		return (result > 0);
	}
	
	public boolean canAdd(Zawodnik zaw)
	{
		try(Connection con = getConnection(); Statement stat = con.createStatement())
		{	
			int waga_D = 0;
			int waga_G = 0;
			
			if(zaw.getWaga()<=60) waga_G=60;
			else if(zaw.getWaga()<=70) {waga_D = 60; waga_G = 70;}
			else if(zaw.getWaga()<=80) {waga_D = 70; waga_G = 80;}
			else if(zaw.getWaga()>80 || zaw.getWaga()==-1) {waga_D = 80; waga_G = 1000;}
			
			ResultSet rs = stat.executeQuery("SELECT Count(ID) FROM zawodnicy WHERE kategoria='"
					+zaw.getKategoria().toString().substring(0, 3)+"' and plec='"+zaw.getPlec()+"' and waga BETWEEN "
					+waga_D+" AND "+waga_G+";");
			rs.next();
			return rs.getInt(1)<16;
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	public TreeMap<Zawodnik.Kategoria, ArrayList<Zawodnik>> getData()
	{
		for(Zawodnik.Kategoria k : Zawodnik.Kategoria.values())
			mapa.put(k, new ArrayList<>());
		
		try(Connection con = getConnection(); Statement stat = con.createStatement())
		{	
			String[] s = {"U21","SNR"};
			String kat = "";
			for(String k : s)
			{
				ResultSet rs = stat.executeQuery("SELECT * FROM zawodnicy WHERE Kategoria='"+k.toString()+"';");
				while(rs.next())
				{
					int waga = rs.getInt("waga");
					if(waga<=60) {waga = 60;}else if(waga<=70) {waga=70;} else if(waga <= 80) {waga = 80;}else {waga = -1;};
					kat = rs.getString("Kategoria")+"_"+((waga==-1)?"W":waga)+rs.getString("Plec");
					Zawodnik z = new Zawodnik(rs.getString("Imie"),rs.getString("Nazwisko"),rs.getString("DataUr"),rs.getString("Plec"),rs.getInt("Waga"),rs.getInt("Punkty"),Zawodnik.Kategoria.valueOf(kat));
					mapa.get(Zawodnik.Kategoria.valueOf(kat)).add(z);
				}
			}
			
			for(Zawodnik.Kategoria k : Zawodnik.Kategoria.values())
			{
				Collections.sort(mapa.get(k),Collections.reverseOrder());
				//korekta(mapa.get(k));
			}
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return mapa;
	}
	
	private void korekta(ArrayList<Zawodnik> lista)
	{
		int rozmiar = lista.size();
		for(int i=rozmiar;i<16;i++)
			lista.add(new Zawodnik());
	}
	
	public Connection getConnection() throws SQLException, IOException
	{
		Properties props = new Properties();
		try(InputStream in = Files.newInputStream(Paths.get("src/main/resources/static/db.properties")))
		{
			props.load(in);
		}
		
		if(props.containsKey("jdbc.user"))
		{
			driver = props.getProperty("jdbc.driver");
			url = props.getProperty("jdbc.engine") +"://"+ props.getProperty("jdbc.host")+":"+props.getProperty("jdbc.port")+"/"+props.getProperty("jdbc.dbname");
			user = props.getProperty("jdbc.user");
			password = props.getProperty("jdbc.password");
		}
		return DriverManager.getConnection(url,user,password);
	}
	
	public static void main(String[] args)
	{
		DataOperator dr = new DataOperator();
		TreeMap<Zawodnik.Kategoria, ArrayList<Zawodnik>> zw = dr.getData();
		for(Zawodnik.Kategoria k : Zawodnik.Kategoria.values())
			System.out.println(k);
		for(Zawodnik al:zw.get(Zawodnik.Kategoria.U21_60K))
			System.out.println(al);//jdbc:mysql://localhost:3306/zawodnicy
		//dr.insertData(new Zawodnik("Ryszard","�ubrzyk","1990-01-01","M",212,0,"SNR"));
	}
}

