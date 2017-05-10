package readfiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author yoyo
 */
public class ReadFiles {

//    public Map<String, String> getWords() {
//        return words;
//    }
//    public void setWords(Map<String, String> words) {
//        this.words = words;
//    }
    List<Book> words = new ArrayList<>();
    List<City> citiesBook = new ArrayList<>();
    Map<String,City> cities = new HashMap<>();
    int count = 0;

    //Map<String, String> words = new HashMap<String, String>();
    String filesLocation = "C:\\Users\\yoyo\\Desktop\\BooksDB";
    String wholeTitle = "";
    String wholeAuthor = "";

    public void readtTitle(Scanner input) {
        Scanner scan = input;
        //System.out.println("The sacanner shit "+scan.next());
        boolean flag = true;
        while (input.hasNext()) {
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

                //words.add(author, author);
            }

            wholeAuthor += author + " ";

        }
    }
    
    
     public void CityScanner() throws FileNotFoundException, IOException 
     {
         BufferedReader br = null;
        FileReader fr = null;
        //C:\Users\yoyo\Desktop\BooksDB
        fr = new FileReader("C:/Users/yoyo/Desktop/CitiesDB/simplemaps-worldcities-basic.csv");
        br = new BufferedReader(fr);
          List<City> cityList = new ArrayList<>();

        String sCurrentLine;

        while ((sCurrentLine = br.readLine()) != null) 
        {
            String[] line = sCurrentLine.split(",");
            //String[] alternateNames = line[3].split(",");
           // cityList.add(new City(line[0], line[1], line[2], alternateNames, line[4], line[5], line[14]));
           City city = new City();
           city.setName(line[0]);
           // System.out.println("The number is "+line[2]);        
           city.setLat(line[2]);
           city.setLongt(line[3]);
           cities.put(city.getName(),city);
        }
//         System.out.println("the size of the set is "+cities.size());
//       Iterator iterator = cities.iterator(); 
//      
//   // check values
//   while (iterator.hasNext())
//   {
//         System.out.println("Value: "+iterator.next().toString() + " ");
//       // return cityList;
//        
//    }
     }
    
