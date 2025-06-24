/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Implementation;

import Command.Calculadora.*;
import Command.Manager.CalculadoraStandarManager;
import Service.Interfaces.IOperationStandar;

/**
 *
 * @author AUTONOMA
 */
public class CalculadoraBasic implements IOperationStandar{
    private CalculadoraStandarManager _manager;
    private CalculadoraImpl _impl;

    public CalculadoraBasic(double numero) {
        this._impl = new CalculadoraImpl(numero);
    }
    
    
    @Override
    public double Sumar(double n) {
        _manager.Execute(new SumarCommand(_impl));
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double Restar(double n) {
        _manager.Execute(new RestarCommand(_impl));
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double Multiplicar(double n) {
        _manager.Execute(new MultiplicarCommand(_impl));
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public double Dividir(double n) {
        _manager.Execute(new DividirCommand(_impl));
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
