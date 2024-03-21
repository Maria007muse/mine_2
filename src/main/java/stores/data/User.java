package stores.data;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Collection;

@Entity
@Data
@Table(name = "user_table", uniqueConstraints =
       @UniqueConstraint(columnNames = "userName"))
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;

   @Column(name = "user_name")
   private String userName;

   @Column(name = "full_name")
   private String fullName;

   private String street;
   private String city;
   private String zip;
   @Column(name = "phone_Number")
   private String phoneNumber;
   private String password;

   @ManyToMany(fetch = FetchType.EAGER, 
                   cascade = CascadeType.ALL)
   @JoinTable(name = "users_roles", 
       joinColumns = @JoinColumn(name = "user_id", 
         referencedColumnName = "id"), 
           inverseJoinColumns = @JoinColumn
              (name = "role_id", 
                 referencedColumnName = "id"))
   private Collection<Role> roles;

   public User() {

   }

   public User(String userName, String fullName,
         String street, String city, String zip, String phoneNumber, String password,
                   Collection<Role> roles) {
      
      this.userName = userName;
      this.fullName = fullName;
      this.street = street;
      this.city = city;
      this.zip = zip;
      this.phoneNumber = phoneNumber;
      this.password = password;
      this.roles = roles;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUserName() {
      return userName;
   }

   public void setUserName(String userName) {
      this.userName = userName;
   }

   public String getFullName() {
      return fullName;
   }

   public void setFullName(String fullName) {
      this.fullName = fullName;
   }

   public String getStreet() {
      return street;
   }

   public void setStreet(String street) {
      this.street = street;
   }

   public String getCity() {
      return city;
   }

   public void setCity(String city) {
      this.city = city;
   }

   public String getZip() {
      return zip;
   }

   public void setZip(String zip) {
      this.zip = zip;
   }

   public String getPhoneNumber() {
      return phoneNumber;
   }

   public void setPhoneNumber(String phoneNumber) {
      this.phoneNumber = phoneNumber;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public Collection<Role> getRoles() {
      return roles;
   }

   public void setRoles(Collection<Role> roles) {
      this.roles = roles;
   }
}