package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders
{
    //DataProvider 1

    @DataProvider(name="LoginData")
    public String [][] getData() throws IOException
    {
        String path="src/test/resources/Book1.xlsx";//taking xl file from testData

        ExcelUtility xlutil=new ExcelUtility(path);//creating an object for XLUtility

        int totalrows=xlutil.getRowCount("Sheet1");
        System.out.println("total rows:"+totalrows);
        int totalcols=xlutil.getCellCount("Sheet1",1);
        System.out.println("total coloums:"+totalcols);
        String logindata[][]=new String[totalrows][totalcols];//created for two dimension array which can store the data user and password

        for(int i=1;i<=totalrows;i++)  //1   //read the data from xl storing in two deminsional array
        {
            for(int j=1;j<totalcols;j++)  //0    i is row s j is col
            {
                logindata[i-1][j]= xlutil.getCellData("Sheet1",i, j);  //1,0
            }
        }
        return logindata; //returning two dimension array


    }

}
