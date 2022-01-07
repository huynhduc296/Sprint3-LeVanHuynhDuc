package com.example.demo.entity.customer;

import com.example.demo.entity.account.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String customerName;
    private String customerAddress;
    private String customerPhone;

    @Column(columnDefinition = "LONGTEXT")
    private String customerImage;
    private Byte customerGender;
    private String customerBirthday;
    private double customerSalary;
    private boolean deleteFlag;


    @OneToOne
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

//    @JsonBackReference(value = "customer_orders")
//    @OneToMany(mappedBy = "customer")
//    private Set<Orders> ordersSet;


}
