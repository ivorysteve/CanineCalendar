package com.stephengilbane.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.stephengilbane.ContactInfo;

/**
 * Class defining an owner of dog.
 * 
 * @author stephengilbane
 *
 */
@Entity(name = "T_OWNER")
public class DogOwner
{
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_password")
    private String userPassword;

    @Transient
    private ContactInfo contactInfo;

    /**
     * Primary key.
     * 
     * @return
     */
    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    /**
     * @return the owner's first Name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the owner's first Name to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the owner's last Name
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the owner's last Name to set
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the userName used to log into the system.
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     * @param userName the userName to set, used to log into the system.
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     * @return the userPassword used for login.
     */
    public String getUserPassword()
    {
        return userPassword;
    }

    /**
     * @param userPassword the userPassword to set used for login.
     */
    public void setUserPassword(String userPassword)
    {
        this.userPassword = userPassword;
    }

    /**
     * @return the contactInfo for this owner.
     */
    public ContactInfo getContactInfo()
    {
        return contactInfo;
    }

    /**
     * @param contactInfo the contactInfo to set
     */
    public void setContactInfo(ContactInfo ci)
    {
        this.contactInfo = ci;
    }

}
