package week3.day1;

import com.github.javafaker.Faker;

public class GenerateFakerData {

	public static void main(String[] args) {
		
		Faker faker = new Faker();
		String fullName = faker.name().fullName();
		System.out.println("Full name is "+fullName);
		System.out.println("First name is "+ faker.name().firstName());
		System.out.println("Last name is "+ faker.name().lastName());
		
	}
	
}
