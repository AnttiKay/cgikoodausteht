package com.koodausTehtävät.tehtävä1;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;

public class Kiinteistö {
    // Kiinteistön omistava henkilö.
    private Henkilö omistaja;
    // kiinteistötunnus, määräalatunnus tai kiinteistölle tai muulle
    // rekisteriyksikölle mahdollisesti annettu muu tunniste.
    private String kiinteistönTunnus;
    // Kiinteistön tai muun rekisteriyksikön nimi.
    private String kiinteistönNimi;
    // Tieto siitä, onko kyse kiinteistöstä vai sen määräalasta.
    private boolean onKiinteistö;
    // kiinteistön tai muun rekisteriyksikön osoitetiedo
    private String osoite;
    private List<Rakennus> rakennuksetKiinteistöllä = new ArrayList<>();

    public Kiinteistö() {
    }

    // Kopiointi konstruktori
    public Kiinteistö(Kiinteistö other) {
        this(other.omistaja, other.kiinteistönTunnus, other.kiinteistönNimi, other.onKiinteistö, other.osoite,
                other.rakennuksetKiinteistöllä);
    }

    public Kiinteistö(Henkilö omistaja, String kiinteistönTunnus, String kiinteistönNimi, boolean onKiinteistö,
            String osoite, List<Rakennus> rakennuksetKiinteistöllä) {
        this.omistaja = omistaja;
        this.kiinteistönTunnus = kiinteistönTunnus;
        this.kiinteistönNimi = kiinteistönNimi;
        this.onKiinteistö = onKiinteistö;
        this.osoite = osoite;
        this.rakennuksetKiinteistöllä = rakennuksetKiinteistöllä;
    }

    public boolean lisääRakennusKiinteistöön(Rakennus rakennus) {
        if (!rakennus.validoitu()) {
            return false;
        }
        if (rakennus.getKiinteistö().equals(this)) {
            if (!rakennuksetKiinteistöllä.contains(rakennus)) {
                rakennuksetKiinteistöllä.add(rakennus);
                return true;
            } else {
                return false;
            }
        } else {
            throw new InvalidParameterException(
                    "Tämä rakennus ei sijaitse tällä kiinteistöllä, et voi lisätä sitä tähän kiinteistöön.");
        }
    }

    public boolean poistaRakennusKiinteistöstä(Rakennus rakennus) {
        if (!rakennus.validoitu()) {
            return false;
        }
        if (rakennus.getKiinteistö().equals(this)) {
            if (rakennuksetKiinteistöllä.contains(rakennus)) {
                rakennuksetKiinteistöllä.remove(rakennus);
                return true;
            } else {
                return false;
            }
        } else {
            throw new InvalidParameterException(
                    "Tällä kiinteistöllä ei ole tätä rakennusta, joten et voi poistaa sitä");
        }
    }

    public boolean validoitu() {
        if (omistaja != null && kiinteistönTunnus != null && kiinteistönNimi != null && osoite != null) {
            return true;

        } else {
            return false;
        }
    }

    public List<Rakennus> getRakennuksetKiinteistöllä() {
        return rakennuksetKiinteistöllä;
    }

    public void setRakennuksetKiinteistöllä(List<Rakennus> rakennuksetKiinteistöllä) {
        this.rakennuksetKiinteistöllä = rakennuksetKiinteistöllä;
    }

    public Henkilö getOmistaja() {
        return omistaja;
    }

    public void setOmistaja(Henkilö omistaja) {
        // Katsotaan, onko kiinteistöllä jo omistaja. Jos on niin asetetaan omistaja
        // tälle kiinteistölle. Jos ei, poistetaan vanhan omistajan listasta tämä
        // kiinteistö ja lisätään se uuden omistajan listaan ja vaihdetaan omistaja
        // uudeksi omistajaksi.

        if(omistaja == null){
            return;
        }
        if (this.omistaja == null) {
            if (omistaja.validoitu()) {
                this.omistaja = omistaja;
                omistaja.lisääOmistettuKiinteistö(this);
            }
        } else {
            if (omistaja.validoitu()) {
                this.omistaja.poistaOmistettuKiinteistö(this);

                this.omistaja = omistaja;
                omistaja.lisääOmistettuKiinteistö(this);
            }
        }

    }

    public String getKiinteistönTunnus() {
        return kiinteistönTunnus;
    }

    public void setKiinteistönTunnus(String kiinteistönTunnus) {
        this.kiinteistönTunnus = kiinteistönTunnus;
    }

    public String getKiinteistönNimi() {
        return kiinteistönNimi;
    }

    public void setKiinteistönNimi(String kiinteistönNimi) {
        this.kiinteistönNimi = kiinteistönNimi;
    }

    public boolean isOnKiinteistö() {
        return onKiinteistö;
    }

    public void setOnKiinteistö(boolean onKiinteistö) {
        this.onKiinteistö = onKiinteistö;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Kiinteistö that = (Kiinteistö) o;
        return omistaja.equals(that.omistaja) && kiinteistönTunnus.equals(that.kiinteistönTunnus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Kiinteistön tiedot: \n");
        sb.append("------------------------------------------------------------------------\n");
        sb.append("Omistajan tiedot: \n");
        sb.append("Omistajan nimi: " + omistaja.getNimi() + "\n");
        sb.append("Omistajan henkilötunnus: " + omistaja.getHenkilötunnus() + "\n");
        sb.append("------------------------------------------------------------------------\n");
        sb.append("Kiinteistön tunnus: " + kiinteistönTunnus + "\n");
        sb.append("Kiinteistön nimi: " + kiinteistönNimi + "\n");
        sb.append("OnKiinteistö: " + onKiinteistö + "\n");
        sb.append("Kiinteistön osoite: " + osoite + "\n");
        sb.append("------------------------------------------------------------------------\n");

        return sb.toString();

    }

}
