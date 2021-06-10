
public class TennisGame1 implements TennisGame {
    
    private int m_score1 = 0;
    private int m_score2 = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            m_score1 += 1;
        else
            m_score2 += 1;
    }

    public String getScore() {
        String score = "";
        int tempScore=0;
        if(isEqualsNumbers(m_score1,m_score2))
        {
            score = equalScore(score);
        }
        //m_score1>=4  m_score2>=4
        else if (isGreaterThanNumber(m_score1,4) ||isGreaterThanNumber(m_score2,4))
        {
            score = minScore(score);
        }
        else
        {
            score = temporalScore(score);
        }
        return score;
    }

    private String temporalScore(String score) {
        int tempScore;
        String palabras[]= {"Love","Fifteen","Thirty","Forty"};

        for (int i = 1; i<3; i++)
        {
            if (isEqualsNumbers(i,1)) tempScore = m_score1;
            else { score +="-"; tempScore = m_score2;}
            score += palabras[tempScore];
            /*
            switch(tempScore)
            {
                case 0:
                    score +="Love";
                    break;
                case 1:
                    score +="Fifteen";
                    break;
                case 2:
                    score +="Thirty";
                    break;
                case 3:
                    score +="Forty";
                    break;
            }

             */
        }
        return score;
    }

    private String minScore(String score) {
        int minusResult = m_score1-m_score2;
        
        score = minusResult(minusResult);
        return score;
    }

    private String minusResult(int minusResult) {
        String score;
        if (isEqualsNumbers(minusResult,1)) score ="Advantage player1";
        else if (isEqualsNumbers(minusResult,-1))score ="Advantage player2";
        else if (isGreaterThanNumber(minusResult,2)) score = "Win for player1";
        else score ="Win for player2";
        return score;
    }

    private boolean isGreaterThanNumber(int number1, int number2) {
        return number1 >=number2;
    }

    private boolean isEqualsNumbers(int number1, int number2) {
        return number1 ==number2;
    }


    private String equalScore(String score) {
        String palabras[]= {"Love-All","Fifteen-All","Thirty-All","Deuce"};
        //Con operador ternario
        //score = (m_score1 < 4)? palabras[m_score1] : "Deuce";
        //Con if normal
        if (m_score1 <4){
            score = palabras[m_score1];
        }else{
            score="Deuce";
        }
        /*
        switch (m_score1)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;
            
        }
         */
        return score;
    }
}
