/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command.Manager;

import Service.Interfaces.*;
import java.util.Stack;

/**
 *
 * @author AUTONOMA
 */
public class CalculadoraStandarManager {
    public Stack<IHistory> st = new Stack();
    
    public void Execute(ICommand comando){
        comando.Execute();
    }
    
}