//    public void allCities() throws FileNotFoundException, IOException
//    {
//              BufferedReader br = null;
//        FileReader fr = null;
//        //C:\Users\yoyo\Desktop\BooksDB
//        fr = new FileReader("C:/Users/yoyo/Documents/NetBeansProjects/ReadFiles/cities15000.txt");
//        br = new BufferedReader(fr);
//          List<City> cityList = new ArrayList<>();
//
//        String sCurrentLine;
//
//       /* while (*/sCurrentLine = br.readLine();/* != null)*/ 
//        {
//            String[] line = sCurrentLine.split(",");
//            for(int i = 0; i<line.length;i++)
//            {
//                System.out.print(line[i]+ "  ");
//            }
//            //String[] alternateNames = line[3].split(",");
//           // cityList.add(new City(line[0], line[1], line[2], alternateNames, line[4], line[5], line[14]));
////           City city = new City();
////           city.setName(line[1]);
////           // System.out.println("The number is "+line[2]);        
////           city.setLat(line[4]);
////           city.setLongt(line[5]);
////           cities.add(city);
//        }
////               Iterator iterator = cities.iterator(); 
////      
////   // check values
////   while (iterator.hasNext())
////   {
////         System.out.println("Value: "+iterator.next().toString() + " ");
////       // return cityList;
////        
////    }
//    }
    
    public void readFiles() {
        File folder = new File(filesLocation);
        File[] listOfFiles = folder.listFiles();
        Scanner input = null;
                    boolean flagDoneIntro =true ;
                    String nextWord = "";
                    String nextWord2 = "";
                    int countWords = 0;
                    Map<String,City> citiesforBook = null;
                    //        Book book = null;// we met the end of book introduction we can create a book object

        for (int i = 0; i < listOfFiles.length; i++) {
            File fileName = listOfFiles[i];
            if (fileName.isFile() && fileName.getName().endsWith(".txt")) {
                     System.out.println("the name of the file  " + fileName.getName());
                try {
                    input = new Scanner(new File(filesLocation + "\\" + fileName.getName()), "UTF-8");
                    System.out.println("I am in try block ");
                    flagDoneIntro = true;
                    nextWord="";
                    nextWord2 = "";
                    countWords = 150;
                    citiesforBook = new HashMap<>();
                    Book book = new Book();
                    book.setCities(citiesforBook);
                    words.add(book);                   
                    System.out.println("THE SIZE OF WORDS IS "+words.size());
                  //  book = new Book();
                    //reading       
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ReadFiles.class.getName()).log(Level.SEVERE, null, ex);
                }
                //reading 
//                String title = "";
//                String author = "";
                  //System.out.println("First word  "+input.next());
                while (input.hasNext() /*&& countWords>=0/*&& input.next().toLowerCase().contains("***")*/) {

                    String word = input.next();
                    //  System.out.println("The word is  "+word);
                      if(cities.get(word) != null)
                      {
                          City city = cities.get(word);
                        ///  citiesforBook.put(word, city);
                           words.get(words.size() - 1).getCities().put(word, city);
                      }
                    //if it is a city do this 
                    
                    //try in another method catch title and author
                    
                   // System.out.println(word);
                   
                    if (flagDoneIntro /*&& countWords>=0*/)//the end of beggining part  //moje while da sloja
                    {
                       // System.out.println("I am inside flag ");
                         countWords--; // maybe move only for reading title and author
                     //    System.out.println("The count is "+countWords);
                        
                         //System.out.println("the countWords is "+countWords);
                        //System.out.println("The value of flagDoneIntro "+flagDoneIntro);
                        if (word.equals("***") || countWords==0) {
                           Book book = new Book();
                        //    Sysem.out.println("Size of countWords is "+countWords);
                           // System.out.println(" I am in");
                            if (nextWord.isEmpty()) 
                            {
                               //System.out.println("A book without a title " + count);
                                nextWord = "No Existing Title " + count;
                                count++;
                                //book.setTitle(nextWord);
                                 words.get(words.size() - 1).setTitle(nextWord);
                            }else
                            {
                                 // if(!nextWord.isEmpty())
                               // {
                                  // System.out.println("Title is "+nextWord);
                                   String title = createString(nextWord,"author");
                                 //  book.setTitle(title);
                                 words.get(words.size() - 1).setTitle(title);
                              
                                //}
                            }
                            if (nextWord2.isEmpty()) 
                            {
                               // System.out.println("A book without an author ");
                                nextWord2 = "No Existing Author ";
                                words.get(words.size() - 1).setAuthor(nextWord2);
                                //book.setAuthor(nextWord2);
                            }else
                            {
                              //  System.out.println("Author is "+nextWord2);
                                String author = createString(nextWord2,"release");
                                words.get(words.size() - 1).setAuthor(author);
                               // book.setAuthor(author);
                            }
                           // words.add(book);
                           // words.get(words.size() - 1).setCities(citiesBook);
                            flagDoneIntro = false;
                           // System.out.print(flagDoneIntro+ " "+countWords);
                            
                        } else {
                            if (word.toLowerCase().contains("title")) {

//                      
                                while (!nextWord.toLowerCase().contains("author")) {

                                    if (input.hasNext()) {
                                        nextWord += input.next() + " ";
                                      //  System.out.println(" title| "+nextWord);

                                    }
                                }

                                while (!nextWord2.toLowerCase().contains("release")) {

                                    if (input.hasNext()) {
                                        nextWord2 += input.next() + " ";
                                       //  System.out.println(" author| "+nextWord2); 
                                    }

                                }
                            }

                        }

                    }
                             
//                           Book book = new Book();
//                           if(!nextWord.isEmpty())
//                           {
//                              String title = createString(nextWord,"title");
//                              book.setTitle(title);
//                              
//                           }
//                             if(!nextWord2.isEmpty())
//                           {
//                              String author = createString(nextWord,"author");
//                              book.setAuthor(author);
//                              
//                           }
//                         if(book.getTitle() != null && book.getAuthor() != null)
//                         {
//                            words.add(book);
//                         }
                     

                }
                       //words.get(words.size() - 1).setCities(citiesBook);
//                   Book book = new Book();
//                   book.setTitle();
                  // if(  words.get(words.size() - 1) == null &&  words.get(words.size() - 1).getCities().isEmpty())
                  /// {
                       
                 //  }
                 //  book.setCities(citiesBook);
                 
                  // words.add(book);
                   //System.out.println(words.get(0).getCities());
                  // list = words.get(0).getCities();
                  
                      //System.out.println(" The size is  "+list.size());
                       
              //     input.close();
                //ej tula moje da zatvorq i da si napravq knigata

            }

//        for(int i =  0; i<words.size();i++)
             
//        {
//            System.out.println("The books name is| "+words.get(i).title);
//            System.out.println("The books author is| "+words.get(i).author);
//        }
        }
        
              //System.out.println(" The size is of words "+words.size());
                   for(int p = 0; p<words.size(); p++)
                   {
                     //System.out.print("  The index is "+p);
                       System.out.print("The book name is \""+words.get(p).title+"\"");
//                     List<City> list = new ArrayList<>();
//                     for(City city : words.get(p).getCities())
//                      {
//                       System.out.print(city.getName()+",");
//                      }
                        for (Map.Entry<String, City> entry : words.get(p).getCities().entrySet())
                      {
                           System.out.print(entry.getKey() + "," + entry.getValue().getLat()+","+entry.getValue().getLongt());
                      }
                       
                   }
