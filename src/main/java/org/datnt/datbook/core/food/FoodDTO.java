/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.datnt.datbook.core.food;

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

public class FoodDTO implements Serializable{
    private String foodId;
    private String foodName;
    private int foodQuantity;
    private double foodPrice;
    private String foodType;
    private boolean isDisable;
    private String image;
}

