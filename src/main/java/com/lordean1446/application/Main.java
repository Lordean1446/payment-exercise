package com.lordean1446.application;

import com.lordean1446.entities.Contract;
import com.lordean1446.entities.Installment;
import com.lordean1446.services.ContractService;
import com.lordean1446.services.PaypalService;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre os dados do contrato: ");
        System.out.print("Número: ");
        int contractNumber = sc.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate contractDate = LocalDate.parse(sc.next(), dtf);
        System.out.print("Valor do contrato: ");
        double contractValue = sc.nextDouble();

        Contract obj = new Contract(contractNumber, contractDate, contractValue);

        System.out.print("Entre com o número de parcelas: ");
        int contractInstallments = sc.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(obj, contractInstallments);

        System.out.println("Parcelas:");
        for (Installment installment : obj.getInstallments()) {
            System.out.println(installment);
        }

        sc.close();
    }
}
