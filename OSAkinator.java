import java.io.*;
import java.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.openxml4j.exceptions.*;

public class OSAkinator {
    public static final String SAMPLE_XLSX_FILE_PATH = "C:/Users/Eugene/Documents/Programming/awa2_4os.xlsx";

    public static void main(String[] args) throws IOException, InvalidFormatException {
    	
    	int i = 0, j =0, k=0;

        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));
        ArrayList<String> attributes = new ArrayList<String>();
        ArrayList<String> entities = new ArrayList<String>();
        ArrayList<ArrayList<Integer> > attributeMapping 
        = new ArrayList<ArrayList<Integer> >(); 

        Sheet sheet = workbook.getSheetAt(0);

        
        for (Row row : sheet) {
        	attributeMapping.add(new ArrayList<Integer>());
	                for (Cell cell : row) {
	                	if ( i == 0) {
	                	String value = cell.getStringCellValue();
	                	attributes.add(value);
	                	}
	                	else {
	                		try {
	                			if ( j == 0) {
	                				String value = cell.getStringCellValue();
	                				entities.add(value);
	                				j=1;
	                			}
	                			else {
	                				int value = (int) cell.getNumericCellValue();
	                				 attributeMapping.get(k).add(value);
	                				 if (value != 1 && value != 0) {
	                					 attributeMapping.remove(k);
	                					 break;
	                				 }
	                			}
	                		}
	                		catch(Exception e){
	                			break;
	                		}
	                	}
	                }
	                j = 0;
	                i = 1;
	                k++;
        }
        //attributes.remove(0);
        attributeMapping.remove(0);
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> response = new ArrayList<Integer>();
        int start =1;
        int count = 0;
        while (start==1) {
        	count = 0;
	        System.out.println("======================================================================="
	        		+ "\nAKINATOR OS\n What do you want to do?\n 1.Start\n 2.Exit\n"
	        		+ "=======================================================================");
	        int answer = input.nextInt();
	        if (answer == 1) {
	        	for(i=0;i<attributes.size();i++) {
	        		System.out.println("Is it " + attributes.get(i) +"? y/n");
	        		char ans = input.next().charAt(0);
	        		if (ans=='y') {
	        			response.add(1);
	        		}
	        		else {
	        			response.add(0);
	        		}
	        	}
		        for (i=0;i<entities.size();i++) {
		        	count = 0;
		        	for (j=0;j<attributes.size();j++) {
		        		if (attributeMapping.get(i).get(j)==response.get(j)) {
		        			count++;
		        		}
		        	}
		        	if (count ==attributes.size()) {
			        	System.out.println("Is it " + entities.get(i)+ "?");
			        	count = -1;
			        	break;
			        }
		        }
		        if (count != -1) {
		        	System.out.println("No matches");
		        }
	        }
	        else {
	        	if (answer == 2) {
	        		start = 0;
	        	}
	        }
        }
        workbook.close();
    }
}