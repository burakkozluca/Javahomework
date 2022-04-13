/**
*
* @author Burak Kozluca  burak.kozluca@ogr.sakarya.edu.tr
* @since 27/03/2022
* <p>
* Operatör Bilgilerinin Tutuluduðu Sýnýf
* </p>
*/
package java_homework;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class Lexical {
	
	public void regex() 
	{
		//operatör bilgilerinin tutacaðý listelerin tanýmlamalarý
		ArrayList<String> tekli_operator_sayisi = new ArrayList<String>();
		ArrayList<String> ikili_operator_sayisi = new ArrayList<String>();
		ArrayList<String> sayisal_operator_sayisi = new ArrayList<String>();
		ArrayList<String> iliskisel_operator_sayisi = new ArrayList<String>();
		ArrayList<String> mantiksal_operator_sayisi = new ArrayList<String>();
	
		//Pattern tanýmlamalarý
		Pattern tekli_oper = Pattern.compile("[\\+\\-]{2}");
		Pattern ikili_oper = Pattern.compile("(?:<|>|<=|>=|==|\\!\\=|\\\\|\\&\\&|\\&\\=|\\&|\\^\\=|\\^|\\|\\||\\|\\=|\\||\\+\\=|\\+|\\-\\=|\\-|\\*\\=|\\*|\\%\\=|\\%|\\/\\=|\\/|\\=)"); //
		Pattern sayisal_oper = Pattern.compile("(\\+\\=|\\-\\=|\\!\\=|\\/\\=|\\*\\=|\\&\\=|\\^\\=|\\+\\+|\\+|\\-\\-|\\-|\\*|\\/|\\%|\\&|\\=|\\||\\^)");
		Pattern iliskisel_oper = Pattern.compile("(<=|>=|<|>|==|\\!\\=)");
		Pattern mantiksal_oper = Pattern.compile("([&|]{2})|(!(?=[^=]))");
	}
}
