import java.util.Scanner;

public class apcsatemperature {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String originscale = "X";
    String destinationscale = "X";
    while (!(originscale.equals("F") || originscale.equals("K") || originscale.equals("C"))) {
      System.out.print("\nEnter an origin scale: ");
      originscale = in.nextLine().toUpperCase();
    }
    while (!(destinationscale.equals("F") || destinationscale.equals("K") || destinationscale.equals("C"))) {
      System.out.print("Enter a destination scale: ");
      destinationscale = in.nextLine().toUpperCase();
    }
    System.out.print("Enter a temperature: ");
    double origintemperature = in.nextDouble();
    double destinationtemperature = 0;
    boolean sameScale = false;

    if (originscale.equals("F")) {
      if (destinationscale.equals("F")) {
        sameScale = true;
        destinationtemperature = origintemperature;
      } else if (destinationscale.equals("C")) {
        destinationtemperature = (origintemperature - 32) * (5 / 9);
      } else if (destinationscale.equals("K")) {
        destinationtemperature = ((origintemperature - 32) * (5 / 9)) + 273.15;
      }
    } else if (originscale.equals("C")) {
      if (destinationscale.equals("F")) {
        destinationtemperature = (origintemperature * (9 / 5)) + 32;
      } else if (destinationscale.equals("C")) {
        sameScale = true;
        destinationtemperature = origintemperature;
      } else if (destinationscale.equals("K")) {
        destinationtemperature = origintemperature + 273.15;
      }
    } else if (originscale.equals("K")) {
      if (destinationscale.equals("F")) {
        destinationtemperature = ((origintemperature - 273.15) * (9 / 5)) + 32;
      } else if (destinationscale.equals("C")) {
        destinationtemperature = origintemperature - 273.15;
      } else if (destinationscale.equals("K")) {
        sameScale = true;
        destinationtemperature = origintemperature;
      }
    }

    System.out.printf("\n%,.1f", origintemperature);
    System.out.printf("°" + originscale + " equals " + " ");
    System.out.printf("%,.1f", destinationtemperature);
    System.out.printf("°" + destinationscale + ".");



    in.close();
  }
}
