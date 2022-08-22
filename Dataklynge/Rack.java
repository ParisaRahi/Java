
class Rack {

    private Node[] nodeArray ;
    //private final int ANT_NODER_PER_RACK = 12;
  
    public Rack (int antNoderPerRack){
        nodeArray = new Node[antNoderPerRack];
        
    }

    public void leggTilNode(Node node){
        boolean erLedig = false;
        int teller = 0;

        while(teller < nodeArray.length && erLedig == false){
            if (nodeArray[teller] == null){
                nodeArray[teller] = node;
                erLedig = true;
            }
            teller ++;
        }
    }

    public int hentAntNoderPerRack(){
      int teller = 0;
      for(Node n: nodeArray){
        if(n != null){
          teller ++;
        }
      }
      return teller;
    }

    public boolean erLedig(){
      for (Node node : nodeArray){
        if(node == null){
          return true;
        }
      }
      return false;
    }

    public int antallProsessor(){
      int antProsessorer = 0;
      for(Node n: nodeArray){
        if( n!= null){
          antProsessorer += n.hentantallProsessor();
        }       
      }
      return antProsessorer;
    }

    public int noderMedNokMinne(int paakrevdMinne) {
      int antNode = 0;
      for(Node n : nodeArray){
        if( n != null && n.henteminneStorrelse() >= paakrevdMinne ){
          antNode ++;
        }
      }
      return antNode;
    }
}
