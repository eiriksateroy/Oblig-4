import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class LegesystemAH {

  Lenkeliste<Pasient> pasientListe = new Lenkeliste<>();
  LenkelisteIterator<Pasient> listePas = new LenkelisteIterator<>(pasientListe);

  Lenkeliste<Lege> legeListe = new Lenkeliste<>();
  LenkelisteIterator<Lege> listeLege = new LenkelisteIterator<>(legeListe);

  Lenkeliste<Legemiddel> legemiddelListe = new Lenkeliste<>();
  LenkelisteIterator<Legemiddel> listeLm = new LenkelisteIterator<>(legemiddelListe);

 //metode som returnerer pasient, ut fra pasientID
  public Pasient hentPasient(int pasientID) {
    Pasient aktuellPasient = null;
    Pasient iterPasient = null;
    while (listePas.hasNext()) {
      iterPasient = listePas.next();
      if (iterPasient.hentId() == pasientID) {
        aktuellPasient = iterPasient;
      }
    }
    return aktuellPasient;
  }
//metode som returnerer legemiddel, ut fra legemiddelID
  public Legemiddel hentLegemiddel(int legemiddelID) {
    Legemiddel aktueltLegemiddel = null;
    Legemiddel iterLegemiddel = null;
    while (listeLm.hasNext()) {
      iterLegemiddel = listeLm.next();
      if (iterLegemiddel.hentId() == legemiddelID) {
        aktueltLegemiddel = iterLegemiddel;
      }
    }
    return aktueltLegemiddel;
  }
//metode som returnerer lege, ut fra legenavn
  public Lege hentLege(String legeNavn) {
    Lege aktuellLege = null;
    Lege iterLege = null;
    while (listeLege.hasNext()) {
      iterLege = listeLege.next();
      if (iterLege.hentNavn() == legeNavn) {
        aktuellLege = iterLege;
      }
    }
    return aktuellLege;
  }

// gaar gjennom fil og oppretter nye objekt basert paa egenskaper innad i linja.
//f.eks. kun pasient har foedselsnummer(string med lengde 11).
  public void lesFraFil(String fil) {
    try {
      Scanner scan = new Scanner(new File (fil));
      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        String[] del = line.split(",");
        int teller = 0;
        if (line.startsWith("#")) {
          teller++;
          continue;
        }
        //legg til pasienter
        if (teller == 1) {
          String navnNy = del[0];
          String foedselsnrNy = del[1];
          Pasient pasient = new Pasient(navnNy, foedselsnrNy);
          pasientListe.leggTil(pasient);
        }
        //legg til legemidler
        if (teller == 2) {
          String navnNy = del[0];
          double prisNy = Double.parseDouble(del[2]);
          double virkestoffNy = Double.parseDouble(del[3]);
          int styrke = Integer.parseInt(del[4]);

          if (del[1] == "narkotisk") {
            Narkotisk narkotisk = new Narkotisk(navnNy, prisNy, virkestoffNy, styrke);
            legemiddelListe.leggTil(narkotisk);
          }
          if (del[1] == "vanedannende") {
            Vanedannende vanedannende = new Vanedannende(navnNy, prisNy, virkestoffNy, styrke);
            legemiddelListe.leggTil(vanedannende);
          }
          if (del[1] == "vanlig") {
            Vanlig vanlig = new Vanlig(navnNy, prisNy, virkestoffNy);
            legemiddelListe.leggTil(vanlig);
          }
        }
        //legg til leger
        if (teller == 3) {
          if (del[1] == "0") {
            Lege lege = new Lege(del[0]);
            legeListe.leggTil(lege);
          }
          else {
            Spesialist spesialist = new Spesialist(del[0], Integer.parseInt(del[1]));
            legeListe.leggTil(spesialist);
          }
        }

        //legg til resepter
        if (teller == 4) {
          Legemiddel legemiddelNy = hentLegemiddel(Integer.parseInt(del[0]));
          Pasient pasientNy = hentPasient(Integer.parseInt(del[2]));
          int reitNy = Integer.parseInt(del[3]);
          Lege legeNy = hentLege(del[1]);
          try {
            if (del[3] == "hvit") {
              legeNy.skrivHvitResept(legemiddelNy, pasientNy, reitNy);
            }
            if (del[3] == "blaa") {
              legeNy.skrivBlaaResept(legemiddelNy, pasientNy, reitNy);
            }
            if (del[3] == "militaer") {
              legeNy.skrivMilitaerResept(legemiddelNy, pasientNy, reitNy);
            }
            if (del[3] == "p") {
              legeNy.skrivPResept(legemiddelNy, pasientNy);
            }
          }
          catch (UlovligUtskrift e) {
          }
        }
      }
        scan.close();
      }//slutt try

    catch (FileNotFoundException e) {
      System.out.println(e);
    }

  }//metode slutt

}//klasse slutt
