package com.stephengilbane;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Contact information for any contactable entity (dog owner, visit organization, etc.).
 * @author stephengilbane
 */
@ApiModel( 
        value = "ContactInfo", 
        description = "Contact information for any human entity." 
)
@Entity(name="T_CONTACT_INFO")
public class ContactInfo 
{
    @Id
    @GeneratedValue
    private Long id;
    
    @ApiModelProperty( value = "First name of contact." ) 
    @Column(name = "FIRST_NAME")
	private String firstName;
    
    @ApiModelProperty( value = "Last name of contact." ) 
    @Column(name = "LAST_NAME")
	private String lastName;
	
    @ApiModelProperty( value = "Street address of contact." ) 
	@Column(name = "STREET_1")
	private String street1;
	@Column(name = "STREET_2")
	private String street2;
	
    @ApiModelProperty( value = "City of contact address." ) 
	private String city;
    
    @ApiModelProperty( value = "US state of contact address." ) 
	private String state;
    
    @ApiModelProperty( value = "Zip code of contact address." ) 
	private String zip;
	@Column(name = "CELL_PHONE")
	private String mobilePhone;
	@Column(name = "HOME_PHONE")
	private String homePhone;
	@Column(name = "EMAIL")
	private String email;
	
	/**
	 * Primary key.
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
     * @return the contact's first Name.
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the first Name to set.
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the contact's last Name.
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * @param lastName the contact's last Name to set.
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * @return the contact's primary street address.
     */
    public String getStreet1()
    {
        return street1;
    }

    /**
     * @param street1 the contact's primary street address. to set
     */
    public void setStreet1(String street1)
    {
        this.street1 = street1;
    }
	/**
	 * @return the contact's secondary street address.
	 */
    public String getStreet2()
    {
        return street2;
    }

    /**
     * @param street2 the contact's secondary street address to set
     */
    public void setStreet2(String street2)
    {
        this.street2 = street2;
    }

    /**
     * @return the contact's city.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * @param city the contact's city to set.
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * @return the contact's US state.
     */
    public String getState()
    {
        return state;
    }
	/**
	 * @param state the contact's US state to set.
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
     * @return the zip
     */
    public String getZip()
    {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip)
    {
        this.zip = zip;
    }

    /**
	 * @return the contact's mobile Phone number.
	 */
	public String getMobilePhone() 
	{
		return mobilePhone;
	}
	/**
	 * @param mobilePhone the contact's mobile Phone to set.
	 */
	public void setMobilePhone(String mobilePhone) 
	{
		this.mobilePhone = mobilePhone;
	}
	/**
	 * @return the contact's home Phone
	 */
	public String getHomePhone() 
	{
		return homePhone;
	}
	/**
	 * @param homePhone the contact's home Phone to set.
	 */
	public void setHomePhone(String homePhone) 
	{
		this.homePhone = homePhone;
	}

    /**
     * @return the contact's email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * @param email the contact's email to set
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
	
}
