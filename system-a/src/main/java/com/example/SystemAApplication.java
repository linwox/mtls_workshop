package com.example;

import com.example.integration.ContractClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;

import java.util.Scanner;

@SpringBootApplication
public class SystemAApplication {

    public static void main(String[] args) {
        SpringApplication.run(SystemAApplication.class, args);

        ContractClient client = new ContractClient();
        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Enter a contract key to perform search for matching contract:");

            String key = scanner.nextLine();

            try {
                ResponseEntity<String> result = client.getContract(key);
                System.out.println(result);
            } catch (Exception e) {
                System.out.println("Something went wrong");
            }

        }

    }

}
