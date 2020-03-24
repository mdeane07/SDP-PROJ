package gradedGroupProject;

import java.util.Date;

public class Profile implements ProfileInterface {
		private String name;
		private String address;
		private Date birthDate;
		
		
		
			public Profile(String name, String address, Date birthDate) {
				try {
					this.name = name;
					this.address = address;
					Date currentDate=new Date();
			
					if(birthDate.after(currentDate)) {
						System.err.println("Error: Invalid Date");
					}
					else {
						this.birthDate = birthDate;
					}
				}catch (Exception e) {
					
				}
			}
		
		
		public void changeClientProfileDetails( String name, String address, Date birthDate){
			this.name = name;
			this.address = address;
			this.birthDate=birthDate;
		}
		
		public void toPrint() {
			System.out.println();
			System.out.println("Profile Details: \n -----------------------");
			if ( name != null) System.out.println("name = " + name);
			if ( address != null) System.out.println("address = " + address);
			if ( birthDate != null) System.out.println("birthDate = " + birthDate);
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public void setName(String name)
		{
			 this.name=name;
		}

		
		
	}

