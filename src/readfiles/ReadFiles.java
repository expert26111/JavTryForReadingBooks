package readfiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yoyo
 */
public class ReadFiles {

    public Map<String, String> getWords() {
        return words;
    }

    public void setWords(Map<String, String> words) {
        this.words = words;
    }

    
    
    Map<String, String> words = new HashMap<String, String>();
    String filesLocation = "C:\\Users\\yoyo\\Desktop\\BooksDB";
    String wholeTitle = "";
    String wholeAuthor = "";

    public void readtTitle(Scanner input) {
        Scanner scan = input;
        //System.out.println("The sacanner shit "+scan.next());
        boolean flag = true;
        while (input.hasNext() ) {
      //  System.out.println("Inside method");

            String title = input.next();
            if (title.toLowerCase().contains("author")) {
                readtAuthor(input);
                flag = false;
              //  System.out.println("Author fired");
            }
            wholeTitle += title + " ";
        }
    }

    public void readtAuthor(Scanner input) {
        boolean flag = false;
         //System.out.println("Inside author");
        while (input.hasNext() && !flag) {

            String author = input.next();
            if (author.toLowerCase().contains("release")) {
                words.put(author, author);
            }

            wholeAuthor += author + " ";

        }
    }

    public void readFiles() {
        File folder = new File(filesLocation);
        File[] listOfFiles = folder.listFiles();
        Scanner input = null;

        for (int i = 0; i < listOfFiles.length; i++) {
            File fileName = listOfFiles[i];
            if (fileName.isFile() && fileName.getName().endsWith(".txt")) {

                try {
                    input = new Scanner(new File(filesLocation + "\\" + fileName.getName()),  "UTF-8");
                    //reading       
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ReadFiles.class.getName()).log(Level.SEVERE, null, ex);
                }
                //reading 
                int countWords = 3000;
                String title = "";
                String author = "";

                while (input.hasNext() && countWords >= 0) {
                    //if a city name

                    countWords--;
                   // Scanner scan = new Scanner(input.next());//there is next line we just tested it
                    //scan.useDelimiter(" ");

                    String word = input.next();
                    //System.out.println("the word is : "+word);
                    if (word.toLowerCase().contains("title")) {
                        //System.out.println("method fired + "+word);
                              String nextWord = "";
                              String nextWord2 = "";
//                        do
//                        {
                         while(!nextWord.toLowerCase().contains("author"))
                         {
                           // System.out.println("scan.hasNext() " + input.hasNext());
                            if(input.hasNext())
                            {
                              nextWord += input.next()+" ";
                                //System.out.println("the word "+nextWord);
                                //System.out.println(" hah" + nextWord);
                            }
                         }
                      ///  }while(!nextWord.toLowerCase().contains("author"));
                        
                      //  do
                      while(!nextWord2.toLowerCase().contains("release"))
                      {
                        
                        if(input.hasNext())
                        {
                            nextWord2 += input.next()+" ";
                           // System.out.println("the word author "+nextWord2);
                        }
                        
                        
                      }
                      
                      String[] arraynext = nextWord.split(" ");
                      String newNextWord = "";
                      if( arraynext[arraynext.length-1].toLowerCase().contains("author"))
                      {
                          //newNextWord =  nextWord.replaceAll("\\w+$","");
                          for (int j = 0; j < arraynext.length-1; j++) 
                          {
                              newNextWord +=arraynext[j]+" ";
                          }
                      }
                      
                      
                        String[] arraynext2 = nextWord2.split(" ");
                      String newNextWord2 = "";
                      if( arraynext2[arraynext2.length-1].toLowerCase().contains("release"))
                      {
                          //newNextWord =  nextWord.replaceAll("\\w+$","");
                          for (int j = 0; j < arraynext2.length-1; j++) 
                          {
                              newNextWord2 +=arraynext2[j]+" ";
                          }
                      }
                      
                      
                        words.put(newNextWord,newNextWord2);
                        
                        
                        
                        System.out.println(" The author is "+newNextWord2);
                       // System.out.println("nextWord now "+ nextWord);
                        System.out.println("The title is now "+ newNextWord);
                      
//                      if()
//                      {
//                          
//                      }
                      
                      
//                      if(nextWord.toLowerCase().contains("author"))
//                      {
//                           int index= nextWord.lastIndexOf(" ");
//                           System.out.println("index is "+index);
//                          nextWord = nextWord.substring(0,nextWord.lastIndexOf(" "));
//                      }
                        //System.out.println("The Title is "+nextWord);
                     //   }while(!nextWord2.toLowerCase().contains("release"));
                        
                    //    System.out.println("title "+nextWord+" author "+nextWord2);
                        
                     // words.put(nextWord, nextWord2);
//                        String wholeTitle = "";
//                        String wholeAuthor = "";
//                      //  while(input.hasNext())
//                       // {
//                            if(input.next().toLowerCase().contains("author"))
//                            {
//                               wholeAuthor+=input.next();
//                            }
//                               title = input.next();
//                               wholeTitle+=title+" ";
////                            String author = words.get(title);
////                            if(author != null  && !author.isEmpty())
////                            {
////                                words.put(title,author);
////                            }
//                     //   }
                     //   System.out.println("title " + word);
                    }

//                      if(word.equalsIgnoreCase("author") )
//                    {
//                        if(input.hasNext())
//                        {
//                             author = input.next();
////                            String title = words.get(author);
////                            if(title != null  && !title.isEmpty())
////                            {
////                                words.put(author,title);
////                            }
//                        }
//                    }
//                       if(author != null  && !author.isEmpty() && title != null  && !title.isEmpty())
//                       {
//                      words.put(title,author);
//                       }
//                   System.out.println("The title is "+title+"  The author is "+author);
                }
             //   input.close();
            }
        }

    }

    public void writeToFile() {
        FileWriter output;
        boolean flag = false;
        try {
            output = new FileWriter(new File("DBWriteFile"));
//            for (int i = 0; i < words.size(); i++) {
//                Student student = students.get(i);
//                output.write(student.toFile() + "\n");
//            }
            if(!flag)
            {
                  output.write("Title "+","+" Author "+"\n");
                  flag = true;
            }
            for (Map.Entry<String, String> wordEntry
                    : words.entrySet()) {
                output.write(wordEntry.getKey()+","+wordEntry.getValue() + "\n");
             
            }
            output.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        //output.close();

    }

    public static void main(String[] args) {
        ReadFiles rd = new ReadFiles();
        rd.readFiles();
        Map<String, String> words = rd.getWords();
        System.out.println("The size is "+words.size());
        
          for (Map.Entry<String, String> wordEntry
          : words.entrySet()) {
        System.out.printf(
          "word '%s' is seen %d times in the text%n",
          wordEntry.getKey(), wordEntry.getValue());
      }  
    }

}
