class Node {

    private int nodeNr = 0;
    private int antProsessor;
    private int minneStorrelse;
  

    public Node(int prosessor, int minne){
        antProsessor = prosessor;
        minneStorrelse = minne;
        nodeNr ++;
    }

    public int hentantallProsessor(){
      return antProsessor;
    }

    public int henteminneStorrelse(){
      return minneStorrelse;
    }

}
