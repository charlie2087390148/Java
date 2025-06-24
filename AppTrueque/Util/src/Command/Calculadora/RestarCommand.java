/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Command.Calculadora;

import Entity.Implementation.CalculadoraImpl;
import Service.Interfaces.ICommand;

/**
 *
 * @author AUTONOMA
 */
public class RestarCommand implements ICommand {
    
    private CalculadoraImpl impl;

    public RestarCommand(CalculadoraImpl impl) {
        this.impl = impl;
    }
            
    @Override
    public void Execute() {
        impl.Restar(impl.getNumero());
    }

    @Override
    public void undo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
