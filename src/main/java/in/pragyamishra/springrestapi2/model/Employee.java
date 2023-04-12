package in.pragyamishra.springrestapi2.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Setter
@Getter
@ToString
@Entity
@Table(name="tbl_employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
   // @NotNull(message = "Name should not be null")
   // @NotEmpty(message ="Name should not be null")
    @NotBlank(message ="Name should not be null")
    private String name;

    private Long age=0L;

    private String location;

    @Email(message="Please enter the valid email address")
    private String email;
    //@NotNull(message = "Name should not be null")
    //@NotEmpty(message ="Department should not be null")
    @NotBlank(message ="Department should not be null")
    private String department;
    @CreationTimestamp
    @Column(name="created_at" , nullable = false, updatable = false)
    private Date createdAt;
    @UpdateTimestamp
    @Column(name="update_at")
    private Date UpdateAt;

}
