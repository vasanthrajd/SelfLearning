package com.vasanth.client;
import java.util.Date;
/**
 * Created with IntelliJ IDEA.
 * User: ee206105
 * Date: 3/22/17
 * Time: 3:21 PM
 * To change this template use File | Settings | File Templates.
 */
public class MuserInfo {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String securityRoleId;
    private int customerId;
    private char changePassword;
    private int remainingLoginRetryNumber;
    private String externalEmail;
    private char isPasswordEncrypted;
    private char isPasswordSalted;
    private char isPasswordSaltedLower;
    private int timeZoneId;
    private String contactPhone;
    private int createdByMuserWid;
    private String comments;
    private Date createdAt;
    private Date lastModified;
    private String locale;
    private char isdeleted;
    private boolean ssoCustomer;

    public MuserTimeZone muserTimeZone;
    public CustomerFeature customerFeature;
    public MuserSearchFilter muserSearchFilter;
    public MuserSearchFilterStatus muserSearchFilterStatus;
    public CustomerDetails customerDetails;
    public AccountType accountType;
    public LicenseType licenseType;
	
    public MuserTimeZone getMuserTimeZone() {
		return muserTimeZone;
	}
	public void setMuserTimeZone(MuserTimeZone muserTimeZone) {
		this.muserTimeZone = muserTimeZone;
	}
	

    
}
class MuserTimeZone
{
    private int id;
    private String name;
    private String description;
    private String shortDesc;

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getDescription() {
        return description;
    }

    void setDescription(String description) {
        this.description = description;
    }

    String getShortDesc() {
        return shortDesc;
    }

    void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

	public MuserTimeZone() {
		super();
	}

	@Override
	public String toString() {
		return "MuserTimeZone [id=" + id + ", name=" + name + ", description=" + description + ", shortDesc="
				+ shortDesc + "]";
	}
    
    
}
class CustomerFeature
{
    private int id;
    private int customerId;
    private String featureId;

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    int getCustomerId() {
        return customerId;
    }

    void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    String getFeatureId() {
        return featureId;
    }

    void setFeatureId(String featureId) {
        this.featureId = featureId;
    }
}
class MuserSearchFilter
{
    private int id;
    private int muserId;
    private String criteria;

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    int getMuserId() {
        return muserId;
    }

    void setMuserId(int muserId) {
        this.muserId = muserId;
    }

    String getCriteria() {
        return criteria;
    }

    void setCriteria(String criteria) {
        this.criteria = criteria;
    }
}
class MuserSearchFilterStatus
{
    private int id;
    private int muserId;
    private String criteria;
    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    int getMuserId() {
        return muserId;
    }

    void setMuserId(int muserId) {
        this.muserId = muserId;
    }

    String getCriteria() {
        return criteria;
    }

    void setCriteria(String criteria) {
        this.criteria = criteria;
    }
}
class CustomerDetails
{
    private String name;
    private int accountTypeId;
    private char isBlueprintEnabled;

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    int getAccountTypeId() {
        return accountTypeId;
    }

    void setAccountTypeId(int accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    char getBlueprintEnabled() {
        return isBlueprintEnabled;
    }

    void setBlueprintEnabled(char blueprintEnabled) {
        isBlueprintEnabled = blueprintEnabled;
    }
}

class AccountType
{
    private int id;
    private char noChangePasswordOnHome;

    int getId() {
        return id;
    }

    void setId(int id) {
        this.id = id;
    }

    char getNoChangePasswordOnHome() {
        return noChangePasswordOnHome;
    }

    void setNoChangePasswordOnHome(char noChangePasswordOnHome) {
        this.noChangePasswordOnHome = noChangePasswordOnHome;
    }
}

class LicenseType
{
    private String id;
    private String name;

    String getId() {
        return id;
    }

    void setId(String id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }
}



