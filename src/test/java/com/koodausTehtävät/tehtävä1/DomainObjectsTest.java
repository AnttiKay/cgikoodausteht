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
        tontti.setOmistaja(henkilö);
        tontti.setKiinteistönNimi("Tontti");
        tontti.setKiinteistönTunnus("kiinteistöTunnus");
        tontti.setOnKiinteistö(true);
        tontti.setOsoite("Borbarinkatu 15");

        rakennus1 = new Rakennus();
        rakennus1.setKiinteistö(tontti);
        rakennus1.setOmistaja(henkilö);
        rakennus1.setRakennusTunnus("rakennus1");
        rakennus1.setValmistumispäivä(10, 11, 1800);

    }

    @Test
    public void testKiinteistönJaRakennuksenLisäys() {
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
    public void testKiinteistönKopiointi(){
        Kiinteistö k2 = new Kiinteistö(tontti);
        assertEquals(tontti.getOmistaja(), k2.getOmistaja());
    }

}
