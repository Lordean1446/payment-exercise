package com.lordean1446.services;

import com.lordean1446.entities.Contract;
import com.lordean1446.entities.Installment;

import java.time.LocalDate;

public class ContractService {

    private OnlinePaymentService onlinePaymentService;

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

    public void processContract(Contract contract, int months) {

        double baseInstallment = contract.getTotalValue() / months; // valor base da parcela sem juros e taxas

        for (int i=1; i <= months; i++) {
            LocalDate dueDate = contract.getDate().plusMonths(i); // data da parcela
            double interest = onlinePaymentService.interest(baseInstallment, i);
            double fee = onlinePaymentService.paymentFee(baseInstallment + interest);
            double totalInstallmentValue = baseInstallment + interest + fee; // valor da parcela com juros e taxas
            contract.getInstallments().add(new Installment(dueDate, totalInstallmentValue));
        }

    }
}