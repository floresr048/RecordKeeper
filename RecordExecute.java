import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class RecordExecute {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        File f = null;
        String temp;
        String nextLine;
        TreeMap tM = new TreeMap();
        TeamInfo tIW = null;
        TeamInfo tIL = null;
        BufferedReader bf = null;
        String teamWon;
        String teamLoss;
        String year;
        String fullResult = "";

        IO myIO = new IO();
        String menu = "Type in the appropriate number of the action you would "
                + "like to perform\n1. Choose file\n2. Create and populate tree"
                + "\n3. Display output\n4. Exit";
        boolean more = true;

        while (more) {
            int i = myIO.getInt(menu);
            switch (i) {
                case 1://Choose an input file

                    myIO.display("Choose a file with input data", "Choose a file"
                            + " with input data", JOptionPane.INFORMATION_MESSAGE);

                    JFileChooser chooseMe = new JFileChooser(".");
                    int status = chooseMe.showOpenDialog(null);

                    try {
                        if (status != JFileChooser.APPROVE_OPTION) {
                            throw new IOException();
                        }
                        f = chooseMe.getSelectedFile();
                        if (!f.exists()) {
                            throw new FileNotFoundException();
                        }
                    } catch (IOException e) {
                        display(e.toString(), "Approve option was not selected!");
                    }
                    bf = new BufferedReader(new FileReader(f));
                    break;
                case 2: //Adds a TeamInfo object as a value with its team name
                    // as a key, if the tree does not already contain that key.
                    // If the tree contains that key it will increments wins and
                    //losses respectively, according to that line from the input
                    //file.
                    
                    myIO.display("Create tree with chosen input file", "Create "
                            + "tree with chosen input file",
                            JOptionPane.INFORMATION_MESSAGE);

                    while ((temp = bf.readLine()) != null) {
                        nextLine = temp;
                        StringTokenizer nextEle = new StringTokenizer(nextLine);
                        year = nextEle.nextToken(":");
                        teamWon = nextEle.nextToken(":");
                        teamLoss = nextEle.nextToken();
                        
                        if (!tM.containsKey(teamWon)) {
                            tIW = new TeamInfo(0, 0, "");
                            tIW.addYear(year);
                            tM.put(teamWon, tIW);
                        } if (!tM.containsKey(teamLoss)) {
                            tIL = new TeamInfo(0, 0, "");
                            tIL.addYear(year);
                            tM.put(teamLoss, tIL);
                        } if (tM.containsKey(teamWon)) {
                            tIW = (TeamInfo)tM.get(teamWon);
                            tIW.addYear(year);
                            tIW.incrementWins();
                        } if (tM.containsKey(teamLoss)) {
                            tIL = (TeamInfo)tM.get(teamLoss);
                            tIL.addYear(year);
                            tIL.incrementLosses();
                        }
                    }
                    break;

                case 3: //Provides the output in a text box

                    myIO.display("Display data", "Display data",
                            JOptionPane.INFORMATION_MESSAGE);

                    Set set = tM.entrySet();
                    Iterator iterator = set.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry mE = (Map.Entry)iterator.next();
                        System.out.print("Name: " + mE.getKey() + " Wins: " 
                                + "\n" +mE.getValue());
                        fullResult = fullResult + "\nName: " + mE.getKey() 
                                + mE.getValue().toString();
                    }

                    JTextArea newTA = new JTextArea(fullResult, 50, 100);
                    JScrollPane newSP = new JScrollPane(newTA);
                    JOptionPane.showMessageDialog(null, newSP, "Printed tree"
                            + " entries", JOptionPane.INFORMATION_MESSAGE);

                    break;

                case 4: //Exit the UI
                    more = false;
                    break;

                default:
                    break;
            }
        }
    }

    private static void display(String toString, String approve_option_was_not_selected) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
