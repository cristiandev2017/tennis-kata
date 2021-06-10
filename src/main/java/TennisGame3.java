
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;

        //Intento 1
        String p [] = {"Love","Fifteen","Thirty","Forty"};
        boolean bol1 = testGame1();
        boolean bol2=testGame2();
        boolean bol3=testGame3();

        if(bol1 && bol2 && bol3){
            s = p[p1];
            return validateOne(s, p);
        }else{
            if (p1 == p2)
                return "Deuce";
            s = p1 > p2 ? p1N : p2N;
            return validateTwo(s);
        }
    }

    private String validateTwo(String s) {
        String testing2 = ((p1-p2)*(p1-p2) == 1) ? "Advantage " + s : "Win for " + s;
        return testing2;
    }

    private String validateOne(String s, String[] p) {
        String testing =(p1 == p2) ? s + "-All" : s + "-" + p[p2];
        return testing;
    }

    boolean testGame1 (){
        return (p1 < 4);
    }

    boolean testGame2(){
        return(p2 < 4);
    }

    boolean testGame3(){
        return (!(p1 + p2 == 6));
    }


    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

}
