package frnds.collie.services.collie.dao;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "RI_USER_DETAILS")
public class UserDetailsImpl {

	@Id
	@GenericGenerator(name = "sequence_id", strategy = "frnds.collie.services.collie.idGenrator.UserIdGenerator")
	@GeneratedValue(generator = "sequence_id")
	@Column(name = "user_id")
	private String userId;

	@Column(name = "USER_ROLE_ID")
	private String userRoleDetails;

	@Column(name = "FIRSTNAME")
	private String firstName;

	@Column(name = "LASTNAME")
	private String lastName;

	@Column(name = "MIDDLENAME")
	private String middleName;

	@Column(name = "Other_Delievery_Address", nullable = true)
	private String otherAddresses;

	@Column
	private String gender;

	@Column
	private String location;

	@Column
	private String primaryPhone;

	@Column
	private String secondaryPhone;

	@Column(name="User_Name")
	private String userName;

	@Column(nullable = true)
	private String pancard;

	@Column
	private String aadharcard;

	@Column
	private String voterID;

	@Column
	private String isActive;

	@Column
	private String photoId;

	private String panditId;

	private String addressId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DOB", columnDefinition = "DATETIME")
	private Date dob;

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPrimaryPhone() {
		return primaryPhone;
	}

	public void setPrimaryPhone(String primaryPhone) {
		this.primaryPhone = primaryPhone;
	}

	public String getSecondaryPhone() {
		return secondaryPhone;
	}

	public void setSecondaryPhone(String secondaryPhone) {
		this.secondaryPhone = secondaryPhone;
	}

	public String getPancard() {
		return pancard;
	}

	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	public String getAadharcard() {
		return aadharcard;
	}

	public void setAadharcard(String aadharcard) {
		this.aadharcard = aadharcard;
	}

	public String getVoterID() {
		return voterID;
	}

	public void setVoterID(String voterID) {
		this.voterID = voterID;
	}

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getPhotoId() {
		return photoId;
	}

	public void setPhotoId(String photoID) {
		this.photoId = photoID;
	}

	public String getUserRoleDetails() {
		return userRoleDetails;
	}

	public void setUserRoleDetails(String userRoleDetails) {
		this.userRoleDetails = userRoleDetails;
	}

	public String getPanditId() {
		return panditId;
	}

	public void setPanditId(String panditId) {
		this.panditId = panditId;
	}

	public String getAddressId() {
		return addressId;
	}

	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOtherAddresses() {
		return otherAddresses;
	}

	public void setOtherAddresses(String otherAddresses) {
		this.otherAddresses = otherAddresses;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
