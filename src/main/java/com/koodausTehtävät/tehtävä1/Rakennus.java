package com.koodausTehtävät.tehtävä1;

import java.util.Date;

public class Rakennus {
    // Kiinteistö jolla rakennus sijaitsee.
    private Kiinteistö Kiinteistö;
    private Henkilö omistaja;
    private int rakennusTunnus;

    private int kokonaisHuoneistoAla;
    private int kokonaisAla;
    private String osoite;
    private String koordinaatit;
    private Date valmistumispäivä;
    private String käyttötarkoitus;

    public Rakennus() {
    }

    // Kopiointi konstruktori
    public Rakennus(Rakennus other) {
        this(other.Kiinteistö, other.omistaja, other.rakennusTunnus, other.kokonaisHuoneistoAla, other.kokonaisAla,
                other.osoite, other.koordinaatit, other.valmistumispäivä, other.käyttötarkoitus);
    }

    public Rakennus(Kiinteistö kiinteistö, Henkilö omistaja, int rakennusTunnus, int kokonaisHuoneistoAla,
            int kokonaisAla, String osoite, String koordinaatit, Date valmistumispäivä, String käyttötarkoitus) {
        Kiinteistö = kiinteistö;
        this.omistaja = omistaja;
        this.rakennusTunnus = rakennusTunnus;
        this.kokonaisHuoneistoAla = kokonaisHuoneistoAla;
        this.kokonaisAla = kokonaisAla;
        this.osoite = osoite;
        this.koordinaatit = koordinaatit;
        this.valmistumispäivä = valmistumispäivä;
        this.käyttötarkoitus = käyttötarkoitus;
    }

    public Kiinteistö getKiinteistö() {
        return Kiinteistö;
    }

    public void setKiinteistö(Kiinteistö kiinteistö) {
        Kiinteistö = kiinteistö;
    }

    public Henkilö getOmistaja() {
        return omistaja;
    }

    public void setOmistaja(Henkilö omistaja) {
        this.omistaja = omistaja;
    }

    public int getRakennusTunnus() {
        return rakennusTunnus;
    }

    public void setRakennusTunnus(int rakennusTunnus) {
        this.rakennusTunnus = rakennusTunnus;
    }

    public int getKokonaisHuoneistoAla() {
        return kokonaisHuoneistoAla;
    }

    public void setKokonaisHuoneistoAla(int kokonaisHuoneistoAla) {
        this.kokonaisHuoneistoAla = kokonaisHuoneistoAla;
    }

    public int getKokonaisAla() {
        return kokonaisAla;
    }

    public void setKokonaisAla(int kokonaisAla) {
        this.kokonaisAla = kokonaisAla;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getKoordinaatit() {
        return koordinaatit;
    }

    public void setKoordinaatit(String koordinaatit) {
        this.koordinaatit = koordinaatit;
    }

    public Date getValmistumispäivä() {
        return valmistumispäivä;
    }

    public void setValmistumispäivä(Date valmistumispäivä) {
        this.valmistumispäivä = valmistumispäivä;
    }

    public String getKäyttötarkoitus() {
        return käyttötarkoitus;
    }

    public void setKäyttötarkoitus(String käyttötarkoitus) {
        this.käyttötarkoitus = käyttötarkoitus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Rakennus that = (Rakennus) o;
        return Kiinteistö.equals(that.Kiinteistö) && omistaja.equals(that.omistaja);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Rakennuksen tiedot: \n");
        sb.append("------------------------------------------------------------------------\n");
        sb.append("Omistaja: \n");
        sb.append("Omistajan nimi: " + omistaja.getNimi() + "\n");
        sb.append("Omistajan henkilötunnus: " + omistaja.getHenkilötunnus() + "\n");
        sb.append("------------------------------------------------------------------------\n");
        sb.append("Kiinteistön tiedot: \n");
        sb.append("Kiinteistön nimi: " + Kiinteistö.getKiinteistönNimi() + "\n");
        sb.append("Kiinteistön tunnus: " + Kiinteistö.getKiinteistönTunnus() + "\n");
        sb.append("------------------------------------------------------------------------\n");
        sb.append("Rakennuksen rakennusTunnus: " + rakennusTunnus + "\n");
        sb.append("Rakennuksen kokonaisHuoneistoAla: " + kokonaisHuoneistoAla + " m^2\n");
        sb.append("Rakennuksen kokonaisAla: " + kokonaisAla + " m^2\n");
        sb.append("Rakennuksen osoite: " + osoite + "\n");
        sb.append("Rakennuksen koordinaatit: " + koordinaatit + "\n");
        sb.append("Rakennuksen valmistumispäivä: " + valmistumispäivä.toString() + "\n");
        sb.append("Rakennuksen käyttötarkoitus: " + käyttötarkoitus + "\n");

        return sb.toString();

    }

}
