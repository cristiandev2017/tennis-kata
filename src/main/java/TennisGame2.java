
public class TennisGame2 implements TennisGame
{
    //Se puede refactorizar con una clase para acortar variables
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;
    private String palabras[] = {"Fifteen","Thirty","Forty"};
    private String score = "";

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        if (isEqualsNumbers(P1point,P2point)  &&  isLessNumber(P1point, 4))
        {
            score = validateEqualsScore(score);
        }
        if (isEqualsNumbers(P1point,P2point) && isGreaterThanNumber(P1point,3))
            score = "Deuce";

        if (isGreaterNumber(P1point,0) && isEqualsNumbers(P2point,0))
        {
            P1res = validatePoints(P1point);
            /*
            if (P1point==1)
                P1res = "Fifteen";
            if (P1point==2)
                P1res = "Thirty";
            if (P1point==3)
                P1res = "Forty";
            */
            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        if ( isGreaterNumber(P2point,0) && isEqualsNumbers(P1point,0))
        {
            P2res = validatePoints(P2point);
            /*
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";
            */
            P1res = "Love";
            score = P1res + "-" + P2res;
        }

        if (isGreaterNumber(P1point,P2point) && isLessNumber(P1point,4))
        {
            validatePointsFour();

        }
        if (isGreaterNumber(P2point,P1point)&& isLessNumber(P2point,4))
        {
            validatePointsFourP2();
        }

        if (isGreaterNumber(P1point,P2point)  && isGreaterThanNumber(P2point,3) )
        {
            score = "Advantage player1";
        }

        if (isGreaterNumber(P2point,P1point) && isGreaterThanNumber(P1point,3))
        {
            score = "Advantage player2";
        }

        if (isGreaterThanNumber(P1point,4) && isGreaterThanNumber(P2point,0) && isGreaterThanNumber (P1point-P2point,2))
        {
            score = "Win for player1";
        }
        if (isGreaterThanNumber(P2point,4) && isGreaterThanNumber(P1point,0)  && isGreaterThanNumber(P2point-P1point,2))
        {
            score = "Win for player2";
        }
        return score;
    }

    private void validatePointsFourP2() {
        if (isEqualsNumbers(P2point,2))
            P2res="Thirty";
        if (isEqualsNumbers(P2point,3))
            P2res="Forty";
        if (isEqualsNumbers(P1point,1))
            P1res="Fifteen";
        if (isEqualsNumbers(P1point,2))
            P1res="Thirty";
        score = P1res + "-" + P2res;
    }

    private void validatePointsFour() {
        if (isEqualsNumbers(P1point,2))
            P1res="Thirty";
        if (isEqualsNumbers(P1point,3))
            P1res="Forty";
        if (isEqualsNumbers(P2point,1))
            P2res="Fifteen";
        if (isEqualsNumbers(P2point,2))
            P2res="Thirty";
        score = P1res + "-" + P2res;
    }

    private String validatePoints(int number) {
        if(isGreaterThanNumber(number,0) && isLessNumber(number,4)){
            //P1res= palabras[number-1];
            return palabras[number-1];
        }
        return "";
    }

    private String validateEqualsScore(String score) {
        if (isEqualsNumbers(P1point,0))
            score = "Love";
        if (isEqualsNumbers(P1point,1))
            score = "Fifteen";
        if (isEqualsNumbers(P1point,2))
            score = "Thirty";
        score += "-All";
        return score;
    }

    private boolean isGreaterThanNumber(int number1, int number2) {
        return number1 >=number2;
    }

    private boolean isGreaterNumber(int number1, int number2) {
        return number1 >number2;
    }

    private boolean isLessNumber(int number1, int number2) {
        return number1 <number2;
    }

    private boolean isEqualsNumbers(int number1, int number2) {
        return number1 ==number2;
    }

    //Reutilizar una sola función enviar el P1point como parametro
    public int incrementValue(int value ){
        return  value+1;
    }

    /*
    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }
     */

    public void wonPoint(String player) {
        if (player == "player1")
            //P1Score();
            P1point = incrementValue(P1point);
        else
            P2point = incrementValue(P2point);
            //P2Score();
    }
}