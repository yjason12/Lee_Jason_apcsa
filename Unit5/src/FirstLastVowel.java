//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -


public class FirstLastVowel
{
   public static String go( String a )
	{
	   String start = a.toLowerCase();
	   
	   if (start.startsWith("a") || start.startsWith("e") || start.startsWith("i") || start.startsWith("u") || start.startsWith("o")) {
		   return "yes";
	   }
	   if (start.endsWith("a")||start.endsWith("e") || start.endsWith("i")|| start.endsWith("o")|| start.endsWith("u")) {
		   return "yes";
	   }
	   return "no";
	}
   
}