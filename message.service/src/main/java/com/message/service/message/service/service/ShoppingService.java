package com.message.service.message.service.service;

import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

@Component
public class ShoppingService {
 public List<String> saveShoppintCart(String fileNmne, int balance) {
    Map<Integer,String> itemMap = new TreeMap<>();
    List<Integer> itemList = new ArrayList<>();
     try {// get file input
         Scanner fileFscanner = new Scanner(new File(fileNmne));
         while (fileFscanner.hasNextLine()) {
             // split each line
             String [] item = fileFscanner.nextLine().split("\\,");
             int key = (Integer.parseInt(item[1].trim())/100);
             itemMap.put(key,item[0]);
             itemList.add(key);
             }
         fileFscanner.close();
     } catch (Exception e) {

     }
   return   findGiftItem(itemList,itemMap,balance/100);
 }

 public List<String>findGiftItem(List<Integer>itemList, Map<Integer,String>itemMap , int balance){
     List<String> giftList =new ArrayList<>();
     List<String> result =new ArrayList<>();
     int total = 0;
     int start =0;
     int end =itemList.size()-1;
     // traverse list from both ends comparing prices and updating total
     // once its <= balance;
     if(!itemList.isEmpty()){
     while(start< end){
         int newTotal =itemList.get(start)+itemList.get(end);
         if(newTotal >total && newTotal<=balance){
            total=newTotal;
            // clear list because we only need 2 items
             giftList.clear();
             giftList.add(itemList.get(start).toString());
             giftList.add(itemList.get(end).toString());
            start++;

          }
                  // if greater than balancesince the array is sorted decrement end
        else if(newTotal >total && newTotal>balance){
             end--;
         }
          /// break if this condition is met
         else if(newTotal <total && newTotal<=balance){
             break;
         }

        }
     }
     if(giftList.isEmpty()){
         result.add("Not Possible");
         return result;
     }else {// extract valur from lisst and match with mapkeys
         String gift1 = itemMap.get(Integer.parseInt(giftList.get(0)));
         String gift2 = itemMap.get(Integer.parseInt(giftList.get(1)));
         result.add(gift1 + "," + giftList.get(0));
         result.add(gift2 + "," + giftList.get(0));
     }
 return  result;
 }

 public static String formatPath(String file){
     StringBuilder sb = new StringBuilder();
     // rempve underscore from file path
     file = file.replaceAll("\\_","/");
     char[] path = file.toCharArray();
     //replace the second / with :
     path[1]=':';
     for(char s:path){
         sb.append(s);
     }
     // returm correct formated path
     return sb.toString();
 }
}
