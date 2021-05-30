package com.koodausTehtävät.tehtävä1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DomainObjectsTest {
    private Henkilö henkilö;
    private Kiinteistö tontti;
    private Rakennus rakennus1;

    @BeforeEach
    public void setUp() {
        henkilö = new Henkilö();
        henkilö.setNimi("Kimi Järvinen");
        henkilö.setHenkilötunnus("tunnus1");
        henkilö.setKotikunta("Uusimaa");
        henkilö.setOsoite("Aataminkatu 2");
        henkilö.setKansalaisuus("Suomalainen");
        henkilö.setÄidinkieli("Suomi");
        henkilö.setSyntymäaika(30, 5, 1990);

        tontti = new Kiinteistö();
        tontti.setKiinteistönNimi("Tontti");
        tontti.setKiinteistönTunnus("kiinteistöTunnus");
        tontti.setOnKiinteistö(true);
        tontti.setOsoite("Borbarinkatu 15");
        tontti.setOmistaja(henkilö);

        rakennus1 = new Rakennus();
        rakennus1.setRakennusTunnus("rakennus1");
        rakennus1.setValmistumispäivä(10, 11, 1800);
        rakennus1.setOsoite("Pihlamäentie 24");
        rakennus1.setKiinteistö(tontti);
        rakennus1.setOmistaja(henkilö);

    }

    @Test
    public void testKiinteistönJaRakennuksenLisäysHenkilölle() {
        assertEquals(1, henkilö.getOmistetutKiinteistöt().size());
        assertEquals(1, henkilö.getOmistetutRakennukset().size());
    }

    @Test
    public void testRakennuksenKopiointi() {
        Rakennus r2 = new Rakennus(rakennus1);
        assertEquals(henkilö.getNimi(), r2.getOmistaja().getNimi());
        assertEquals(rakennus1.getRakennusTunnus(), r2.getRakennusTunnus());

    }
    

    @Test
    public void testKiinteistönKopiointi() {
        Kiinteistö k2 = new Kiinteistö(tontti);
        assertEquals(tontti.getOmistaja(), k2.getOmistaja());
        assertEquals(tontti.getOsoite(), k2.getOsoite());
        assertEquals(tontti.getKiinteistönTunnus(), k2.getKiinteistönTunnus());
    }
    @Test
    public void testHenkilönKopionti(){
        Henkilö h2 = new Henkilö(henkilö);
        assertEquals(henkilö.getNimi(), h2.getNimi());
        assertEquals(henkilö.getHenkilötunnus(), h2.getHenkilötunnus());
    }

    @Test
    public void testVaihdaKiinteistönJaRakennuksenOmistaja() {
        Henkilö h2 = new Henkilö();
        h2.setNimi("Mika Maajärvi");
        h2.setHenkilötunnus("tunnus2");
        h2.setKotikunta("Lappi");
        h2.setOsoite("Lapinkatu 2");
        h2.setKansalaisuus("Suomalainen");
        h2.setÄidinkieli("Suomi");
        h2.setSyntymäaika(30, 5, 1980);
        assertEquals(0, h2.getOmistetutKiinteistöt().size() + h2.getOmistetutRakennukset().size());
        assertEquals(2, henkilö.getOmistetutKiinteistöt().size() + henkilö.getOmistetutRakennukset().size());

        tontti.setOmistaja(h2);
        assertEquals(1, h2.getOmistetutKiinteistöt().size() + h2.getOmistetutRakennukset().size());
        assertEquals(1, henkilö.getOmistetutKiinteistöt().size() + henkilö.getOmistetutRakennukset().size());

        rakennus1.setOmistaja(h2);
        assertEquals(2, h2.getOmistetutKiinteistöt().size() + h2.getOmistetutRakennukset().size());
        assertEquals(0, henkilö.getOmistetutKiinteistöt().size() + henkilö.getOmistetutRakennukset().size());
    }

    @Test
    public void testLisääRakennusKiinteistöön() {
        assertEquals(1, tontti.getRakennuksetKiinteistöllä().size());
        Rakennus r2 = new Rakennus();
        r2.setRakennusTunnus("rakentaaaa2");
        r2.setValmistumispäivä(10, 11, 1500);
        r2.setOsoite("Kalmarinkatu 24");
        r2.setKiinteistö(tontti);
        r2.setOmistaja(henkilö);
        assertEquals(2, tontti.getRakennuksetKiinteistöllä().size());

    }

    @Test
    public void testPoistaRakennusKiinteistöstä() {
        assertEquals(1, tontti.getRakennuksetKiinteistöllä().size());
        tontti.poistaRakennusKiinteistöstä(rakennus1);

        assertEquals(0, tontti.getRakennuksetKiinteistöllä().size());

    }

    @Test
    public void testVaihdaRakennuksenKiinteistö() {
        Kiinteistö tontti2 = new Kiinteistö();
        tontti2.setKiinteistönNimi("Tontti2");
        tontti2.setKiinteistönTunnus("kiinteistöTunnus2323");
        tontti2.setOnKiinteistö(true);
        tontti2.setOsoite("Borbarinkatu 157");
        tontti2.setOmistaja(henkilö);

        assertEquals(1, tontti.getRakennuksetKiinteistöllä().size());

        rakennus1.setKiinteistö(tontti2);
        assertEquals(0, tontti.getRakennuksetKiinteistöllä().size());
        assertEquals(1, tontti2.getRakennuksetKiinteistöllä().size());

    }

    @Test
    public void testHenkilöValidation() {
        assertEquals(true, henkilö.validoitu());
        henkilö.setHenkilötunnus(null);
        assertEquals(false, henkilö.validoitu());
    }

    @Test
    public void testRakennusValidation() {
        rakennus1.setOsoite(null);
        assertEquals(false, rakennus1.validoitu());
        rakennus1.setOsoite("Mattilankatu 15");
        assertEquals(true, rakennus1.validoitu());

    }

    @Test
    public void testKiinteistöValidation() {
        tontti.setOsoite(null);
        assertEquals(false, tontti.validoitu());
        tontti.setOsoite("Mattilankatu 15");
        assertEquals(true, tontti.validoitu());
    }

    @Test
    public void testRakennusToString() {
        System.out.println(rakennus1.toString());
    }

    @Test
    public void testKiinteistöToString() {
        System.out.println(tontti.toString());
    }

    @Test
    public void testHenkilöToString() {
        System.out.println(henkilö.toString());
    }
}
