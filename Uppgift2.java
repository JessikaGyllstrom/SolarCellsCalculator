
import java.util.Scanner;


public class Uppgift2 {

      public static void main(String[] args)
      { 
       /*
       * Program som beräknar hur mycket pengar solceller genererar per dag 
       * utefter antal soltimmar
       * 
       * 1: Räkna ut soltimmar
       * 2: Räkna ut vilken produktion som sker
       * 3: Räkna ut förtjänst av försäljning som hela produktionen ger 
       * 4: Presentera resultaten i en utkrift
       * 
       * @author Jessika Gyllström, jesgyl-0
       */
       //skapar konstanter och variabler
         
        final int JUNE = 6;
        final int JULY = 7;
        final double NUMBER_OF_PANNELS = 26;
        final double PANNELS_SIZE = 1.7;
        
        double area = 0;
        int month = 0;
        int day = 0;
        double sunriseHour = 0;
        double sunriseMin = 0;
        double sunriseTime = 0;
        double sunsetHour = 0;
        double sunsetMin = 0;
        double decimalInSunriseMin = 0;
        double decimalInSunsetMin = 0;
        double sunsetTime = 0;
        double totalSuntime = 0;
        double production = 0;
        double value = 0;
       
        //räknar ut ytan av solpaneler
        area = NUMBER_OF_PANNELS * PANNELS_SIZE;
 
        //skapar en scanner
        Scanner input = new Scanner(System.in);
        //anger separatorer
        input.useDelimiter("-|:|\\s+"); 
       
        System.out.println("Skriv dagens datum [mm-dd]" ); 
        month = input.nextInt();
        day = input.nextInt();
        //rensar inmatningsbuffert
        input.nextLine();
       
        //om månad är varken a eller b, skriv ut felmeddelande
        if(month != JUNE && month != JULY) 
        {
           System.out.println("Error!");
        }  
        // om månad är 6 eller 7
        if(month == JUNE || month == JULY) 
        { 
           //skriver ut meddelande till användaren
           System.out.println("Skriv in tidpunkt soluppgång [hh:mm]");
        }
        //sparar input från användaren i variabeln soluppTim
        sunriseHour = input.nextDouble();
        //sparar input från användaren i variabeln soluppMin
        sunriseMin = input.nextDouble();
        //rensar inmatningsbuffert
        input.nextLine();
        
        //flyttar decimal i soluppMin
        decimalInSunriseMin = sunriseMin/100;
        //räknar ut total soluppångstid
        sunriseTime = sunriseHour + decimalInSunriseMin;

        //skriver ut meddelande till användaren
        System.out.println("Skriv in tidpunkt solnedgång [hh:mm]");
        //sparar input från användaren i variabeln solnedTim
        sunsetHour = input.nextDouble();
        //sparar input från användaren i variabeln solnedMin
        sunsetMin = input.nextDouble();
       
        //flyttar decimal i solnedMin
        decimalInSunsetMin = sunsetMin/100;
        //räknar ut total solnedgångstid
        sunsetTime = sunsetHour + decimalInSunsetMin;
       
        //om klockslag för solnedgång är senare än soluppgång
        if(sunsetTime < sunriseTime) 
        {
           System.out.println("Error!");
        }
       
        //räknar ut hur lång soltid från soluppgång till solnedgång
        totalSuntime = sunsetTime - sunriseTime;
        //rensar inmatningsbuffert
        input.nextLine();    
        //räknar ut produktionen
        production = 166 * 0.0002 * area * totalSuntime;
        //räknar ut värdet
        value = 0.9 * production;
        
        
        System.out.println("===========================================");
        System.out.printf("Soltimmar: %.2f%n", totalSuntime);
        System.out.printf("Produktionen %d/%d är:", day, month);
        System.out.printf(" %.2f", production);
        System.out.printf(" kWh till ett värde av: %.2f kr", value);
      }
   }
    
   
   