/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity.Implementation;
import Entity.Core.*;
import Service.Interfaces.*;
/**
 *
 * @author AUTONOMA
 */
public class CalculadoraImpl extends CalculadoraBase implements IOperationStandar {
    
    public CalculadoraImpl(double numero) {
        super(numero);
    }

    @Override
    public double Sumar(double n) {
        return this.numero+=n;
    }

    @Override
    public double Restar(double n) {
        return this.numero-=n;
    }

    @Override
    public double Multiplicar(double n) {
        return this.numero*=n;
    }

    @Override
    public double Dividir(double n) {
        return this.numero/=n;
    }

    public double getNumero() {
        return numero;
    }
    
}
