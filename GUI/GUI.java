
//GUI bestemmer om hvordan data skal se ut.

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI {

    private Kontroll kontroll;
    private JFrame vindu;
    private JPanel hovedpanel, konsoll, knappPanel, rutenett;
    private JLabel lengde;
    private int rader ;
    private int kolonner ;
    public JLabel[][] ruter ;
    private JButton opp, ned,venstre, hoyre, slutt;

    public GUI(Kontroll kont, int r, int k){
        kontroll = kont;
        rader = r;
        kolonner = k;
        ruter = new JLabel[rader][kolonner];

        try{
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch(Exception e){
            System.exit(1);
        }

        //sette opp vindu
        vindu = new JFrame("Slangespillet");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //sette opp hovedpanel
        hovedpanel = new JPanel();
        hovedpanel.setLayout(new BorderLayout());
        

        //sette opp konsoll
        konsoll = new JPanel();
        konsoll.setLayout(new BorderLayout());
        hovedpanel.add(konsoll, BorderLayout.NORTH);

        knappPanel = new JPanel();
        knappPanel.setLayout(new BorderLayout());
        konsoll.add(knappPanel, BorderLayout.CENTER);

        //plassere lengde i konsoll
        lengde = new JLabel("Lengde: 1");
        konsoll.add(lengde, BorderLayout.LINE_START);

        //Oppknappen i knappanel
        opp = new JButton("Opp");
        class Opp implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                Rettning rettning = Rettning.OPP;
                kontroll.endreRettning(rettning);
            }
        }
        opp.addActionListener(new Opp());
        knappPanel.add(opp, BorderLayout.NORTH);

        //Nedknappen i knappanel
        ned = new JButton("Ned");
        class Ned implements ActionListener{    
            @Override
            public void actionPerformed(ActionEvent e){
                Rettning rettning = Rettning.NED;
                kontroll.endreRettning(rettning);
            }
        }
        ned.addActionListener(new Ned());
        knappPanel.add(ned, BorderLayout.SOUTH);

        //Høyreknappen 
        hoyre = new JButton("Hoyre");
        class Hoyre implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                Rettning rettning = Rettning.HOYRE;
                kontroll.endreRettning(rettning);
            }
        }
        hoyre.addActionListener(new Hoyre());
        knappPanel.add(hoyre, BorderLayout.EAST);

        //Venstreknappen 
        venstre = new JButton("Venstre");
        class Venstre implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                Rettning rettning = Rettning.VENSTRE;
                kontroll.endreRettning(rettning);
            }
        }
        venstre.addActionListener(new Venstre());
        knappPanel.add(venstre, BorderLayout.WEST);

        slutt = new JButton("Slutt");
        class Slutt implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                kontroll.avslutt();
            }
        }
        slutt.addActionListener(new Slutt());
        konsoll.add(slutt, BorderLayout.LINE_END);

        rutenett = lagRutenett();
        hovedpanel.add(rutenett);

        vindu.add(hovedpanel);
        vindu.pack();
        vindu.setVisible(true);
    }

    public JPanel lagRutenett(){
        JPanel rutenett = new JPanel();
        rutenett.setLayout(new BorderLayout());
        rutenett.setLayout(new GridLayout(rader, kolonner));
        for (int r= 0; r < rader; r++){
            for(int k= 0; k < kolonner; k++){
                JLabel rute = lagRute();
                rutenett.add(rute, BorderLayout.CENTER);
                ruter[r][k] = rute;// oppdatere ruten vår i konstruktøren
            }
        }
        return rutenett;

    }

    public JLabel lagRute(){
        JLabel rute = new JLabel(" ");
        rute.setBackground(Color.WHITE);
        rute.setForeground(Color.RED);
        rute.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        rute.setOpaque(true);// betyr at farge i bakgrunnen ikke er gjennomsiktig.
        rute.setPreferredSize(new Dimension(30,30));
        return rute;
    }

    public void tegnSlange(int posRad, int posKolonne){
        ruter[posRad][posKolonne].setText(" O ");
        ruter[posRad][posKolonne].setForeground(Color.BLACK);
        ruter[posRad][posKolonne].setBackground(Color.GREEN);
        
    }

    public void tegnSkatt(int posRad, int posKolonne){
        ruter[posRad][posKolonne].setText("$");
        ruter[posRad][posKolonne].setForeground(Color.RED);
        ruter[posRad][posKolonne].setBackground(Color.WHITE);
    }

    public void slangeHarBesoktRute(int posRad, int posKolonne){
        ruter[posRad][posKolonne].setText(" ");
        ruter[posRad][posKolonne].setBackground(Color.WHITE);
    }

    public void setLengde(int antallSkattTreff){
        lengde.setText("Lengde: " + antallSkattTreff );
    }

    public void tegnRute(int rad, int kolonne){
        ruter[rad][kolonne].setText(" ");
        ruter[rad][kolonne].setBackground(Color.WHITE);
        ruter[rad][kolonne].setForeground(Color.BLACK);
    }
    
    public void leggTilSlange(int rad, int kolonne){
        ruter[rad][kolonne].setText("+");
        ruter[rad][kolonne].setForeground(Color.BLACK);
        ruter[rad][kolonne].setBackground(Color.GREEN);
    }
    /*public void oppdater(Model model){

        for(Koordinat s: model.skatter){
            int rad = s.hentRad();
            int kolonne = s.hentKolonne();
            ruter[rad][kolonne].setText(" ");
            model.plasserSkattStart(); 
        }
        
        /*for (JLabel[] rad : ruter){
            for(JLabel kolonne: rad){
                kolonne.setBackground(Color.WHITE);
                kolonne.setText(" ");
            } 
        }*/

        /*for(Koordinat s: model.skatter){
            s.plasserSkattStart();//dollartegnet dukker opp derfra.
            // koordinat in modell.skatter()
            //legg til dollartegn i rute
            //rutenett[koordinat rad, koordinat kolonne].setText
        }

        for(Koordinat k: model.slangeLista){
            int rad = k.hentRad();
            int kolonne = k.hentKolonne();
            ruter[rad][kolonne].setBackground(Color.GREEN);
    
        }
        //for Koordinat in slangeliste
            //farg grønn.
    }*/
    
}

