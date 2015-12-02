import static java.lang.System.out;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import static java.lang.System.*;


public class Functions {
	
	final DateTimeFormatter dateFormat, dateFormat2;
	SimpleDateFormat SdateFormat1;
	SimpleDateFormat SdateFormat2;

	static HashMap<String, HashMap<String, String>> hash_map = new HashMap<String, HashMap<String, String>>();
	
	protected static ArrayList<String> array_id;// = new ArrayList<String>();
	static ArrayList<String> selected_ids;// =  new ArrayList<String>();
	protected static boolean flag;
	protected static boolean flag2;
	
	Functions() {
		flag = false;
		flag2 = true;
		array_id = new ArrayList<String>();
		selected_ids =  new ArrayList<String>();
		dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		dateFormat2 = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
		
		SdateFormat1 = new SimpleDateFormat("MM/dd/yyyy");
		SdateFormat2 = new SimpleDateFormat("yyyy-MMM-dd");

	}

	void textFieldFunc(String data, String b) {
		
		//String data = a.getText().toString();
		
		if(data != null && data.isEmpty()==false) {
			if(!flag) {
				flag=true;
				for(String i: array_id) {
					if(hash_map.get(i).get(b).equals(data)) 
						selected_ids.add(i);
				}
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.clear();
				
				for(String i : selected_ids) {
					if(hash_map.get(i).get(b).equals(data)) 
						temp.add(i);
				}
				selected_ids = (ArrayList<String>)temp.clone();
			}
		}
	}
	
	void func_enroll_no(String data) {
		
		//String data = enroll_id.getText().toString();
		
		if(data != null && data.isEmpty()==false) {
			if(!flag) {
				flag = true;
				for(String i : array_id) {
					String get_val = hash_map.get(i).get("enroll_id");
					if(get_val.equals(data)) {
						selected_ids.add(i);
						break;
					}
				}
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.clear();
				
				for(String i : selected_ids) {
					if(hash_map.get(i).get("enroll_id").equals(data)) {
						temp.add(i);
						break;
					}
				}
				selected_ids = (ArrayList<String>)temp.clone();
			}
		}
	}
	
	void menuFunc(String data, String b) {
		
		if((data!=null)&&(data.equals("")==false)) {
			//String data = a.getSelectionModel().getSelectedItem().toString();
			
			if(!flag) {
				flag = true;
				for(String i : array_id) {
					String get_val = hash_map.get(i).get(b);
					if(get_val.equals(data)) 
						selected_ids.add(i);
				}
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.clear();
				
				for(String i : selected_ids) {
					if(hash_map.get(i).get(b).equals(data)) 
						temp.add(i);
				}
				selected_ids = (ArrayList<String>)temp.clone();
			}
		}
	}
	
	void func_gender(String data) {
				
		if(data!=null && data.isEmpty()==false) {
			//String data = gender.getSelectedToggle().toString();
			//String[] components = data.split("'");
			//data = components[1];
			
			if(!flag) {
				flag=true;
				for(String i: array_id) {
					//System.out.println(hash_map.get(i).get("gender"));
					if(hash_map.get(i).get("gender").equals(data)) 
						selected_ids.add(i);
				}
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.clear();
							
				for(String i : selected_ids) {
					//System.out.printf("gender: "+hash_map.get(i).get("gender")+"\n");
					if(hash_map.get(i).get("gender").equals(data)) 
						temp.add(i);
				}
				//System.out.println(temp);

				selected_ids = (ArrayList<String>)temp.clone();
			}
		}
	}
	
