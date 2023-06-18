/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.account;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author datnt
 */
public class AccountRegisterError implements Serializable {
    private String userNameLengthError;
    private String passwordLengthError;
    private String fullNameLengthError;
    private String confirmNotMatched;
    private String userNameIsExisted;

    public AccountRegisterError() {
    }

    public AccountRegisterError(String userNameLengthError, String passwordLengthError, String fullNameLengthError, String confirmNotMatched, String userNameIsExisted) {
        this.userNameLengthError = userNameLengthError;
        this.passwordLengthError = passwordLengthError;
        this.fullNameLengthError = fullNameLengthError;
        this.confirmNotMatched = confirmNotMatched;
        this.userNameIsExisted = userNameIsExisted;
    }

    public String getUserNameLengthError() {
        return userNameLengthError;
    }

    public String getPasswordLengthError() {
        return passwordLengthError;
    }

    public String getFullNameLengthError() {
        return fullNameLengthError;
    }

    public String getConfirmNotMatched() {
        return confirmNotMatched;
    }

    public String getUserNameIsExisted() {
        return userNameIsExisted;
    }

    public void setUserNameLengthError(String userNameLengthError) {
        this.userNameLengthError = userNameLengthError;
    }

    public void setPasswordLengthError(String passwordLengthError) {
        this.passwordLengthError = passwordLengthError;
    }

    public void setFullNameLengthError(String fullNameLengthError) {
        this.fullNameLengthError = fullNameLengthError;
    }

    public void setConfirmNotMatched(String confirmNotMatched) {
        this.confirmNotMatched = confirmNotMatched;
    }

    public void setUserNameIsExisted(String userNameIsExisted) {
        this.userNameIsExisted = userNameIsExisted;
    }

    
}
