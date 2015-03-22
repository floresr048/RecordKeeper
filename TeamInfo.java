import java.util.Set;

class TeamInfo 
{
  int wins;
  int losses;
  String year;
  Set years;

  TeamInfo (int wins, int losses, String year) { //Creates TeamInfo object which
           this.wins = wins;                    // holds 3 parameters: wins,
           this.losses = losses;                // losses and a string with all
           this.year = year;                    // years of game played
  }

  void incrementWins () { //increment wins
           wins++;
  }

  void incrementLosses () { //increment losses
           losses++;
  }

  void addYear (String aYear) { 
      if (!year.contains(aYear)) //Ensures that multiple years are not rewritten
      {
          year = year + " " + aYear;
      }
      
  }

  public String toString() { //Returns the data collected from a TeamInfo object
           String info =  " Wins: " + wins + " Losses: " + losses 
                   + "\n Years: " + year;
           return info;
  }

} // end TeamInfo
