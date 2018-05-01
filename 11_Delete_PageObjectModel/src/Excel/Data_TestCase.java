package Excel;

import java.util.Hashtable;

import extent.Xls_Reader;


public class Data_TestCase {
	
	public static Object[][] get_FB_testCase(Xls_Reader xls, String Test_sheetName, String TestCaseName){
    String sheetName = Test_sheetName;	    
	    int testSrartRow_no = 1;
	    while(!xls.getCellData(sheetName, 0, testSrartRow_no).equals(TestCaseName)){
	    	testSrartRow_no++;
	    }System.out.println(testSrartRow_no);
	
	    int rowStart =testSrartRow_no + 2;
	    int colStart =testSrartRow_no + 1;
	    int row = 0;
	    while(!xls.getCellData(sheetName, 0, rowStart+row).equals("")){
	    	row++;
	    }System.out.println(row);
	    
	    int col=0;
	    while(!xls.getCellData(sheetName, col, colStart).equals("")){
	    	col++;
	    }System.out.println(col);
	    
	    Object[][] data=new Object[row][1];
	    int Rowdata=0;
	    Hashtable<String,String> table =null;
	     for(int r=rowStart;r<rowStart+row;r++){
	    	 table = new Hashtable<String,String>();
	    	for(int c=0;c<col;c++){
	    	   String key = xls.getCellData(sheetName, c, colStart);
	    	   String value = xls.getCellData(sheetName, c, r);
	    	   table.put(key, value);
	    	}
	    	data[Rowdata][0]=table;
	    	Rowdata++;
	    }
	    return data;
	}

}
