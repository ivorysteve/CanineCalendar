package com.stephengilbane;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Contact information for any contactable entity (owner, organization, etc.).
 * @author stephengilbane
 *
 */
@Entity(name="T_CONTACT_INFO")
public class ContactInfo 
{
    @Id
    @GeneratedValue
    private Long id;
    
	private String firstName;
	private String lastName;
	private String street1;
	private String street2;
	private String city;
	private String state;
	private String mobilePhone;
	private String homePhone;
	
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
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the first Name to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the  contact's last Name.
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the contact's last Name to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the contact's primary street address.
	 */
	public String getStreet1() {
		return street1;
	}
	/**
	 * @param street1 the contact's primary street address. to set
	 */
	public void setStreet1(String street1) {
		this.street1 = street1;
	}
	/**
	 * @return the contact's secondary street address.
	 */
	public String getStreet2() {
		return street2;
	}
	/**
	 * @param street2 the contact's secondary street address to set
	 */
	public void setStreet2(String street2) {
		this.street2 = street2;
	}
	/**
	 * @return the contact's city.
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the contact's city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the contact's US state.
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the contact's US state to set.
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the contact's mobile Phone number.
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}
	/**
	 * @param mobilePhone the contact's mobile Phone to set.
	 */
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	/**
	 * @return the contact's home Phone
	 */
	public String getHomePhone() {
		return homePhone;
	}
	/**
	 * @param homePhone the contact's home Phone to set.
	 */
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	

}
