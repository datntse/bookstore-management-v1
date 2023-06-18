/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.order;

import java.io.Serializable;
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

public class OrderDTO implements Serializable{
    private String orderId;
    private String userId;
    private double totalPrice;
    private String date;
}

