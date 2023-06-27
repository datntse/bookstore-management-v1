/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author datnt
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AccountDTO {
    private String id;
    private String username;
    private String password;
    private String fullName;
    private boolean role;
    private boolean disable;
   
    
}
