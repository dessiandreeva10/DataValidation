import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUserInfo {
	private String name;
	private String EGN;
	private String BULSTAT;
	private String FK;
	private String email;
	
	public ValidateUserInfo(){
		this.name = " ";
		this.EGN = " ";
		this.BULSTAT = " ";
		this.FK = " ";
		this.email = " ";
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getBulstat(){
		return this.BULSTAT;
	}
	
	public String getFK(){
		return this.FK;
	}
	
	public String getEGN(){
		return this.EGN;
	}
	
	public void setName(String name){
	  this.name = name;
	}
	
		
	public void setEGN(String EGN){
		this.EGN = EGN;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	public void setBulstat(String BULSTAT){
		this.BULSTAT = BULSTAT;
	}
	
	public void setFK(String FK){
		this.FK = FK;
	}
	
	
	public String getEmail(){
		return this.email;
	}
	
	private static String namePattern = "[A-Z]+[a-z]{1,15} [A-Z]+[a-z]{1,15} [A-Z]+[a-z]{1,15}";
	private static String EGNPattern = "[0-9]{10}";
	private static String BULSTATPattern = "[BG]{2}[0-9]{9}";
	private static String FKPattern = "[0-9]{2}[-]{1}[0-9]{3}";
	private static String emailPattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
	
	private static Pattern pattern;
	private static Matcher matcher;
	
	public ValidateUserInfo askForName(Scanner sc, Pattern p, Matcher m, ValidateUserInfo v){
		String name;
		boolean ret;
		
		System.out.println("Enter your name:");
		sc.nextLine();
		name = sc.nextLine();
		p = Pattern.compile(namePattern);
		m = p.matcher(name);
		ret = m.matches();
		
		if(ret == true){
			v.setName(name);
		}else{
			throw new IllegalNameException();
		}
		
		return v;	
	}
	
	public ValidateUserInfo askForEGN(Scanner sc, Pattern p, Matcher m, ValidateUserInfo v){
		String EGN;
		boolean ret;
		
		System.out.println("Enter your EGN:");
		EGN = sc.next();
		p = Pattern.compile(EGNPattern);
		m = p.matcher(EGN);
		ret = m.matches();
		
		if(ret == true){
			v.setEGN(EGN);
		}else{
			throw new IllegalEGNException();
		}
		
		return v;	
	}
	
	public ValidateUserInfo askForBulstat(Scanner sc, Pattern p, Matcher m, ValidateUserInfo v){
		String BULSTAT;
		boolean ret;
		
		System.out.println("Enter your Bulstat:");
		BULSTAT = sc.next();
		p = Pattern.compile(BULSTATPattern);
		m = p.matcher(BULSTAT);
		ret = m.matches();
		
		if(ret == true){
			v.setBulstat(BULSTAT);
		}else{
			throw new IllegalBulstatException();
		}
		
		return v;	
	}
	
	public ValidateUserInfo askForFK(Scanner sc, Pattern p, Matcher m, ValidateUserInfo v){
		String FK = null;
		boolean ret;
		
		System.out.println("Enter your FK:");
		FK = sc.next();
		p = Pattern.compile(FKPattern);
		m = p.matcher(FK);
		ret = m.matches();
		
		if(ret == true){
			v.setFK(FK);
		}else{
			throw new IllegalFKException();
		}
		
		return v;	
	}
	
	public ValidateUserInfo askForEmail(Scanner sc, Pattern p, Matcher m, ValidateUserInfo v){
		String email;
		boolean ret;
		
		System.out.println("Enter your email:");
		email = sc.next();
		p = Pattern.compile(emailPattern);
		m = p.matcher(email);
		ret = m.matches();
		
		if(ret == true){
			v.setEmail(email);
		}else{
			throw new IllegalEmailException();
		}
		
		return v;	
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		ValidateUserInfo v = new ValidateUserInfo();
		boolean run = true;
		String begin;
		
		while(run){
			System.out.println("Enter are you entering personal info or for legal entity?");
			System.out.println("Press person or company:");
			begin = sc.next();
			
			if(begin.equals("person")){
				try{
					v.askForName(sc, pattern, matcher, v);
					v.askForEGN(sc, pattern, matcher, v);
					v.askForFK(sc, pattern, matcher, v);
					v.askForEmail(sc, pattern, matcher, v);
					
				}catch(IllegalEGNException e){
					System.out.println(e.getMessage());
				}catch(IllegalNameException e){
					System.out.println(e.getMessage());
				}catch(IllegalFKException e){
					System.out.println(e.getMessage());
				}catch(IllegalEmailException e){
					System.out.println(e.getMessage());
				}catch(IllegalBulstatException e){
					System.out.println(e.getMessage());
				}
			}else if(begin.equals("company")){
				try{
					v.askForName(sc, pattern, matcher, v);
					v.askForBulstat(sc, pattern, matcher, v);
					v.askForFK(sc, pattern, matcher, v);
					v.askForEmail(sc, pattern, matcher, v);
					
				}catch(IllegalEGNException e){
					System.out.println(e.getMessage());
				}catch(IllegalNameException e){
					System.out.println(e.getMessage());
				}catch(IllegalFKException e){
					System.out.println(e.getMessage());
				}catch(IllegalEmailException e){
					System.out.println(e.getMessage());
				}catch(IllegalBulstatException e){
					System.out.println(e.getMessage());
				}
			}
		}
		
	
	}

}
