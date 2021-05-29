package com.koodausTehtävät.tehtävä1;

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

    public Kiinteistö() {
    }

    // Kopiointi konstruktori
    public Kiinteistö(Kiinteistö other) {
        this(other.omistaja, other.kiinteistönTunnus, other.kiinteistönNimi, other.onKiinteistö, other.osoite);
    }

    public Kiinteistö(Henkilö omistaja, String kiinteistönTunnus, String kiinteistönNimi, boolean onKiinteistö,
            String osoite) {
        this.omistaja = omistaja;
        this.kiinteistönTunnus = kiinteistönTunnus;
        this.kiinteistönNimi = kiinteistönNimi;
        this.onKiinteistö = onKiinteistö;
        this.osoite = osoite;
    }

    public Henkilö getOmistaja() {
        return omistaja;
    }

    public void setOmistaja(Henkilö omistaja) {
        this.omistaja = omistaja;
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
        sb.append("Omistaja: \n");
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
