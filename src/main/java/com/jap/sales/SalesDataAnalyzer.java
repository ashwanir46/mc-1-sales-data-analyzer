package com.jap.sales;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesDataAnalyzer {
    // Read the data from the file and store in a List
   public List<SalesRecord> readFile(String fileName) {
       List<SalesRecord> salesRecordList = new ArrayList<>();
       try {
           FileReader fileReader = new FileReader(fileName);
           BufferedReader bufferedReader = new BufferedReader(fileReader);
           String line = bufferedReader.readLine();
           while ((line = bufferedReader.readLine()) != null) {
               String[] strings = line.split(",");
               String date = strings[0];
               int customerId = Integer.parseInt(strings[1]);
               int productCategory = Integer.parseInt(strings[2]);
               String paymentMethod = strings[3];
               double amount = Double.parseDouble(strings[4]);
               double timeOnSite = Double.parseDouble(strings[5]);
               int clicksInSite = Integer.parseInt(strings[6]);

               salesRecordList.add(new SalesRecord(date, customerId, productCategory, paymentMethod, amount, timeOnSite, clicksInSite));
           }

       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }

       return salesRecordList;
   }

    // Sort the customers based on purchase amount
    public List<SalesRecord> getAllCustomersSortedByPurchaseAmount(List<SalesRecord> salesData, AmountComparator amountComparator){

        return null;
    }

    // Find the top customer who spent the maximum time on the site
    public SalesRecord getTopCustomerWhoSpentMaxTimeOnSite(List<SalesRecord> salesData, TimeOnSiteComparator timeOnSiteComparator) {

        return null;
    }

    public static void main(String[] args) {
        SalesDataAnalyzer salesDataAnalyzer = new SalesDataAnalyzer();
        List<SalesRecord> salesRecordList = salesDataAnalyzer.readFile("src/main/resources/purchase_details.csv");
        for (SalesRecord salesRecord : salesRecordList) {
            System.out.println(salesRecord);
        }
    }

}
