import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.Arrays;
import javax.swing.JFrame;

public class Homework2

{
    public static int keywordCounter = 0;
    public static char[][] TWODPUZZLE = new char[20][20];
    public static int theLength;

    public static void main(String[] args)
    {
        openPuzzle();
        boolean isDone = false;
        int howManyKeywords = Integer.parseInt(JOptionPane.showInputDialog
                ("Enter how many keywords you would like to search"));

        String[] keywords = new String[howManyKeywords];


        for (int i = 0; i < howManyKeywords; i++) {
            keywords[i] = JOptionPane.showInputDialog("Enter the " + (i + 1) + " keyword");
        }


        for (int k = 0; k<howManyKeywords; k++)
        {
            isDone = false;
            for (int i = 0; i<20; i++)
            {
                for (int j = 0; j<20; j++)
                {
                    if(TWODPUZZLE[i][j] == keywords[k].charAt(0))
                    {
                        theLength = keywords[k].length();
                        keywordCounter = 0;
                        if(keywordSearch(TWODPUZZLE, i, j, keywords[k]))
                        {
                            System.out.println(keywords[k]+ " found, do the truffle shuffle!");
                            isDone = true;
                        }
                        else
                        {

                        }
                    }
                    if(isDone)
                        break;
                }
                if(isDone)
                    break;
            }
        }

    }

