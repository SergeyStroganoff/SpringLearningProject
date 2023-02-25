package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "details")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "city")
    private String city;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "email")
    private String email;

    @ToString.Exclude
    @OneToOne(mappedBy = "employeeDetail", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Employee employee;

    public void addEmployee(Employee employee) {
        this.employee = employee;
    }
}
