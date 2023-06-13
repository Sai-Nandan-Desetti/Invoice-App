package main.products;

public class Software extends Product{


//Data Members...

      private String version;


//Methods...
 
      public Software(){

            version="";
      }

      public Software(String cd, String desc, double pr, String vr){

            super(cd,desc,pr);
            version=vr; 
      }

      public void setVersion(String s){

            version=s;
      }

      public String toString(){

            return super.toString()+"Version:     "+version+"\n";
      }

}
