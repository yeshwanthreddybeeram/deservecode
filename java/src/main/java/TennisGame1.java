import java.util.HashMap;

public class TennisGame1 implements TennisGame
{
    
    private String player1Name;
    private String player2Name;

    HashMap<String, Integer> playersScore = new HashMap<>();
    // Saperate class for player with names
    
    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
        playersScore.put(player1Name, 0);
        playersScore.put(player2Name, 0);
    }

    public void wonPoint(String playerName)
    {
    	int score = playersScore.get(playerName)+1;
        playersScore.put(playerName, score);
     
    }

    public String getScore()
    {
        String score = "";
        
        int player1Score = playersScore.get(player1Name);
        int player2Score = playersScore.get(player2Name);
        
        if ( player1Score==player2Score)
        {
            score = equalScoresCheck(player1Score);
        }
        else if (player1Score>=4 || player2Score>=4)
        {  
             if(getAdvantagePlayer(player1Name, player2Name) != null)
             {
            	 score = getAdvantagePlayer(player1Name, player2Name);
             }
             else if(getWinPlayer(player1Name, player2Name) != null)
             {
            	 score = getWinPlayer(player1Name, player2Name);
             }

        }
        else
        {
        	score = getScore(player1Name ) +"-"+getScore(player2Name );
        	
        }
        return score;
    }
    
    
	public String getAdvantagePlayer(String player1Name, String player2Name)
	{
		int player1Score = playersScore.get(player1Name);
		int player2Score = playersScore.get(player2Name);
		if (player1Score >= 4 || player2Score >= 4)
		{
			if ((player2Score - player1Score) == 1)
			{
				return "Advantage "+player2Name;
			}
			if ((player1Score - player2Score) == 1)
			{
		     	return "Advantage "+player1Name;
			}
		}
		return null;
	}
	
    public String getWinPlayer(String player1Name, String player2Name)
    {
    	int player1Score = playersScore.get(player1Name);
		int player2Score = playersScore.get(player2Name);
		if (player1Score >= 4 || player2Score >= 4)
		{
			if ((player2Score - player1Score) >= 2)
			{
				return "Win for "+player2Name;
			}
			return "Win for "+player1Name;
		}
		return null;
    }
    
	public String getScore(String playerName)
	{
		int tempScore = 0;
		String score = "";

		tempScore = playersScore.get(playerName);

		switch (tempScore)
		{
		case 0:
			score = "Love";
			break;
		case 1:
			score = "Fifteen";
			break;
		case 2:
			score = "Thirty";
			break;
		case 3:
			score = "Forty";
			break;
		}

		return score;
    }
    

  
    private String equalScoresCheck(int score1) {
        String score;

        {
            switch (score1)
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
        }
        return score;
    }
}
