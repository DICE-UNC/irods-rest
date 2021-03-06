/**
 * 
 */
package org.irods.jargon.rest.commands.user;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

import org.jboss.resteasy.annotations.providers.jaxb.json.BadgerFish;

/**
 * Represents a response to the add user command
 * 
 * @author Mike Conway - DICE (www.irods.org)
 */
@XmlRootElement(name = "userAddActionResponse")
@BadgerFish
public class UserAddActionResponse {

	public enum UserAddActionResponseCode {
		SUCCESS, USER_NAME_IS_TAKEN, TEMPORARY_ERROR_TRY_AGAIN, SMIME_SIGNATURE_INVALID, FAILED_TO_DECRYPT_SMIME_MESSAGE, FAILED_TO_PARSE_MESSAGE, ATTRIBUTES_MISSING, INTERNAL_ERROR
	}

	private UserAddActionResponseCode userAddActionResponse;
	private int userAddActionResponseNumericCode = 0;
	private String message;
	private String userName;
	/**
	 * Optional URL for web access
	 */
	private String webAccessURL = "";

	/**
	 * iRODS env settings for this user/grid
	 */
	private String irodsEnv = "";

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("UserAddActionResponse");
		sb.append("\n\t userAddActionResponse:");
		sb.append(userAddActionResponse);
		sb.append("\n\t message:");
		sb.append(message);
		sb.append("\n\t userName:");
		sb.append(userName);
		return sb.toString();
	}

	/**
	 * @return the userAddActionResponse
	 */
	@XmlAttribute
	public UserAddActionResponseCode getUserAddActionResponse() {
		return userAddActionResponse;
	}

	/**
	 * Return numeric response code
	 * 
	 * @return
	 */
	@XmlAttribute
	public int getUserAddActionResponseNumericCode() {
		return userAddActionResponseNumericCode;
	}

	public void setUserAddActionResponseNumericCode(
			final int userAddActionResponseNumericCode) {
		this.userAddActionResponseNumericCode = userAddActionResponseNumericCode;
	}

	/**
	 * @param userAddActionResponse
	 *            the userAddActionResponse to set
	 */
	public void setUserAddActionResponse(
			final UserAddActionResponseCode userAddActionResponse) {
		this.userAddActionResponse = userAddActionResponse;
		userAddActionResponseNumericCode = userAddActionResponse.ordinal();
	}

	/**
	 * @return the message
	 */
	@XmlAttribute
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(final String message) {
		this.message = message;
	}

	/**
	 * @return the userName
	 */
	@XmlAttribute
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(final String userName) {
		this.userName = userName;
	}

	@XmlAttribute
	public String getWebAccessURL() {
		return webAccessURL;
	}

	public void setWebAccessURL(final String webAccessURL) {
		this.webAccessURL = webAccessURL;
	}

	@XmlAttribute
	public String getIrodsEnv() {
		return irodsEnv;
	}

	public void setIrodsEnv(final String irodsEnv) {
		this.irodsEnv = irodsEnv;
	}

}
