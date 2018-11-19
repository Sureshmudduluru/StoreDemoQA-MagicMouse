/** This Class contains the methods to create separate folders for TestNG reports for every test run with time stamp.
  */
package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Reporter;

public class TestNG_Reports {
	public static void Take_TestOutput_Backup() throws IOException
	{

	String Foldername = new SimpleDateFormat("HH_mm_ss").format(new Date());
	File srcFolder = new File("./test-output");
	//File destFolder = new File("C:\\SeleniumTestNGReports\\reports"+"Execution_Results_"+Foldername);
	File destFolder = new File("./TestNGReports/reports"+"Execution_Results_"+Foldername);
	//make sure source exists
	if(!srcFolder.exists())
	{
	System.out.println("Directory does not exist at mentioned location.");
	//just exit
	System.exit(0);
	}
	else
	{

	try
	{
		copy_Folder(srcFolder,destFolder);
	}
	catch(IOException e){
	e.printStackTrace();
	//error, just exit
	System.exit(0);
	}
	}
	}
    
	public static void copy_Folder(File src, File dest)
	throws IOException{

	if(src.isDirectory()){
	//if directory not exists, create it
	if(!dest.exists()){
	dest.mkdir();
	System.out.println("Directory copied from "
	+ src + " to " + dest);
	}
	//list all the directory contents
	String files[] = src.list();

	for (String file : files)
	{
	//construct the src and dest file structure
	File srcFile = new File(src, file);
	File destFile = new File(dest, file);
	//recursive copy
	copy_Folder(srcFile,destFile);
	}

	}else
	{
	//if file, then copy it.
	//Use bytes stream to support all file types
	InputStream in = new FileInputStream(src);
	OutputStream out = new FileOutputStream(dest);

	byte[] buffer = new byte[1024];

	int length;
	//copy the file content in bytes
	while ((length = in.read(buffer)) > 0){
	out.write(buffer, 0, length);
	}

	in.close();
	out.close();
	System.out.println("File copied from " + src + " to " + dest);
	}
	}
	
	public static void reportLog(String step, String expected,String actual, String status){
		Reporter.log(step+ " .Expected = "+expected +" and Actual = "+actual +" .Status- "+status);
		
	}
}
