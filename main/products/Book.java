package main.products;

public class Book extends Product{


//Data Members...

      private String author;



//Methods...

      public Book(){
         
            author="";
      }  

      public Book(String cd, String desc, double pr, String aut){

            super(cd,desc,pr);
            author=aut;
      }    

      public void setAuthor(String s){

            author=s;
      }

      public String toString(){

            return super.toString()+"Author:      "+author+"\n";
      }
}
