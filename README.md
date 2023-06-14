# Invoice-App
A project covering various concepts in Java.

## Inheritance and Arrays

### Objective:
* Given classes:
  * `Product.java`
  * `ProductDB.java` - class to interact with a database of products

* Code two sub-classes of `Product` class, namely:
  * `Book.java`
    * Contains `author` attribute
  * `Software.java`
    * Contains `version` attribute
    
* Code a main class `ProductApp.java` which does the following:
  * Accept product code from the user and get the appropriate product using `ProductDB` class and print it out to the console.
  * If user’s input doesn’t match any product code, then prompt user: `No product matches this product code.`
  * Print the product count so far.  
  * An array (of size 10) must be used to store the products.
  * Only valid prodcuts must be held in the array (no `null`).
  * Prompt user to `continue (y/n)?` to proceed further to accept another product code.   

## Interfaces

### Objective:
* Create an interface called `Tagable`, which has `getTags()` and `setTags()` methods.
* Let `Product` class implement `Tagable` interface.
* While setting tags to a product, make sure a product can have multiple tags and each tag is delimited with a comma.
And multiple invocations to `setTags` should not lose existing tags.

```
Eg: A Java book may contain the following tags:
      Core java, fundamentals, For beginners, programming language

Eg: A JSPS book may contain the following tags:
      Web programming, basic web, server pages
```
* Products must be sorted based on product code.


## Collections

### Objective:
* Create the following classes:
  * `ProductOrder`:
    * Contains `product`, `quantity`, `total` and `orderObjectCount` (Static member)    
    * Compare based on `total`

  * `Invoice`:
    * Contains `invoiceNumber` (can be a string), `date`, list of product orders, and `total`    

  * `InvoiceApp`:
    * Has `main()` method.
    * Take input from the user (product code and quantity).
    * Stop taking input if user inputs `done`.
    * Create an `Invoice`, sort the orders and print out invoice.
  
  * `SalesReport`:
    * Contains a map of product codes and product orders.
    * Contains a method that takes in a list of invoices and updates the map for each invoice in the list.
    * Prepare a sales report. The report should be in the following format:
    ```
    Code  Quantity  Price Total
    ```
    * Then, print the grand total of sales for the day.

  * `SalesReportApp`:
    *  Takes in a list of invoices from the user and prepares a sales report for the day.


## I/O Streams

### Objectives:
* Create a text file of your own which would contain all the product codes and quantity (optional). This file may contain each entry in separate line. Two options of approach:
  * Read both code and quantity from the file and create `ProductOrders` accordingly.
  * Read/have only product code in file and use `Random` class to generate quantity value by giving a reasonable limit.
* Create a `ReadMyFile.java` that contains all related functions to support your program.
* `InvoiceApp1File.java` should use the `ReadMyFile.java` to read the file.
* After every read, create the `ProductOrders` and store them in a collection object and create `Invoice` object and display them.
* Create `StoreMyObject.java` class to save the afore-mentioned `Invoice` object into `MyProdctOrders` file.  
  * To save the object, you may have to serialize the necessary objects. Use the `Object` stream to store and retrieve the object.
  * After storing the object, try reading the object from `MyProductOrders` file and deserialize the object and print the `Invoice`.


## Networking

### Objectives:
* The `Invoice` object that was serialized should be transferred to a server via `DatagramSocket` and `DatagramPacket`.
* The `DatagramPacket` should contain your name and the serialized object. Two approaches available for this:
  * Modify the serialized file to add your name in the first line of the file.
  * Concat your name byte array and object byte array together.
* Your `DatagramPacket` should be addressed to a given IP address and port number.
* You should be able to send the above data and should be able to receive the acknowledgement/response with 50bytes `DatagramPacket`.
