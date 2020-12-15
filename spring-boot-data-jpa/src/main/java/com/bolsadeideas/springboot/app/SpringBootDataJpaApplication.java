package com.bolsadeideas.springboot.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bolsadeideas.springboot.app.models.service.IUploadFileService;

@SpringBootApplication
public class SpringBootDataJpaApplication  implements CommandLineRunner {

	@Autowired
	IUploadFileService uploadFileService;
	
	@Autowired
	private BCryptPasswordEncoder passwordEnconder;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDataJpaApplication.class, args);
		System.out.println("AQUIIIIII");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("INICION");
		uploadFileService.deleteAll();
		uploadFileService.init();
		
		String password = "12345";
		System.out.println(password);
		String bcryptPassword = "";
		for(int  i=0; i<2; i++) {
			 bcryptPassword = passwordEnconder.encode("prueba");
			 System.out.println("ENCRIPTADO: "+bcryptPassword);
		}

		
		System.out.println("FIN");
	}

}
