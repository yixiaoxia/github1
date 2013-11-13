/*
 * Copyright (C) 2005 Luca Veltri - University of Parma - Italy
 * 
 * This file is part of MjSip (http://www.mjsip.org)
 * 
 * MjSip is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * MjSip is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MjSip; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 * 
 * Author(s):
 * Luca Veltri (luca.veltri@unipr.it)
 */

package org.zoolu.tools;


import java.io.*;
import java.net.URL;
//import java.net.URI;



/** Collection of static methods for handling files and jar archives.
*/
public class Archive
{
   /** The base path */
   public static String BASE_PATH=(new File("")).getAbsolutePath();
   //**** PersonalJava ****
   //public static String BASE_PATH="\\My Documents\\Lavoro\\";


   /** Gets the complete url of a file included within a jar archive. */
   public static URL getJarURL(String jar_archive, String file_name)
   {  if (jar_archive==null || file_name==null) return null;
      // else
      String url="jar:file:"+BASE_PATH+"/"+jar_archive+"!/"+file_name;
      try
      {  return new URL(url);
      }
      catch (java.net.MalformedURLException e)
      {  System.err.println("ERROR: malformed url "+url);
         return null;
      } 
   }


   /** Gets the complete url of a file. */
   public static URL getFileURL(String file_name)
   {  if (file_name==null) return null;
      // else
      String url="file:"+BASE_PATH+"/"+file_name;
      try
      {  return new URL("file:"+BASE_PATH+"/"+file_name);
      }
      catch (java.net.MalformedURLException e)
      {  System.err.println("ERROR: malformed url "+url);
         return null;
      } 
   }


   /** Gets an Image from file */
   public static void getImage(String file_name)
   { 
   }
   
   
   /** Gets an Image from a URL. */
   public static void getImage(URL url)
   { 
   }


   /** Gets an ImageIcon from file */
   public static void getImageIcon(String file_name)
   {  
   }


   /** Gets an ImageIcon from an URL */
   public static void getImageIcon(URL url)
   {  
   }


   /** Gets an InputStream from an URL */
   public static InputStream getInputStream(URL url)
   {  if (url==null) return null;
      //else         
      InputStream in=null;
      try
      {  in=(url).openStream();
      }
      catch (java.io.IOException e)
      {  System.err.println("ERROR: can't read the file "+url.toString());
      } 
      return in;
   }
   
   
   /** Gets an AudioInputStream from an URL */
   public static void getAudioInputStream(URL url) 
   {  
   }
}
