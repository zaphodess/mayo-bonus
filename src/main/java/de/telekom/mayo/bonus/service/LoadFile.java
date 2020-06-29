package de.telekom.mayo.bonus.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoadFile {

   private boolean writeData(byte[] data, String fileName) {
       File file = new File(fileName);

       FileOutputStream fos = null;
       try {
           fos = new FileOutputStream(file);
           fos.write(data);
           fos.flush();
           return true;
       } catch (FileNotFoundException e) {
           System.err.println(file + " doesn't exist!");
       } catch (IOException e) {
           System.err.println("Problems writing data to " + file);
       } finally {
           try {
               if(fos != null) fos.close();
           }catch(IOException e){}
       }
       return false;
   }

   private byte[] readData(String fileName) {
       File file = new File(fileName);
       FileInputStream fis = null;
       byte[] data = null;
       try {
           fis = new FileInputStream(file);
           data = new byte[(int) file.length()];
           fis.read(data);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       } finally {
           try {
               if(fis != null) fis.close();
           } catch (IOException e) {}
       }
       return data;
   }
//
//   public static void main(String[] args) {
//       String txt = "Testdatei";
//       String fileName = "../../../../../../resources/static/img/wwf-logo.jpg";
//    
//       LoadFile bas = new LoadFile();
//       if (bas.writeData(new String(txt).getBytes(), fileName))
//           System.out.println("'" + txt
//                   + "' erfolgreich als byte[] gespeichert");
//       String ergebnis = new String(bas.readData(fileName));
//       System.out.println("Aus Datei gelesen: '" + ergebnis + "'");
//   }
} 