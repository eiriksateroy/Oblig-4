import java.util.Scanner;
class input {
    public static void main(String[] args) {
        Lenkeliste<Pasient> pasientListe = new Lenkeliste<>();
        Lenkeliste<Lege> legeListe = new Lenkeliste<>();
        Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<>();

        Scanner input = new Scanner(System.in);
        String hovedmeny = "\nHovedmeny: \n0: Skriv ut elementer" //Lag 1
        + "\n1: Legge til nye elementer \n2: Bruk resept \n3: Skriv ut statistikk"
        + "\n4: Skrive alle lagrede data til fil";

        System.out.println(hovedmeny);
        int svar = input.nextInt();

        while (svar >= 0) {
            if (svar == 0) { //Lag2
                System.out.println("\nDette er funksjonen for aa skrive ut alle elementene\n"); //Midlertidig

                System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                svar = input.nextInt();
            }

            else if (svar == 1) { //Lag 2
                System.out.println("\nHva onsker du aa legge til? \n0: Lege \n1: Pasient"
                + "\n2: Resept \n3: Legemiddel");
                int svar2 = input.nextInt();

                if (svar2 == 0) {       //Lag 2.2 - Lege - Ferdig
                    input.nextLine(); //Maa ha med dette for at String input skal leses etter Int input
                    System.out.println("\nNavn paa legen: ");
                    String navn = input.nextLine();
                    System.out.println("\nKontrollnummer (vanlig lege, 0): ");
                    int kontrollnummer =  input.nextInt();

                    if (kontrollnummer == 0) {
                        Lege lege = new Lege(navn);
                        legeListe.leggTil(lege);
                    }

                    else {
                        Lege spesLege = new Spesialister(navn, kontrollnummer);
                        legeListe.leggTil(spesLege);
                    }

                    System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                    svar = input.nextInt();
                }

                else if (svar2 == 1) {  //Lag 2.2 - Pasient - Ferdig
                    input.nextLine();
                    System.out.println("\nNavn paa pasient: ");
                    String navn = input.nextLine();
                    System.out.println("\nFodselsnummer: ");
                    String fodselsnummer = input.nextLine();

                    Pasient pasient = new Pasient(navn, fodselsnummer);
                    pasientListe.leggTil(pasient);

                    System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                    svar = input.nextInt();
                }

                else if (svar2 == 2) {  //Lag 2.2
                    System.out.println("\nHvilken type resept onsker du aa skrive ut? \n0: Hvit resept"
                    + "\n1: P-resept \n2: Militaer resept \n3: Blaa resept");
                    int type = input.nextInt();
                    System.out.println("\nHvilken lege skal skrive ut denne resepten?");
                    //Faar opp en liste av alle legene registrert i systemet
                    int valgtLege = input.nextInt();
                    //Finner valgt lege i lista og,
                    Lege lege = null;
                    System.out.println("\nHvilket legemiddel skal skrives ut?");
                    //Faar opp en liste av alle legemidlene registrert i systemet
                    int valgtLegemiddel = input.nextInt();
                    //Kjorer en if sjekk om legen har lov til aa skrive ut legemidlet
                        //Om ulovlig, starter paa nytt
                    //Om lovlig, fortsetter under
                        //Finner valgt legemiddel i lista og,
                        Legemiddel legemiddel = null;
                    System.out.println("\nHvilken pasient skal resepten registreres til?");
                    //Faar opp en liste av alle registrerte pasienter i systemet
                    int valgtPasient = input.nextInt();
                    //Finner valgt pasient og,
                    Pasient pasient = null;

                    int reit;
                    if (type != 1) {
                        System.out.println("\nHvor mange bruk har denne resepten?");
                        reit = input.nextInt();
                    }
                    else {
                        reit = 3;
                    }
                    if (type == 0) { //Hvit resept
                        //Resept hvit = new HvitResept(legemiddel, lege, pasient, reit);
                        //Og ogsaa legger resepten til i lista
                    }

                    else if (type == 1) { //Pr-resept
                        //Resept pr = new PResept(legemiddel, lege, pasient);
                        //Og ogsaa legger resepten til i lista
                    }
                    else if (type == 2) { //Militaer resept
                        //Resept militaer = new MilitaerResept(legemiddel, lege, pasient, reit);
                        //Og ogsaa legger resepten til i lista
                    }
                    else if (type == 3) { //Blaa resept
                        //Resept blaa = new BlaaResept(legemiddel, lege, pasient, reit);
                        //Og ogsaa legger resepten til i lista
                    }

                    System.out.println("Dette legger til en Resept");//Midlertidig

                    System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                    svar = input.nextInt();
                }

                else if (svar2 == 3) {  //Lag 2.2 - Legemiddel - Ferdig
                    input.nextLine();
                    System.out.println("\nHvilken type legemiddel? \n0: Vanlig"
                    + "\n1: Narkotisk \n2: Vanedannende");
                    int type = input.nextInt();
                    input.nextLine();
                    System.out.println("\nNavn paa legemiddel: ");
                    String navn = input.nextLine();
                    System.out.println("\nPris (double): ");
                    Double pris = input.nextDouble();
                    System.out.println("\nVirkstoffmengde (double): ");
                    Double virkestoffmengde = input.nextDouble();
                    System.out.println("\nStyrke (int). Vanlig legemiddel, 0 ");
                    int styrke = input.nextInt();

                    if (type == 0) {
                        Legemiddel vanlig = new Vanlig(navn, pris, virkestoffmengde);
                        legemiddelListe.leggTil(vanlig);
                    }

                    else if (type == 1) {
                        Legemiddel narkotisk = new Narkotisk(navn, pris, virkestoffmengde, styrke);
                        legemiddelListe.leggTil(narkotisk);
                    }

                    else if (type == 2) {
                        Legemiddel vanedannende = new Vanedannende(navn, pris, virkestoffmengde, styrke);
                        legemiddelListe.leggTil(vanedannende);
                    }

                    System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                    svar = input.nextInt();
                }

                else {                  //Lag 2.2 - Feil input
                    System.out.println("\nFeil input. Begynner paa nytt\n");

                    System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                    svar = input.nextInt();
                }
            }

            else if (svar == 2) { // Lag 2
                System.out.println("\nDette er funksjonen for aa bruke resepter\n");
                //Skriver ut alle reseseptene i systemet

                System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                svar = input.nextInt();
            }

            else if (svar == 3) { //Lag 2
                System.out.println("\nDette er funksjonen for aa skrive ut statistikk\n");

                System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                svar = input.nextInt();
            }

            else if (svar == 4) { //Lag 2
                System.out.println("\nDette er funksjonen for aa skrive ut alle data til fil\n");

                System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                svar = input.nextInt();
            }

            else { //Lag 2
                System.out.println("Feil input. Begynner paa nytt\n");


                System.out.println(hovedmeny); //Bolk for aa loope tilbake til hovedmenyen
                svar = input.nextInt();

            }
        }
    }
}