//        System.out.println("the size of words is " + words.size());
//        for (int j = 0; j < words.size(); j++) {
//            System.out.println("The book title is| " + words.get(j).title);
//            System.out.println("The book author is| " + words.get(j).author);
//        }
//
       }
        

    public String createString(String wordLong, String keyWord) {
        String[] arraynext2 = wordLong.split(" ");
      //  System.out.println("The size of arraynext2 "+arraynext2.length);
      //  System.out.println("The contained words are "+keyWord);
        
        
        String newNextWord2 = "";
        if (arraynext2[arraynext2.length - 1].toLowerCase().contains(keyWord)) {

            for (int j = 0; j < arraynext2.length - 1; j++) {
                newNextWord2 += arraynext2[j] + " ";
               // System.out.println("The newNextWord2 is "+newNextWord2);
            }
        }
      //  System.out.println("The returned word from createString "+newNextWord2);
        return newNextWord2;

    }
    public static void main(String[] args) throws IOException {
        ReadFiles rd = new ReadFiles();
        rd.CityScanner();
        rd.readFiles();
        rd.writeToFile();
//        Map<String, String> words = rd.getWords();
//        System.out.println("The size is "+words.size());
//        
//          for (Map.Entry<String, String> wordEntry
//          : words.entrySet()) {
//        System.out.printf(
//          "word '%s' is seen %d times in the text%n",
//          wordEntry.getKey(), wordEntry.getValue());
    }
  //  }


    public void writeToFile() {
        FileWriter output;
        FileWriter output2;
        FileWriter output3;
        FileWriter output4;
        boolean flag = true;
        try {
            output = new FileWriter(new File("DBTitleAnsAuthor"));
            output2 = new FileWriter(new File("DBTitleAnsAuthorAndCity"));
            output3 = new FileWriter(new File("DBTitleAnsAuthorAndCityInfo")); 
            output4 = new FileWriter(new File("AllCitiesInfo")); 
//            for (int i = 0; i < words.size(); i++) {
//                Student student = students.get(i);
//                output.write(student.toFile() + "\n");
//            }
            if(flag)
            {
                  output.write("Title"+","+"Author"+"\n");
                  output2.write("Title"+","+"Author"+","+"City"+"\n");
                  output3.write("Title"+","+"Author"+","+"City"+"\n");
                  output4.write("City"+","+"Lat"+","+"Longt"+"\n");
                  
                  flag = false;
            }
//            for (Map.Entry<String, String> wordEntry
//                    : words.entrySet()) {
//                output.write(wordEntry.getKey()+","+wordEntry.getValue() + "\n");
//             
//            }
          for (int i = 0; i < words.size(); i++) 
          {
                output.write(words.get(i).getTitle()+","+words.get(i).getAuthor()+"\n");
          }
          
          
              // City city = words.get(0).getCities().get(0);
          for(int i = 0; i< words.size();i++)
          {
              String info = words.get(i).getTitle()+","+words.get(i).getAuthor()+","; 
              info = info + "\"";
              boolean flag4 = true;
              String firstCity = "";
              
                   for (Map.Entry<String, City> entry : words.get(i).getCities().entrySet())
                      {
                           //System.out.print(entry.getKey() + "," + entry.getValue().getLat()+","+entry.getValue().getLongt());
//                          if(i == words.size()-1)
//                          {
//                              
//                          }else
//                          {
//                              info+=",";
//                          }
                              if(flag4)
                                 {   
                                       // firstCity = city.getName();
                                        info += entry.getKey();
                                        flag4 = false;
                                 }else
                                 {
                                     info+= ","+entry.getValue().getName();
                                 }
                      }
              
             // List<City> city = words.get(i).getCities();
//             if(words.get(0)!=null)
//             {
//                 if(words.get(0).getCities()!= null)
//                 {
//                     info +=
//                 }
                         // info+=entry.getValue().getName();
//             }
                     info+="\"";
             
             
//              if(city != null && !city.isEmpty())
//              {
//                  info += city.get(0).getName();
//                  for (int j = 1; j < city.size(); j++) {
//                      info+=",";
//                      info += city.get(j).getName();
//                  }
//                  
//                  info+="\"";
//              }
                // output2.write(words.get(i).getTitle()+","+words.get(i).getAuthor()+","+info+"\n");
                 output2.write(info+"\n");
          }
          
          
              for(int i = 0; i< words.size();i++)
          {
              //System.out.println("I am in number 3");
              
                      for (Map.Entry<String, City> entry : words.get(i).getCities().entrySet())
                      {
                           //System.out.print(entry.getKey() + "," + entry.getValue().getLat()+","+entry.getValue().getLongt());
                           String info = words.get(i).getTitle()+","+words.get(i).getAuthor()+","; 
                           info += entry.getValue().getName();
                           info+="\n";
                           output3.write(info);
                          
                      }
              
            //  List<City> city = words.get(i).getCities();
//              if(city != null && !city.isEmpty())
//              {
//               
//                  
//                  for (int j = 0; j < city.size(); j++) 
//                  {
////                      info+=",";
////                      info += city.get(j).getName();
//                   String info = words.get(i).getTitle()+","+words.get(i).getAuthor()+","; 
//                   info += city.get(j).getName()+"\n";
//                      System.out.println("The info is "+info);
//                  }
//                 
//              }
          }
              
              
              
              
                 for (Map.Entry<String,City> entry : cities.entrySet()) 
          {
                City city = entry.getValue();
                output4.write(city.getName()+","+city.getLat()+","+city.getLongt()+"\n");
          }
          
              
              
              
            output.close();
            output2.close();
            output3.close();
            output4.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
            ex.printStackTrace();
        }
        //output.close();

    }
      }

//}
