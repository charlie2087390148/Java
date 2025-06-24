/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command.Calculadora;

import Entity.Implementation.*;
import Service.Interfaces.*;

/**
 *
 * @author AUTONOMA
 */
public class SumarCommand implements ICommand {
    
    private CalculadoraImpl impl;

    public SumarCommand(CalculadoraImpl impl) {
        this.impl = impl;
    }
            
    @Override
    public void Execute() {
        impl.Sumar(impl.getNumero());
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
