
package main.products;

import main.products.interfaces.*;

import java.text.NumberFormat;
import java.util.Locale;            //for customizing our locale (here, you can use it for printing the price)
import java.lang.Comparable;
import java.io.*;


public class Product implements Comparable, Tagable, Serializable
{
    private String code;
    private String description;
    private double price;
    private String tag;    

    public static int count = 0;

    public Product()
    { 
        this("","",0);
    }

    public Product(String cd, String desc, double pr)
    {
        code = cd;
        description = desc;
        price = pr;
        tag="";

        count++;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public String getFormattedPrice()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }

    public String toString()
    {
        String s= "Code:        " + code + "\n" +
                  "Description: " + description + "\n" +
                  "Price:       " + this.getFormattedPrice() + "\n";

        if(tag.equals(""))
           return s;
        
        return s+"Tag(s):       " + tag + "\n";
    }

    public static int getCount()
    {
        return count;
    }

   
    public int compareTo(Object o){

	  Product p1 = (Product)o;
          return this.code.compareTo(p1.code);
    }

    public void setTags(String tag){
   
          if(this.tag.equals(""))
             this.tag=tag;
          else
              this.tag+=", "+tag;
    }

    public String getTags(){

          return this.tag;
    }
}