	void func_phyDis(String data) {
		
		if(data!=null && data.isEmpty()==false) {
			//String data = phyDis.getSelectedToggle().toString();
			String[] components = data.split("'");
			data = components[1];
			
			if(!flag) {
				flag=true;
				for(String i: array_id) {
					if(hash_map.get(i).get("phyDis").equals(data)) 
						selected_ids.add(i);
				}
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.clear();
				
				for(String i : selected_ids) {
					if(hash_map.get(i).get("phyDis").equals(data)) 
						temp.add(i);
				}
				selected_ids = (ArrayList<String>)temp.clone();
			}
		}
	}
	
	
	 int func_dob(String dob, String toggle ) throws ParseException {
		
		if(dob==null || dob.isEmpty())
			return 1;

		if(toggle==null || toggle.isEmpty()) {
			flag2 = false;
			return -1;
		}
		
		if((dob!= null)&&(dob.equals("")==false)) {			
			String curDate = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
			
			LocalDate curdt = LocalDate.parse(curDate, dateFormat);							// modified
			//LocalDate data = LocalDate.parse(dob, dateFormat);
			
			SimpleDateFormat SdateFormat3 = new SimpleDateFormat("dd-MM-yyyy");
			Date date = SdateFormat1.parse(dob);
			String modifiedString = SdateFormat3.format(date);
			LocalDate data = LocalDate.parse(modifiedString, dateFormat);


			if(curdt.isBefore(data)) {	
				System.out.println("date ahead!");// modified
				flag2 = false;																// modified
				return 0;
			}

			flag2 = true;
            				
			if(!flag) {
				flag=true;
				for(String i: array_id) {
					LocalDate dt = LocalDate.parse(hash_map.get(i).get("dob"), dateFormat);
					
					if(toggle.equals("Before")) {
						if(dt.isBefore(data))  
							selected_ids.add(i);
					} 
					else if(toggle.equals("On")) {
						if(dt.isEqual(data))
							selected_ids.add(i);
					} 
					else if(toggle.equals("After")){
						if(dt.isAfter(data))
							selected_ids.add(i);
					}
				}
			} else {
				ArrayList<String> temp = new ArrayList<String>();
				temp.clear();
				
				for(String i : selected_ids) {
					LocalDate dt = LocalDate.parse(hash_map.get(i).get("dob").toString(), dateFormat);
					
					if(toggle.equals("on")) {
						if(dt.isBefore(data)) 
							temp.add(i);
					}
					else if(toggle.equals("on")) {
						if(dt.isEqual(data))
							temp.add(i);
					} 
					else if(toggle.equals("on")) {
						if(dt.isAfter(data))
							temp.add(i);
					}
				}
				selected_ids = (ArrayList<String>)temp.clone();
			}
		}
		return 1;
	}
	 
	 Boolean checkBoxFunc(String s, String l, String e, String g, String data, int lowerLimit, int upperLimit) {
			
			//String data = t.getText().toString();
			if(data==null || data.isEmpty())					// Base Condtion
				return true;
			
			out.println(s+" "+data);
			
			if(data != null && data.isEmpty()==false) {
				
				if((Float.parseFloat(data)<lowerLimit)||(Float.parseFloat(data)>upperLimit)) {
					out.println("invalid Entry!");				
					flag2 = false;
					return false;
				}
				
				//popError.setText("");
				flag2 = true;
				
				if(l.equals("on")&&(flag==false)) {
					flag=true;
					for(String i : array_id) {
						if(hash_map.get(i).get(s).compareTo(data) < 0)
							selected_ids.add(i);
					}
				}
				
				if(e.equals("on")&&(flag==false)) {
					flag=true;
					for(String i : array_id) {
						if(hash_map.get(i).get(s).equals(data))
							selected_ids.add(i);
					}
				}
				
				if(g.equals("on")&&(flag==false)) {
					flag=true;
					for(String i : array_id) {
						if(hash_map.get(i).get(s).compareTo(data) > 0)
							selected_ids.add(i);
					}
				}
				
				if(l.equals("on")&&(flag==true)) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.clear();
					for(String i : selected_ids) {
						if(hash_map.get(i).get(s).compareTo(data) < 0)
							temp.add(i);
					}
					selected_ids = (ArrayList<String>)temp.clone();				
				}

				if(e.equals("on")&&(flag==true)) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.clear();
					for(String i : selected_ids) {
						if(hash_map.get(i).get(s).equals(data))
							temp.add(i);
					}
					selected_ids = (ArrayList<String>)temp.clone();				
				}
				
