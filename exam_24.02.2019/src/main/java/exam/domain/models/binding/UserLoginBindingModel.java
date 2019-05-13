package exam.domain.models.binding;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserLoginBindingModel {
	private String userName;
	private String password;

	public UserLoginBindingModel() {
	}

	@NotNull(message = "can not be empty!")
	@Size(min = 1, message = "can not be empty")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@NotNull(message = "can not be empty!")
	@Size(min = 1, message = "can not be empty")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
