public class ClassString {
    public static void main (String [] args)
    {
        String ch ;
        System.out.print ("Saire une chaîne > ");
        ch = Clavier.lireString();
        // for (int i = 0 ; i < ch.length() ; i++)
        //     System.out.println (ch.charAt(i));

        String str = "anticonstitutionnellement" ;
        int i = str.indexOf('t');
        int j = str.lastIndexOf('t');
        System.out.println (str.charAt(i) + " : " + i);
        System.out.println (str.charAt(j) + " : " + j);

        final char car = 'e' ;
        // int posCar;
        int nbCar ;
        i = nbCar = 0;
        // do {
        //     posCar = ch.indexOf(car, i) ;
        //     if (posCar >= 0) {
        //         nbCar++ ;
        //         i = posCar + 1 ;
        //     }
        // } while (posCar >= 0);
        for (int k = 0 ; k < ch.length() ; k++)
            if (ch.charAt(k) == car) nbCar++ ;
        System.out.println("votre mot comporte " + nbCar + " fois le caractere " + car);


        String str1 = "Hello";
        String str2 = "hello";

        System.out.println(str1.equals(str2)) ;
        System.out.println(str1.equalsIgnoreCase(str2)) ;

        String str3 = str1.replace('l', 'm') ;
        System.out.println(str3) ;

        String str4 = str.substring(4, 16) ;
        String str5 = str.substring(4) ;
        System.out.println(str4 + " " + str5) ;

        String str6 = str4.toUpperCase() ;
        System.out.println(str6) ;
        String str7 = str6.toLowerCase() ;
        System.out.println(str7) ;

        // int n;
        // while (true)
        // {
        //     System.out.print ("Saire un nombre > ");
        //     n = Clavier.lireInt() ;
        //     if (n == 0)
        //         break ;
        //     String chr = String.valueOf(n) ;
        //     System.out.println("Chaîne correspondante, de longueur : " + chr.length() + " : " + chr);
        // }

        String s = "La java";
        StringBuffer sbuf = new StringBuffer(s) ;
        System.out.println (sbuf);
        sbuf.setCharAt(3, 'J');
        System.out.println (sbuf);
        sbuf.setCharAt(1, 'e');
        System.out.println (sbuf);
        sbuf.append(" 2");
        System.out.println (sbuf);
        sbuf.insert(3, "langage ");
        System.out.println (sbuf);
    }
}