    public static void openPuzzle()
        {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(null);

            File puzzleFile = fileChooser.getSelectedFile();
            String theString = "";
            int counter = 0;

            try {
                Scanner fileScanner = new Scanner(puzzleFile);

                while (fileScanner.hasNextLine()) {
                    counter++;
                    theString += fileScanner.nextLine();
                }

            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error opening the file");
            }

            theString = theString.replace(",", "");

            int secondCounter = 0;

            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    TWODPUZZLE[i][j] = theString.charAt(secondCounter);
                    secondCounter++;
                }
            }

        for (int i = 0; i <20; i++)
        {
            for (int j =0; j<20;j++)
            {
                System.out.print(TWODPUZZLE[i][j] + " ");
            }
            System.out.println("");
        }
        }


    public static boolean keywordSearch(char[][] twoDpuzzle, int i, int j, String theKeyword)
    {
        keywordCounter++;
//        if (keywordCounter > 3 ){
//            System.out.println(i + " " + j + " " + twoDpuzzle[i][j]);
//        }
        if ((keywordCounter == theLength))
        {
            if((twoDpuzzle[i][j] == theKeyword.charAt(theKeyword.length()-1)))
            {
                //System.out.println("Base case reached");
                //System.out.println(i + ":" + j +  " " + theKeyword.charAt(keywordCounter));
                return true;
            }
        }

        else
        {
           // System.out.println(i + " " + j + theKeyword.charAt(keywordCounter));

            if (i == 0 && j == 0)
            {

                if(twoDpuzzle[i][j + 1] == theKeyword.charAt(keywordCounter))
                {
                    return keywordSearch(twoDpuzzle, i, (j + 1), theKeyword);
                }
                else if(twoDpuzzle[i + 1][j + 1] == theKeyword.charAt(keywordCounter))
                {
                    return keywordSearch(twoDpuzzle, (i + 1), (j + 1), theKeyword);
                }
                else if(twoDpuzzle[i + 1][j] == theKeyword.charAt(keywordCounter))
                {
                    return keywordSearch(twoDpuzzle, (i + 1), j, theKeyword);
                }
                else
                {
                    return false;
                }
            }
            //corner1

            else if (i == 0 && j == 19)
            {

                if (twoDpuzzle[i][j - 1] == theKeyword.charAt(keywordCounter))
                {
                    return keywordSearch(twoDpuzzle, i, (j - 1), theKeyword);
                }
                else if (twoDpuzzle[i + 1][j - 1] == theKeyword.charAt(keywordCounter))
                {
                    return keywordSearch(twoDpuzzle, (i + 1), (j - 1), theKeyword);
                }
                else if (twoDpuzzle[i + 1][j] == theKeyword.charAt(keywordCounter))
                {
                    return keywordSearch(twoDpuzzle, (i + 1), j, theKeyword);
                }
                else
                {
                    return false;
                }
            }
            //corner2

            else if (i == 19 && j == 0)
            {

                if (twoDpuzzle[i - 1][j] == theKeyword.charAt(keywordCounter))
                {
                    return keywordSearch(twoDpuzzle, (i - 1), j, theKeyword);
                } else if (twoDpuzzle[i - 1][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), (j + 1), theKeyword);
                } else if (twoDpuzzle[i][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, i, (j + 1), theKeyword);
                } else {
                    return false;
                }
            }
            //corner3

            else if (i == 19 && j == 19) {

                if (twoDpuzzle[i - 1][j - 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), (j - 1), theKeyword);
                } else if (twoDpuzzle[i - 1][j] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), j, theKeyword);
                } else if (twoDpuzzle[i][j-1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, i, (j - 1), theKeyword);
                } else {
                    return false;
                }
            }
            //corner4

            else if (i == 0 && j != 0 && j != 19) {

                if (twoDpuzzle[i][j - 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, i, (j - 1), theKeyword);
                } else if (twoDpuzzle[i][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, i, (j + 1), theKeyword);
                } else if (twoDpuzzle[i + 1][j - 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i + 1), (j - 1), theKeyword);
                } else if (twoDpuzzle[i + 1][j] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i + 1), j, theKeyword);
                } else if (twoDpuzzle[i + 1][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i + 1), (j + 1), theKeyword);
                } else {
                    return false;
                }

            }
            //wall 1

            else if (i == 19 && j != 0 && j != 19) {

                if (twoDpuzzle[i][j - 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, i, (j - 1), theKeyword);
                } else if (twoDpuzzle[i][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, i, (j + 1), theKeyword);
                } else if (twoDpuzzle[i - 1][j - 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), (j - 1), theKeyword);
                } else if (twoDpuzzle[i - 1][j] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), j, theKeyword);
                } else if (twoDpuzzle[i - 1][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), (j + 1), theKeyword);
                } else {
                    return false;
                }
            }
            //wall2

            else if (j == 0 && i != 0 && i != 19) {

                if (twoDpuzzle[i - 1][j] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), j, theKeyword);
                } else if (twoDpuzzle[i + 1][j] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i + 1), j, theKeyword);
                } else if (twoDpuzzle[i - 1][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), (j + 1), theKeyword);
                } else if (twoDpuzzle[i][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, i, (j + 1), theKeyword);
                } else if (twoDpuzzle[i + 1][j + 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i + 1), (j + 1), theKeyword);
                } else {
                    return false;
                }
            }
            //wall3
            else if (j == 19 && i != 0 && i != 19) {

                if (twoDpuzzle[i - 1][j] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), j, theKeyword);
                } else if (twoDpuzzle[i + 1][j] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i + 1), j, theKeyword);
                } else if (twoDpuzzle[i - 1][j - 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i - 1), (j - 1), theKeyword);
                } else if (twoDpuzzle[i][j - 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, i, (j - 1), theKeyword);
                } else if (twoDpuzzle[i + 1][j - 1] == theKeyword.charAt(keywordCounter)) {
                    return keywordSearch(twoDpuzzle, (i + 1), (j - 1), theKeyword);
                } else {
                    return false;
                }
            }
            //wall4

            else //if (i != 0 && i != 19 && j != 0 && j != 10)
            {
                //System.out.println("I'm here!3 + " + twoDpuzzle[i][j] + i + j);
//                if (twoDpuzzle[i][j] == 'a'){
//                    //System.out.println("omid1 "+ twoDpuzzle[i+1][j-1]);
//                    //System.out.println("omid2 "+ twoDpuzzle[i-1][j]);
//                }

                if (twoDpuzzle[i - 1][j] == theKeyword.charAt(keywordCounter))
                {
                    //System.out.println("I'm here!4 + " + twoDpuzzle[i-1][j] + i + j);
                    if (keywordSearch(twoDpuzzle, (i - 1), j, theKeyword));
                        return true;
                }
                 if (twoDpuzzle[i + 1][j] == theKeyword.charAt(keywordCounter))
                {
                    if (keywordSearch(twoDpuzzle, i+1, j, theKeyword))
                    {
                        return true;
                    }

                }
                 if (twoDpuzzle[i - 1][j - 1] == theKeyword.charAt(keywordCounter))
                {
                    if (keywordSearch(twoDpuzzle, i-1, j-1, theKeyword))
                    {
                        return true;
                    }
                }
                 if (twoDpuzzle[i][j - 1] == theKeyword.charAt(keywordCounter))
                {
                    //System.out.println("I'm here!2 + " + twoDpuzzle[i][j-1] + i + j);
                    if (keywordSearch(twoDpuzzle, i, j-1, theKeyword))
                    {
                        return true;
                    }
                }
                 if (twoDpuzzle[i + 1][j - 1] == theKeyword.charAt(keywordCounter))
                {
                    if (keywordSearch(twoDpuzzle, i+1, j-1, theKeyword))
                    {
                        return true;
                    }
                }
                 if (twoDpuzzle[i - 1][j + 1] == theKeyword.charAt(keywordCounter))
                {
                    //System.out.println("I'm here! + " + twoDpuzzle[i][j] + i + j );
                    if (keywordSearch(twoDpuzzle, i-1, j+1, theKeyword))
                    {
                        return true;
                    }
                }
                 if (twoDpuzzle[i][j + 1] == theKeyword.charAt(keywordCounter))
                {
                    if (keywordSearch(twoDpuzzle, i, j+1, theKeyword))
                    {
                        return true;
                    }
                }
                 if (twoDpuzzle[i + 1][j + 1] == theKeyword.charAt(keywordCounter))
                {
                    if (keywordSearch(twoDpuzzle, i+1, j+1, theKeyword))
                    {
                        return true;
                    }
                }
                else
                    {
                     //   System.out.println(theKeyword.charAt(keywordCounter));
                      //  System.out.println("else else reach");
                    return false;
                }

            }

        }
        return false;
    }
}
