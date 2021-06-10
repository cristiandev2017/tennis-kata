
public class TennisGame3 implements TennisGame {
    
    private int p2;
    private int p1;
    private String p1N;
    private String p2N;
    private String p [] = {"Love","Fifteen","Thirty","Forty"};

    public TennisGame3(String p1N, String p2N) {
        this.p1N = p1N;
        this.p2N = p2N;
    }

    public String getScore() {
        String s;

        //Intento 1
        boolean bol1 = isLessFourP1();
        boolean bol2= isLessFourP2();
        boolean bol3= isDiferenceSix();

        if(bol1 && bol2 && bol3){
            s = p[p1];
            return messageAll(s);
        }else{
            if (isEqualsNumbers(p1,p2))
                return "Deuce";
            s = isGreaterNumber(p1,p2) ? p1N : p2N;
            return advantageAndWin(s);
        }
    }

    private String advantageAndWin(String s) {
        String resAndWin = (isEqualsNumbers(multiplication(p1-p2,p1-p2),1) ? "Advantage " + s : "Win for " + s;
        return resAndWin;
    }

    private String messageAll(String s) {
        String resAll =( isEqualsNumbers(p1,p2)) ? s + "-All" : s + "-" + p[p2];
        return resAll;
    }

    boolean isLessFourP1(){
        return (islessNumbers(p1,4));
    }
    boolean isLessFourP2(){
        return(islessNumbers(p2,4));
    }
    boolean isDiferenceSix(){
        return (!(isEqualsNumbers(plus(p1,p2),6)));
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.p1 += 1;
        else
            this.p2 += 1;
        
    }

    private int plus(int number1, int number2){return number1+number2;}

    private int multiplication(int number1, int number2){return number1*number2;}

    private boolean isGreaterNumber(int number1, int number2) {
        return number1 >=number2;
    }
    private boolean isEqualsNumbers(int number1, int number2) {
        return number1 ==number2;
    }
    private boolean islessNumbers(int number1, int number2) {
        return number1 < number2;
    }


}
