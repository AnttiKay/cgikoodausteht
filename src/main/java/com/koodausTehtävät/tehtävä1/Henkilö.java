package com.koodausTehtävät.tehtävä1;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Henkilö {
    private String nimi;
    private String henkilötunnus;

    private String osoite;
    private String kotikunta;
    private String kansalaisuus;
    private String äidinkieli;
    private Date syntymäaika;
    private Date kuolinaika;
    private List<Rakennus> omistetutRakennukset = new ArrayList<>();
    private List<Kiinteistö> omistetutKiinteistöt = new ArrayList<>();

    public Henkilö() {
    }

    // Kopiointi konstruktori
    public Henkilö(Henkilö other) {
        this(other.nimi, other.henkilötunnus, other.osoite, other.kotikunta, other.kansalaisuus, other.äidinkieli,
                other.syntymäaika, other.kuolinaika, other.omistetutRakennukset, other.omistetutKiinteistöt);
    }

    public Henkilö(String nimi, String henkilötunnus, String osoite, String kotikunta, String kansalaisuus,
            String äidinkieli, Date syntymäaika, Date kuolinaika, List<Rakennus> omistetutRakennukset,
            List<Kiinteistö> omistetutKiinteistöt) {
        this.nimi = nimi;
        this.henkilötunnus = henkilötunnus;
        this.osoite = osoite;
        this.kotikunta = kotikunta;
        this.kansalaisuus = kansalaisuus;
        this.äidinkieli = äidinkieli;
        this.syntymäaika = syntymäaika;
        this.kuolinaika = kuolinaika;
        this.omistetutRakennukset = omistetutRakennukset;
        this.omistetutKiinteistöt = omistetutKiinteistöt;
    }

    public boolean validoitu() {
        if (nimi != null && henkilötunnus != null && kansalaisuus != null && äidinkieli != null
                && syntymäaika != null) {
            return true;

        } else {
            return false;
        }

    }

    public boolean lisääOmistettuRakennus(Rakennus rakennus) {
        if (!rakennus.validoitu()) {
            return false;
        }
        if (nimi.equals(rakennus.getOmistaja().getNimi())
                && henkilötunnus.equals(rakennus.getOmistaja().getHenkilötunnus())) {
            if (!omistetutRakennukset.contains(rakennus)) {
                omistetutRakennukset.add(rakennus);
                return true;
            } else {
                return false;
            }
        } else {
            throw new InvalidParameterException(
                    "Tämä henkilö ei omista tätä rakennusta, et voi lisätä sitä tälle henkilölle.");
        }
    }

    public boolean poistaOmistettuRakennus(Rakennus rakennus) {
        if (!rakennus.validoitu()) {
            return false;
        }
        if (nimi.equals(rakennus.getOmistaja().getNimi())
                && henkilötunnus.equals(rakennus.getOmistaja().getHenkilötunnus())) {
            if (omistetutRakennukset.contains(rakennus)) {
                omistetutRakennukset.remove(rakennus);
                rakennus.setOmistaja(null);
                return true;
            } else {
                return false;
            }
        } else {
            throw new InvalidParameterException(
                    "Tämä henkilö ei omista tätä rakennusta, et voi poistaa sitä tältä henkilöltä.");
        }
    }

    public boolean lisääOmistettuKiinteistö(Kiinteistö kiinteistö) {
        if (!kiinteistö.validoitu()) {
            return false;
        }
        if (nimi.equals(kiinteistö.getOmistaja().getNimi())
                && henkilötunnus.equals(kiinteistö.getOmistaja().getHenkilötunnus())) {
            if (!omistetutKiinteistöt.contains(kiinteistö)) {
                omistetutKiinteistöt.add(kiinteistö);
                return true;
            } else {
                return false;
            }

        } else {
            throw new InvalidParameterException(
                    "Tämä henkilö ei omista tätä kiinteistöä, et voi lisätä sitä tälle henkilölle.");
        }
    }

    public boolean poistaOmistettuKiinteistö(Kiinteistö kiinteistö) {
        if (!kiinteistö.validoitu()) {
            return false;
        }
        if (nimi.equals(kiinteistö.getOmistaja().getNimi())
                && henkilötunnus.equals(kiinteistö.getOmistaja().getHenkilötunnus())) {
            if (omistetutKiinteistöt.contains(kiinteistö)) {
                omistetutKiinteistöt.remove(kiinteistö);
                kiinteistö.setOmistaja(null);
                return true;
            } else {
                return false;
            }
        } else {
            throw new InvalidParameterException(
                    "Tämä henkilö ei omista tätä kiinteistöä, et voi poistaa sitä tältä henkilöltä.");
        }
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getHenkilötunnus() {
        return henkilötunnus;
    }

    public void setHenkilötunnus(String henkilötunnus) {
        this.henkilötunnus = henkilötunnus;
    }

    public String getOsoite() {
        return osoite;
    }

    public void setOsoite(String osoite) {
        this.osoite = osoite;
    }

    public String getKotikunta() {
        return kotikunta;
    }

    public void setKotikunta(String kotikunta) {
        this.kotikunta = kotikunta;
    }

    public String getKansalaisuus() {
        return kansalaisuus;
    }

    public void setKansalaisuus(String kansalaisuus) {
        this.kansalaisuus = kansalaisuus;
    }

    public String getÄidinkieli() {
        return äidinkieli;
    }

    public void setÄidinkieli(String äidinkieli) {
        this.äidinkieli = äidinkieli;
    }

    public Date getSyntymäaika() {
        return syntymäaika;
    }

    public boolean setSyntymäaika(int date, int month, int year) {
        if ((date < 0 && date > 31) || (month < 1 && date > 12)) {
            return false;
        }
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, month - 1);
        c.set(Calendar.DATE, date);
        c.set(Calendar.YEAR, year);

        this.syntymäaika = c.getTime();
        return true;
    }

    public Date getKuolinaika() {
        return kuolinaika;
    }

    public void setKuolinaika(Date kuolinaika) {
        this.kuolinaika = kuolinaika;
    }

    public List<Rakennus> getOmistetutRakennukset() {
        return omistetutRakennukset;
    }

    public void setOmistetutRakennukset(List<Rakennus> omistetutRakennukset) {
        this.omistetutRakennukset = omistetutRakennukset;
    }

    public List<Kiinteistö> getOmistetutKiinteistöt() {
        return omistetutKiinteistöt;
    }

    public void setOmistetutKiinteistöt(List<Kiinteistö> omistetutKiinteistöt) {
        this.omistetutKiinteistöt = omistetutKiinteistöt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Henkilö that = (Henkilö) o;
        return nimi.equals(that.nimi) && henkilötunnus.equals(that.henkilötunnus);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Henkilön nimi: " + nimi + "\n");
        sb.append("Henkilön henkilötunnus: " + henkilötunnus + "\n");
        sb.append("Henkilön osoite: " + osoite + "\n");
        sb.append("Henkilön kotikunta: " + kotikunta + "\n");
        sb.append("Henkilön kansalaisuus: " + kansalaisuus + "\n");
        sb.append("Henkilön äidinkieli: " + äidinkieli + "\n");

        sb.append("Henkilön syntymäaika: " + syntymäaika.toString() + "\n");
        if (kuolinaika != null) {
            sb.append("Henkilön kuolinaika: " + kuolinaika + "\n");
        }
        if (omistetutKiinteistöt.size() > 0) {
            sb.append("Henkilön omistamat kiinteistöt: \n");
            sb.append("------------------------------------------------------------------------\n\n");
            for (Kiinteistö kiinteistö : omistetutKiinteistöt) {
                sb.append(kiinteistö.toString());
            }
        }
        if (omistetutRakennukset.size() > 0) {
            sb.append("Henkilön omistamat rakennukset: \n");
            sb.append("------------------------------------------------------------------------\n\n");
            for (Rakennus rakennus : omistetutRakennukset) {
                sb.append(rakennus.toString());
            }
        }

        return sb.toString();
    }
}
