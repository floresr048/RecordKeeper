import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class IO //For UI
{
    public IO ()
    {
        
    }
	static double getDouble(String s)
	{
		return Double.parseDouble(getWord(s));
	}

	static int getInt(String s)
	{
		return Integer.parseInt(getWord(s));
	}

	static String getWord(String s)
	{
		return JOptionPane.showInputDialog(s);
	}

	static void display(String msg, String topic, int TYPE)
    {
        JOptionPane.showMessageDialog(null, msg, topic, TYPE);
    }

    public static void display(String title, String text, int row, int col)
	{
		JTextArea s = new JTextArea(text, row, col);
		JScrollPane pane = new JScrollPane(s);
		JOptionPane.showMessageDialog(null, pane, title, 
                        JOptionPane.INFORMATION_MESSAGE);
	}
}
