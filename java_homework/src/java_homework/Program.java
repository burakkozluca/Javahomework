/**
*
* @author Burak Kozluca  burak.kozluca@ogr.sakarya.edu.tr
* @since 27/03/2022
* <p>
* �al��t�r�labilir S�n�f
* </p>
*/
package java_homework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Program {
	
	public static void main(String[] args) throws IOException
	{	
		//operat�rlerin tutulaca�� listeler
		ArrayList<String> tekli_operator_sayisi = new ArrayList<String>();
		ArrayList<String> ikili_operator_sayisi = new ArrayList<String>();
		ArrayList<String> sayisal_operator_sayisi = new ArrayList<String>();
		ArrayList<String> iliskisel_operator_sayisi = new ArrayList<String>();
		ArrayList<String> mantiksal_operator_sayisi = new ArrayList<String>();
	
		//Pattern tan�mlamalar�
		Pattern tekli_oper = Pattern.compile("[\\+\\-]{2}");
		Pattern ikili_oper = Pattern.compile("(?:<|>|<=|>=|==|\\!\\=|\\\\|\\&\\&|\\&\\=|\\&|\\^\\=|\\^|\\|\\||\\|\\=|\\||\\+\\=|\\+|\\-\\=|\\-|\\*\\=|\\*|\\%\\=|\\%|\\/\\=|\\/|\\=)"); //
		Pattern sayisal_oper = Pattern.compile("(\\+\\=|\\-\\=|\\!\\=|\\/\\=|\\*\\=|\\&\\=|\\^\\=|\\+\\+|\\+|\\-\\-|\\-|\\*|\\/|\\%|\\&|\\=|\\||\\^)");
		Pattern iliskisel_oper = Pattern.compile("(<=|>=|<|>|==|\\!\\=)");
		Pattern mantiksal_oper = Pattern.compile("([&|]{2})|(!(?=[^=]))");
		
		try 
		{	
			//Dosya okuma
			String fileline= args[0];
			String satir;
			String deneme="";
	    	FileReader fileReader = new FileReader(fileline);
			BufferedReader buffer=new BufferedReader(fileReader);

			//Dosyay� sat�r sat�r okuma d�ng�s�
			while((satir = buffer.readLine()) != null) 
			{	
				//baz� kullan�lmayacak ifadeler yerine bo�luk atanmas�
				String replacingsatir = satir.replaceAll("<\\w+>", "\\s");
				String replacingsatir1 = replacingsatir.replaceAll("==","\\s");
				String replacingsatir2 = replacingsatir1.replaceAll("!=","\\s");
				String replacingsatir3 = replacingsatir2.replaceAll("&&","\\s");
				
				//Matcher tan�mlamalar�, Regexle yakalamak i�in
				Matcher tekli_oper_matcher = tekli_oper.matcher(replacingsatir);
				Matcher ikili_oper_matcher = ikili_oper.matcher(replacingsatir);
				Matcher sayisal_oper_matcher = sayisal_oper.matcher(replacingsatir3);
				Matcher iliskisel_oper_matcher = iliskisel_oper.matcher(replacingsatir);
				Matcher	mantiksal_oper_matcher = mantiksal_oper.matcher(replacingsatir);
				
				//Tekli operat�r bulma
				while(tekli_oper_matcher.find())
				{
					char[] ch1 = new char[satir.length()];
					for (int i = 0; i < satir.length(); i++) 
					{
						ch1[i] = satir.charAt(i);
					}
					String tmp1 = tekli_oper_matcher.group();
					//Yorum sat�rlar�n� kontrol etme
					if((ch1[0] != '/') && (ch1[1] != '/') && (ch1[0] != '*')) 
					{
						if(tmp1.length() != 0)
						{
							tekli_operator_sayisi.add(tmp1);
						}
					}
				}
				
				//�kili operat�r Bulma
				while(ikili_oper_matcher.find()) 
				{
					if(satir.length()>1)
					{
						char[] ch2 = new char[satir.length()];
						for (int i = 0; i < satir.length(); i++) 
						{
							ch2[i] = satir.charAt(i);
						}
						String tmp2 = ikili_oper_matcher.group();
						//Yorum sat�rlar�n� kontrol etme
						if((ch2[0] != '/') && (ch2[1] != '/') && (ch2[0] != '*')) 
						{
							if(tmp2.length() != 0) 
							{
								ikili_operator_sayisi.add(tmp2);
							}
						}
					}
				}
				
				//Say�sal operat�r bulma
				while(sayisal_oper_matcher.find()) 
				{	
					if(satir.length()>1)
					{
						char[] ch3 = new char[satir.length()];
						for (int i = 0; i < satir.length(); i++) 
						{
							ch3[i] = satir.charAt(i);
						}
						String tmp3 = sayisal_oper_matcher.group();
						//Yorum sat�rlar�n� kontrol etme
						if(((ch3[0] != '/') && (ch3[1] != '/')) && ((ch3[0] != '*') && (ch3[1] != '*'))) 
						{
							if(tmp3.length() != 0) 
							{
								sayisal_operator_sayisi.add(tmp3);
							}
						}
					}
				}
				
				//�li�kisel operat�r bulma
				while(iliskisel_oper_matcher.find()) 
				{
					if(satir.length()>1) 
					{
						char[] ch4 = new char[satir.length()];
						for (int i = 0; i < satir.length(); i++) 
						{
							ch4[i] = satir.charAt(i);
						}
						String tmp4 = iliskisel_oper_matcher.group();
						//Yorum sat�rlar�n� kontrol etme
						if((ch4[0] != '/') && (ch4[1] != '/') && (ch4[0] != '*')) 
						{
							if(tmp4.length() != 0) 
							{
								iliskisel_operator_sayisi.add(tmp4);
							}
						}
					}
				}
				
				//Mant�ksal operat�r bulma
				while(mantiksal_oper_matcher.find()) 
				{	
					if(satir.length()>1)
					{
						char[] ch5 = new char[satir.length()];
						for (int i = 0; i < satir.length(); i++) 
						{
							ch5[i] = satir.charAt(i);
						}
						String tmp5 = mantiksal_oper_matcher.group();
						//Yorum sat�rlar�n� kontrol etme
						if((ch5[0] != '/') && (ch5[1] != '/') && (ch5[0] != '*')) 
						{	
							if(tmp5.length() != 0) 
							{
								mantiksal_operator_sayisi.add(tmp5);
							}
						}
					}
				}
				//Bir sonraki sat�ra ge�me
				deneme=deneme+satir;
				deneme=deneme+"\n";	
			}
			//Bulunan de�erlerin ekrana yazd�r�lmas�
			System.out.println("Operat�r Bilgisi:");
			System.out.println("        Tekli Operat�r Say�s�: " + tekli_operator_sayisi.size());
			System.out.println("        �kili Operat�r Say�s�: " + (ikili_operator_sayisi.size()-(tekli_operator_sayisi.size()*2)));
			System.out.println("        Say�sal Operat�r Say�s�: " + sayisal_operator_sayisi.size());
			System.out.println("        �li�kisel Operat�r Say�s�: " + iliskisel_operator_sayisi.size());
			System.out.println("        Mant�ksal Operat�r Say�s�: " + mantiksal_operator_sayisi.size());
			System.out.println("Operand Bilgisi:");
			System.out.println("        Toplam Operand Say�s�: " + (2*(sayisal_operator_sayisi.size() + iliskisel_operator_sayisi.size() + mantiksal_operator_sayisi.size()) - tekli_operator_sayisi.size()));
		
			//Dosyay� kapatma
			buffer.close();
		}
		catch (FileNotFoundException ex) 
		{	
			//Dosya yoksa hata f�rlatma
			System.out.println("Dosya Okunamad�!");
		}
	}
	
}
