# Akinator-OS
## Introduction
OSAkinator is a java program that reads data from an excel file which has both an entity and attributes associated with it.
When executing the program, it will ask various questions regarding the attributes and should it match one of the entities it will tell 
the user about it.
## Requirements
- [java](https://www.java.com/en/download/)
- [apache-poi](https://poi.apache.org/)

In my case I used [eclipse](https://www.eclipse.org/), an IDE that specializes in writing programs in java language it also makes using apache poi much easier.


Details of adding the apache-poi library [into your java class](https://www.youtube.com/watch?v=w757wjTiruU)

## Syntax of the program
>    public static final String SAMPLE_XLSX_FILE_PATH = "C:/Users/Eugene/Documents/Programming/awa2_4os.xlsx";

This syntax is used to use the excel file which in my case was awa2_4os which was found under that directory.

>  ArrayList<String> attributes = new ArrayList<String>();
	
>  	ArrayList<String> entities = new ArrayList<String>();
	
>  		ArrayList<ArrayList<Integer> > attributeMapping = new ArrayList<ArrayList<Integer> >(); 
  
The function uses three array lists where one of them is a dimensional variant. This is used as a mapping to store each and every attributes of all the entities.

>for (Row row : sheet) {
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
>        }