				if(g.equals("on")&&(flag==true)) {
					ArrayList<String> temp = new ArrayList<String>();
					temp.clear();
					for(String i : selected_ids) {
						if(hash_map.get(i).get(s).compareTo(data) > 0)
							temp.add(i);
					}
					selected_ids = (ArrayList<String>)temp.clone();				
				}

			}
			return true;
			
		}


	 void dateFunc(String inputdate, String s) throws ParseException {

		 if((inputdate != null)&&(inputdate.isEmpty()==false)) {
				 
				 Date date = SdateFormat1.parse(inputdate);
				 String modifiedString = SdateFormat2.format(date);
				 LocalDate data = LocalDate.parse(modifiedString, dateFormat2);
							
				if(!flag) {
					flag=true;
					for(String i: array_id) {
						LocalDate dt = LocalDate.parse(hash_map.get(i).get("timestamp").toString(), dateFormat2);     // modified
						
						if(s.equals("upto")) {
							if(dt.isBefore(data)) 
								selected_ids.add(i);
						} else if(s.equals("from")) {
							if(dt.isAfter(data))
								selected_ids.add(i);
						}
					}
				} else {
					ArrayList<String> temp = new ArrayList<String>();
					temp.clear();
					
					for(String i : selected_ids) {
						LocalDate dt = LocalDate.parse(hash_map.get(i).get("timestamp").toString(), dateFormat2);
						
						if(s.equals("upto")) {
							if(dt.isBefore(data)) 
								temp.add(i);
						} else if(s.equals("from")) {
							if(dt.isAfter(data))
								temp.add(i);
						}
					}
					selected_ids = (ArrayList<String>)temp.clone();
				}
			}
		}


 	private String TempChangeColName(String s) {
		
		switch(s) {
		case "Email":
			return "email";
		case "EnrollmentNo":
			return "enroll_id";
		case "Gender":
			return "gender";
		case "Name":
			return "name";
		case "Category":
			return "category";
		case "Physically Disabled":
			return "phyDis";
		case "DOB":
			return "dob";
		case "PhD Stream":
			return "phd";
		case "Graduation Degree":
			return "gDeg";
		case "Post Grad Degree":
			return "pgDeg";
		case "Xth Board":
			return "xBoard";
		case "XIIth Board":
			return "xiiBoard";
		case "Graduation Department":
			return "gDept";
		case "Post Grad Department":
			return "pgDept";
		case "Graduation University":
			return "gUni";
		case "Post Grad College":
			return "pgUni";
		case "Graduation State":
			return "gState";
		case "Post Grad State":
			return "pgState";
		case "Xth Marks (%)":
			return "xPercen";
		case "XIIth Marks (%)":
			return "xiiPercen";
		case "Grad CGPA or Marks":
			return "gPercen";
		case "Post Grad CGPA or Marks":
			return "pgPercen";
		case "Marks(%)":
			return "gateScore";
		case "Timestamp":
			return "timestamp";
		default:
			return s;
		}
	}
	
	public void TempParse(String s, String dataRepository) {
				
		String csvFile = s;
		BufferedReader reader =  null;
		String cur_line="";
		
		try {
			
			reader = new BufferedReader(new FileReader(csvFile));
			
			cur_line=reader.readLine();
			String[] category = cur_line.split(",");
			
			for(int i=0; i<category.length; i++)
				category[i] = TempChangeColName(category[i]);
						
			while((cur_line=reader.readLine())!=null) {
				
				 String[] val = cur_line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
				
				HashMap<String, String> unit_map = new HashMap<String, String>();
				
				for(int i=0; i<val.length; i++) {
					if(category[i].equals("timestamp")) {
						String[] t = val[i].split(" ");
						val[i] = t[0];
					}
					unit_map.put(category[i],val[i]);
				}
				
				File file = new File(dataRepository+unit_map.get("enroll_id")+".txt");
				if(!file.exists())
					file.createNewFile();
				BufferedWriter bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
				for(Map.Entry<String, String> entry : unit_map.entrySet()) {
					bw.write(entry.getKey()+" : "+entry.getValue());
					bw.write("\n");
				}
				bw.close();
				
				hash_map.put(unit_map.get("enroll_id"),unit_map);
				
				array_id.add(unit_map.get("enroll_id"));
			}
		
		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				
			}
		}
	}
	
	void PrintSelectedIds() {
		System.out.println("\nSelected ids: ");
		for(String i : selected_ids)
			System.out.printf(i+"  ");
	}
	
}
